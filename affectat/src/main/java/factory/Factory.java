package factory;

import decorator.Etudiant;
import decorator.Person;
import decorator.ProfEncadrant;
import decorator.StageEncadrant;

/**
 * @author dhimni rida
 *Nov 2, 2019
 * affectat
 */

public class Factory implements IFactory{

	public Etudiant getInstance(String Etudiand_firstname, String Etudiand_Lastname) {
		return new Etudiant(new Person(Etudiand_firstname,Etudiand_Lastname));
	}

	public ProfEncadrant getInstance(String ProfEncadrant_firstname, String ProfEncadrant_Lastname, int Cap,
			String Etablissement) {
		return new ProfEncadrant(new Person(ProfEncadrant_firstname, ProfEncadrant_Lastname), Cap, Etablissement);
	}

	public StageEncadrant getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
