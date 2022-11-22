package tp.appliSpring.exemple;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import tp.appliSpring.annotation.Aff;

@Component
//@Lazy
//@Scope("singleton")
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) //par defaut
/*
 scopes possibles:
 ConfigurableBeanFactory.SCOPE_SINGLETON
 ConfigurableBeanFactory.SCOPE_PROTOTYPE
 WebApplicationContext.SCOPE_REQUEST 
 WebApplicationContext.SCOPE_SESSION
 ...
 */
public class MonCalculateurCarre implements MonCalculateur {

	public double calculer(double x) {
		return x*x;
		
	}

}
