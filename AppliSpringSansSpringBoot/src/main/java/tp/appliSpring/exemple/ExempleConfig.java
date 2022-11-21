package tp.appliSpring.exemple;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * classe de configuration de composants "spring" (remplace les anciens fichiers xml)
 */

@Configuration
@ComponentScan(basePackages = { "tp.appliSpring.exemple" })
@PropertySource("classpath:/essai.properties") 
public class ExempleConfig {
	/*
	 @ComponentScan() pour demander à spring de parcourir les classes de certains packages
	 pour y trouver des annotations @Component , @Service , @Autowired à analyser et interpréter
	 */
	 
}
