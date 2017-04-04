package org.lucius.xlucius.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.lucius.xlucius.spi.model.User;
import org.lucius.xlucius.spi.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
	
	private static final String MAPPER_NAMESPACE = UserService.class.getName() + ".";
	
	public UserService(){
		System.out.println("初始化UserService...");
	}
	
	@Resource
	private SqlSession sqlSession;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> queryUsers() {
		return sqlSession.selectList(MAPPER_NAMESPACE + "queryAllUsers");
	}

}
