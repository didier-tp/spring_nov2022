package tp.appliSpring.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import tp.appliSpring.core.MySpringApplication;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//java -Dspring.profiles.active=dev,initDataSet possible dans .bat ou .sh 
		//qui démarre tomcat
		System.setProperty("spring.profiles.active", "initDataSet");
		AnnotationConfigWebApplicationContext contextSpringWeb = 
				new AnnotationConfigWebApplicationContext();
		contextSpringWeb.register(MySpringApplication.class);
		servletContext.addListener(new ContextLoaderListener (contextSpringWeb ));
	}

}
