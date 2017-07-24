package springmvc.java.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		/**
		*
		*ApplicationContext Service
		*
		**/
		
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		/*
		*
		*MVC Config Classes
		*paths will be mapped inside this configuration clas
		*/
		return new  Class[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
	
		return new String[] {"/"};
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		servletContext.addFilter("springSecurityFilterChain",new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null,false,"/*");
		
		super.onStartup(servletContext);
	}
	
}
