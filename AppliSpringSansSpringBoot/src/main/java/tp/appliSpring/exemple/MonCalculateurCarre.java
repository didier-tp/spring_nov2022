package tp.appliSpring.exemple;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Scope("singleton")
public class MonCalculateurCarre implements MonCalculateur {

	public double calculer(double x) {
		return x*x;
	}

}
