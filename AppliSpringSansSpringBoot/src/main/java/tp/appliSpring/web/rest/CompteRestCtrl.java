package tp.appliSpring.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
//...
@RequestMapping(value="/api-bank/compte" , headers="Accept=application/json")
public class CompteRestCtrl {

	
	//URL http://localhost:8080/applispringSansSpringBoot/mvc/api-rest/compte/1
	
	//URL http://localhost:8080/applispringSansSpringBoot/mvc/api-rest/compte
	//ou  http://localhost:8080/applispringSansSpringBoot/mvc/api-rest/compte?soldeMini=50
}
