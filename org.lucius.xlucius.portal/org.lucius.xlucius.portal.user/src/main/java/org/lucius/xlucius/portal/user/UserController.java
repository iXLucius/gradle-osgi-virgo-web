package org.lucius.xlucius.portal.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lucius.framework.model.page.PageContext;
import org.lucius.framework.model.page.Pagination;
import org.lucius.framework.utils.captcha.Captcha;
import org.lucius.framework.utils.captcha.Constant;
import org.lucius.framework.utils.captcha.GifCaptcha;
import org.lucius.framework.utils.encrypt.HexMD5Util;
import org.lucius.framework.utils.export.ExportUtil;
import org.lucius.framework.utils.export.LangCode;
import org.lucius.framework.utils.export.ModuleEnum;
import org.lucius.framework.utils.export.PoiExportUtils;
import org.lucius.framework.utils.file.FileUtils;
import org.lucius.framework.utils.http.HttpsClientUtil;
import org.lucius.xlucius.spi.model.User;
import org.lucius.xlucius.spi.service.IUserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Resource
	private IUserService userService;
	
	// http://localhost:8080/xlucius/user/app/user/login?_PAGINATION_FLAG_=_PAGINATION_REQUIRED_&pageNo=1&pageSize=10&pageIndexSize=11
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) throws UnsupportedEncodingException, Exception {
		Pagination<User> pagination = new Pagination<User>(PageContext.getPageNo(), PageContext.getPageSize(), 20,
				PageContext.getPageIndexSize());
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUsername("lucius" + i);
			user.setPassword("password" + i);
			user.setAge(25 + i);
			users.add(user);
		}
		users = userService.queryUsers();
		pagination.setList(users);
		model.addAttribute(pagination);
		model.addAttribute("password", HexMD5Util.getEncryptedPwd("123456"));
		model.addAttribute("filepath", FileUtils.buildFilePath(UUID.randomUUID().toString()));
		model.addAttribute("webpage", HttpsClientUtil.doGetRequest("https://www.baidu.com/", null));
		return "login";
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) throws UnsupportedEncodingException, Exception {
		Pagination<User> pagination = new Pagination<User>(PageContext.getPageNo(), PageContext.getPageSize(), 20,
				PageContext.getPageIndexSize());
		List<User> users = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUsername("lucius" + i);
			user.setPassword("password" + i);
			user.setAge(25 + i);
			users.add(user);
		}
		users = userService.queryUsers();
		pagination.setList(users);
		model.addAttribute(pagination);
		model.addAttribute("password", HexMD5Util.getEncryptedPwd("123456"));
		model.addAttribute("filepath", FileUtils.buildFilePath(UUID.randomUUID().toString()));
		model.addAttribute("webpage", HttpsClientUtil.doGetRequest("https://www.baidu.com/", null));
		return "index";
	}

	/**
	 * 生成验证码
	 * 
	 * @param session
	 *            session
	 * @param response
	 *            response
	 * @throws IOException
	 *             IOException
	 */
	// http://localhost:8080/xlucius/user/app/user/captcha.jpg
	@RequestMapping(value = "/captcha.jpg", method = RequestMethod.GET)
	public void getCaptcha(HttpSession session, HttpServletResponse response) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		// headers.setContentType(MediaType.IMAGE_GIF);
		headers.setContentType(MediaType.IMAGE_PNG);
		// CaptchaUtils tool = new CaptchaUtils();
		// StringBuffer code = new StringBuffer();
		// BufferedImage image = tool.genRandomCodeImage(code);
		Captcha captcha = new GifCaptcha(120, 30, 4);// gif格式动画验证码
		// Captcha captcha = new SpecCaptcha(120, 30, 4);// png格式动画验证码
		captcha.out(response.getOutputStream());
		session.removeAttribute(Constant.DEFAULT_CAPTCHA_PARAM);
		session.setAttribute(Constant.DEFAULT_CAPTCHA_PARAM, captcha.text());
		// ImageIO.write(image, "JPEG", response.getOutputStream());
		return;
	}

	// http://localhost:8080/xlucius/user/app/user/exportTop10
	@RequestMapping("/exportTop10")
	public void exportTop10(HttpServletRequest request, HttpServletResponse response) {
		try {

			StringBuilder str = new StringBuilder();
			str.append("keywords retrieval-Top 10").append("-");
			ModuleEnum moduleEnum = ModuleEnum.KEYWORD_COUNT_TOP10;
			// fileName += "_" + DatetimeUtils.currentDateTime();
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment;fileName=" + str.toString() + ".xls");

			String sheetfileName = "search statistics";
			
			List<User> users = new ArrayList<User>();
			for (int i = 0; i < 10; i++) {
				User user = new User();
				user.setUsername("lucius" + i);
				user.setPassword("lucius" + i);
				user.setAge(25 + i);
				users.add(user);
			}
			
			ExportUtil.exportExcel(sheetfileName, response.getOutputStream(), moduleEnum, LangCode.getLang("ZH_CN"),
					users);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// http://localhost:8080/xlucius/user/app/user/export2
	@RequestMapping("/export2")
	public void export2(HttpServletRequest request, HttpServletResponse response) {
		try {
			PoiExportUtils export = new PoiExportUtils();
			List<User> users = new ArrayList<User>();
			for (int i = 0; i < 10; i++) {
				User user = new User();
				user.setUsername("lucius" + i);
				user.setPassword("lucius" + i);
				user.setAge(25 + i);
				users.add(user);
			}
			response.setContentType("applicationnd.ms-excel");
			response.setHeader("Content-disposition", "attachment; filename=manage_feedback_"
					+ new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date()) + ".xls");
			export.exportExcel("feedbackTable", users, User.class, "yyyy-MM-dd", response.getOutputStream(), null,
					null);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(HexMD5Util.getEncryptedPwd("123456"));
	}
}
