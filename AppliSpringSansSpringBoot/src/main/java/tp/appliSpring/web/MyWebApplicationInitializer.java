package tp.appliSpring.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import tp.appliSpring.core.MySpringApplication;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	MyWebApplicationInitializer() {
		System.out.println("MyWebApplicationInitializer ...");
	}

	protected String[] getServletMappings() {
		return new String[] { "/mvc/*" }; // URL en :8080/.../mvc/...
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { MyWebAppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[0];
	}

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		super.onStartup(context);
		// String activeProfile = "";
		String activeProfile = "initDataSet";
		context.setInitParameter("spring.profiles.active", activeProfile);
	}
}

/*
 * public class MyWebApplicationInitializer implements WebApplicationInitializer
 * {
 * 
 * @Override public void onStartup(ServletContext servletContext) throws
 * ServletException { //java -Dspring.profiles.active=dev,initDataSet possible
 * dans .bat ou .sh //qui démarre tomcat
 * System.setProperty("spring.profiles.active", "initDataSet");
 * AnnotationConfigWebApplicationContext contextSpringWeb = new
 * AnnotationConfigWebApplicationContext();
 * contextSpringWeb.register(MySpringApplication.class);
 * servletContext.addListener(new ContextLoaderListener (contextSpringWeb )); }
 * 
 * }
 */