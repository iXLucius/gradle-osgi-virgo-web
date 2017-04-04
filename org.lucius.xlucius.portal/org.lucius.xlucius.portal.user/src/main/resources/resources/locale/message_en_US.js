var user = {
	email:{
		isNotNULL : "邮箱不能为空",
		lengthError : "邮箱长度不超过50个字符",
		formatError : "E-Mail格式不正确",
		alreadlyExist : "该邮箱已被注册",
		auditFail : "账号未通过审核，请在审核邮件中重新提交申请",
		innerError : "服务器内部错误"
	},
	tipinfo:{
		verifyCode : "（请输入您邮件中收到的验证码）",
		verifyCode_pic : "（请输入下方图片中的字符，不区分大小写）",
		password : "（请填写密码）",
		new_password : "（密码由6-20位字母、数字或符号组成）",
		confirm_password : "（请再次确认您设置的密码）",
		security_mail : "（此邮箱为新登录邮箱，请填写常用邮箱）"
	},
	psd:{
		loginNameNull : "请填写帐号",
		isNotNULL : "请填写密码",
		lengthError : "密码长度不正确[6-16]位",
		formatError : "密码格式不正确（密码为6-16个字符，由英文、数字组成）",
		wrongConfirmPsd : "确认密码输入不一致",
		//TODO
		pleaseEntnewPassword:'请输入新密码',
		pleaseEntSureNewPassword:'请输入确认新密码',
		newPasswordLength:'新密码长度为6到20个字',
		sureNewPasswordLength:'确认新密码长度为6到20个字',
		onlyNumber:'密码是字母和数字组合，也可含特殊字符',
		sureNewPasswordNotSameNewPassword:'确认新密码与新密码不一致'
	},
	company:{
		isNotNULL : "企业名称不能为空",
		formatError : "企业名称只能输入中文或英文",
		lengthError : "企业名称长度不超过50个字符",
		regNoIsNotNULL : "请上传营业执照图片"
		
	},
	legal:{
		isNotNULL : "法人名称不能为空",
		lengthError : "法人名称长度不超过50个字符",
		formatError : "法人名称只能输入中文或英文 "
	},
	legalNO:{
		isNotNULL : "法人身份证号不能为空",
		lengthError : "法人身份证号长度为18个字符",
		formatError : "法人身份证号格式不正确"
	},
	tel:{
		isNotNULL : "联系电话不能为空",
		areaCodeFormatError : "电话区号[3-4]位数字",
		noFormatError : "电话号码[7-8]位数字 ",
		extNoFormatError : "分机号[1-6]位数字",
		mobileLengthError : "手机号码为11位,且只能输入数字 ",
		mobileFormatError : "手机号码格式不正确"
	},
	region:{
		streetAddrIsNotNULL : "街道地址不能为空",
		streetLength : "街道地址长度不超过50字符",
		chooseProvice : "请选择省份 ",
		chooseCity : "请选择城市",
		chooseRegion : "请选择地区 ",
		streetAddrRequire : "街道地址长度不超过50字符"
	},
	common:{
		isNotNULL : "联系人姓名不能为空",
		linkNameLengthError : "联系人名称不超过10个字符",
		linkNameFormatError : "联系人名称只能输入中文或英文",
		fileFormatError : "文件格式不对,请重新上传 ",
		choosePlease : "请选择 ",
		inputVolifyCode : "请输入验证码 ",
		inputCheckCode : "请输入校验码 ",
		reSend : "重新发送",
		inputPicVolifyCode : "请输入图形验证码"
	},
	server:{
		Error_PriceType: "定价类型异常",
		Error_Upload_Success: "上传成功",
		Error_Upload_Fail: "上传失败",
		Error_Account: "登录失败:您帐号或密码错误",
		Error_verifyCode: "验证码输入错误",
		Error_addUser_fail: "新增用户失败",

		Constant_mail_sendSuccess: "邮件发送成功",
		Constant_mail_sendFail: "邮件发送失败",
		Constant_account_not_exist_error : '账号不存在',
		Constant_obtainResetCode_error: "获取重置码失败",
		Constant_picVerifyCode_error: "图形验证码错误",
		Constant_picVerifyCode_invalid:"图形验证码失效",
		Constant_verifyCode_error: "验证码错误",
		Constant_resetPsd_success: "您的新密码重置成功",
		Constant_resetPsd_fail: "您的新密码重置失败",

		Constant_updateMail_success: "您的新邮箱修改成功",
		Constant_updateMail_fail: "您的新邮箱修改失败",
		Constant_updatePsd_success: "您的新密码修改成功",
		Constant_updatePsd_fail: "您的新密码修改失败",
		Constant_OFFINE_NOSPDATA: "线下销售无须同步安全策略数据到RAS",

		Excption_GID_invalid: "商品编号无效",
		Excption_UID_invalid: "用户编号无效",
		Excption_BID_invalid: "品牌编号无效",
		Excption_Price_noInfo: "无此商品定价信息",
		Excption_SHOPID_invalid: "店铺编号无效",
		Excption_CONTENTID_invalid: "内容编号无效",

		Excption_Amount_invalid: "金额格式错误",
		Excption_RAS_SYNCH: "同步安全策略数据RAS异常",
		Excption_RAS_TIMEOUT: "同步安全策略数据RAS连接超时",
		Excption_other: "系统异常！",
		Excption_SC_UserNotExist: "查询session[Sc_User_Info]不存在",
		Excption_SHOP_NotExist: "该店铺不存在",
		Excption_SHOP_NOTMember: "该店铺未开通会员功能",
		Excption_AddGGN: "新增品牌组失败",

		Constant_MYGGN: "我的品牌组",
		Constant_GGN_Default: "默认品牌组",
		Constant_BrandExist: "该品牌已存在",
		Constant_add_success: "保存成功",
		Constant_add_fail: "保存失败",
		Constant_del_success: "删除成功",
		Constant_del_fail: "删除失败",
		Constant_PID_invalid: "定价编号无效",
		Constant_price_invalid: "价格不能为负数",
		Constant_Bind_success: "定价编号绑定成功",
		Constant_Bind_fail: "定价编号绑定失败",
		Constant_Level_delFail: "当前等级存在店铺会员,删除失败",
		Constant_Level_Exist: "该店铺已经添加当前等级",
		Constant_RAS_SYNCH_SUCCESS: "同步安全策略到RAS成功",
		Constant_RAS_SYNCH_FAIL: "同步安全策略到RAS失败",
		Constant_WRONG_SYSID: "请选择正确登录窗口",
		Constant_Brand_manager: "请设置您的品牌",

		Constant_QueryDefaultPrice_fail: "查询商品默认价失败",
		Constant_priceSynch_fail: "商品价格同步失败",
		Constant_Goods_isExist: "该商品已经添加,请重新选择",
		Constant_session_out: "session失效",
		Constant_LevelVIP_NotExist: "店铺未设置VIP会员等级",
		Constant_Level_NotMatch: "店铺会员等级校验不匹配",
		Constant_PIC_SIZE_PROMPT: "上传图片大小不能超过2M"
	}
}