package ar.com.basic.service;

import ar.com.basic.dao.impl.User;

public interface UserService {
	
	void saveUser(User user);
	User findUserById(long id);
	User findUserWithBlogPostByUsername(String username);
	Boolean findUserByEmail(String email);
	
}
