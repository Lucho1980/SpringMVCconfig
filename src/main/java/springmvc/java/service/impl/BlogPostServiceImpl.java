package springmvc.java.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc.java.dao.BlogPostDAO;
import springmvc.java.domain.BlogPost;
import springmvc.java.domain.User;
//import springmvc.java.domain.DataSource;
import springmvc.java.service.BlogPostService;
//import springmvc.java.service.EmailService;

public class BlogPostServiceImpl implements BlogPostService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	@Autowired
	private BlogPostDAO blogPostDAO;
	
//	@Autowired
//	private DataSource dataSource;
	
//	@Autowired
//	private EmailService emailService;
	
	@Override
	public void savePost(BlogPost blogPost) {		
		
		//LOGGER.debug("BlogPostServiceImpl: "+dataSource.getUrl());
		LOGGER.debug("BlogPostServiceImpl: savePost is called");
		blogPost.setPublishDate(new Date());
		blogPostDAO.save(blogPost);//Metodo propio save
		
		//emailService.sendEmail(); Elimina las formas antiguas poesto que hibernate tiene metodos propios.
	}

	@Override
	public void saveAsDraft(BlogPost blogPost) {
		
		blogPost.setDraft(true);
		blogPostDAO.save(blogPost);
		
	}

	@Override
	public void deletePost(BlogPost blogPost) {
		blogPostDAO.delete(blogPost);
		
	}

	@Override
	public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogPost findBlogPostbyId(long id) {
		return blogPostDAO.findOne(id);
	}

}
