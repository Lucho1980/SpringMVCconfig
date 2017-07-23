package springmvc.java.dao;

import org.springframework.data.repository.CrudRepository;

import springmvc.java.domain.User;

public interface UserDAO extends CrudRepository<User, Long> {

	//meter metodos customizados que no son básicos
	
		//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
		//Example 13
	
	User findUserByUsername(String username);
}
