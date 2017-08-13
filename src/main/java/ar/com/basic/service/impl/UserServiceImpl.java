package ar.com.basic.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.basic.dao.UserDAO;
import ar.com.basic.dao.impl.User;
import ar.com.basic.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User findUserById(long id) {
		
		return userDAO.findOne(id);
	}

	@Override
	public User findUserWithBlogPostByUsername(String username) {
		
		return userDAO.findUserByUsername(username);
	}
	
	@Override
	public void saveUser(User user) {
		
		LOGGER.debug("UserServiceImpl: saveUser is called");
		userDAO.save(user);
	}

	@Override
	public Boolean findUserByEmail(String email) {
		
		
		return userDAO.equals(email);
	}

}
