package tp.appliSpring.exemple;

import org.springframework.stereotype.Component;

import tp.appliSpring.annotation.Aff;

@Component
@Aff
public class MonAfficheurV1 implements MonAfficheur {

	public void afficher(String message) {
		System.out.println(">> "+message);
	}

	public void afficherMaj(String message) {
		System.out.println(">> "+message.toUpperCase());
	}

}
