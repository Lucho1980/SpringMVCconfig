package ar.com.basic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.basic.dao.impl.User;
import ar.com.basic.service.ServiceManager;
import ar.com.basic.service.UserService;

public class ServiceManagerImpl implements ServiceManager{
	
	@Autowired
	private UserService userService;	
	
	@Override
	public void sendUser(User user) {
		userService.saveUser(user);
		
	}
	

}
