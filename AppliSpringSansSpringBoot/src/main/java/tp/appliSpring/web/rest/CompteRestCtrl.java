package tp.appliSpring.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tp.appliSpring.core.entity.Compte;
import tp.appliSpring.core.service.ServiceCompte;
@RestController
@RequestMapping(value="/api-bank/compte" , headers="Accept=application/json")
public class CompteRestCtrl {
	
	@Autowired
	private ServiceCompte serviceCompte;

	
	//URL http://localhost:8080/applispringSansSpringBoot/mvc/api-rest/compte/1
	//@RequestMapping(value="/{numCompte}" , method=RequestMethod.GET) 
	@GetMapping(value="/{numCompte}")
	public Compte getCompteByNum(@PathVariable("numCompte") Long numCompte) { 
	      return serviceCompte.rechercherCompteParNumero(numCompte) ;
	}

	
	//URL http://localhost:8080/applispringSansSpringBoot/mvc/api-rest/compte
	//ou  http://localhost:8080/applispringSansSpringBoot/mvc/api-rest/compte?soldeMini=120
	@GetMapping(value="")
	public List<Compte> getComptesByCriteria(@RequestParam(value="soldeMini",required=false)Double soldeMini) {
		List<Compte> comptes = serviceCompte.rechercherTousComptes();
	 if(soldeMini==null)
	     return comptes;
	 else{
	     return comptes.stream().filter( c -> (c.getSolde() >= soldeMini) ).toList();
	 }
	}
}
