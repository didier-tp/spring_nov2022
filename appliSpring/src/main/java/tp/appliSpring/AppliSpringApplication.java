package tp.appliSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AppliSpringApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AppliSpringApplication.class, args);
		SpringApplication app = new SpringApplication(AppliSpringApplication.class);
		 app.setAdditionalProfiles("initDataSet","dev");
		 //app.setAdditionalProfiles("prod");
		 ConfigurableApplicationContext context = app.run(args);
		System.out.println("http://localhost:8080/appliSpring");
	}

}
