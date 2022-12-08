package fr.eni.demo.bll;

import fr.eni.demo.bo.Person;
import fr.eni.demo.dal.DAOFactory;
import fr.eni.demo.dal.DAOPerson;

public class PersonManager extends ManagerBase {
	
	public EniDemoResponse addPerson(Person person) {
		// Par defaut OK
		EniDemoResponse response = new EniDemoResponse(Constantes.CODE_SUCCESS, "person added successufuly");
		
		// j'appel La DAO pour mettre en base
		DAOFactory.getDAOByClass(DAOPerson.class).insert(person);
		
		DAOPerson daoPerson	= DAOFactory.getDAOByClass(DAOPerson.class);
		
		daoPerson.insert(person);
		
		// Erreur
		response.responseCode = 744;
		response.responseMessage = "lastname person already existed";
		
		return response;
	}
}
