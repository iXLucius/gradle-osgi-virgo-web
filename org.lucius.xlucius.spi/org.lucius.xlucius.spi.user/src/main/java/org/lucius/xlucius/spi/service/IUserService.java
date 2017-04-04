package org.lucius.xlucius.spi.service;

import java.util.List;

import org.lucius.xlucius.spi.model.User;

public interface IUserService {

	List<User> queryUsers();
	
}
