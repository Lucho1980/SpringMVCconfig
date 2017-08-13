package ar.com.basic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.basic.dao.impl.User;
import ar.com.basic.service.UserService;




@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUser(
			@RequestParam(value = "fn") String firstname,
			@RequestParam(value = "ln") String lastname,
			@RequestParam(value = "un") String username,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "pw") String password
			) {

		User user = new User();
		
		
		if(!userService.findUserByEmail(email)){
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(password);
			userService.saveUser(user);
		}
		else {
			System.out.println("el mail ya existe");
			
			
		}

		
		
		
		
			
			
		
		return new ModelAndView("index");
		
	}
	
}	
		
//		//blogPost.setUser(userService.findUserWithBlogPostByUsername("user"));
//		//Lo cambio para user Principal principal
//		blogPost.setUser(userService.findUserWithBlogPostByUsername(principal.getName()));
//
//		if (draft == true) {
//			blogPostService.saveAsDraft(blogPost);
//
//		} else {
//			blogPostService.savePost(blogPost);
//		}
//
//		return new ModelAndView("newblogpost", "message", messageSource.getMessage("blogpost.saved",null, locale));
//
//	}
//	
//	@RequestMapping(value="/blogposts", method = RequestMethod.GET)
//	public ModelAndView blogPosts(Principal principal){
//		
//		User user = userService.findUserWithBlogPostByUsername(principal.getName());
//		List<BlogPost> blogPosts = user.getBlogPost();
//		return new ModelAndView("blogposts", "blogposts",blogPosts);
//	}
//	
//	@RequestMapping(value="/draftblogposts", method = RequestMethod.GET)
//	public ModelAndView draftBlogPosts(Principal principal){
//		
//		User user = userService.findUserWithBlogPostByUsername(principal.getName());
//		List<BlogPost> draftBlogPosts = blogPostService.listAllBlogPostsByUserAndDraftStatus(user, true);
//		return new ModelAndView("blogposts", "blogposts",draftBlogPosts);
//	}
//	
//	@RequestMapping(value="/searchByTitle", method = RequestMethod.POST)
//	public ModelAndView searchByTitle(@RequestParam(value="title")String title,Principal principal){
//		
//		User user = userService.findUserWithBlogPostByUsername(principal.getName());
//		List<BlogPost> blogPosts = blogPostService.listAllBlogPostsByUserAndTitleLike(user, title);
//		return new ModelAndView("blogposts", "blogposts",blogPosts);
//	}
//	
//	@RequestMapping(value="/getBlogPostById/{id}", method = RequestMethod.GET)
//	@ResponseStatus(code=HttpStatus.OK)
//	public @ResponseBody BlogPost getBlogPostById(@PathVariable(value="id")long idBlogPost){
//		//Este responsebody le mente un jason(no se como funciona)
//		
//		return blogPostService.findBlogPostbyId(idBlogPost);
//	}

