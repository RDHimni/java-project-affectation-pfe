package factory;

import decorator.Etudiant;
import decorator.ProfEncadrant;
import decorator.StageEncadrant;

/**
 * @author dhimni rida
 *Nov 2, 2019
 * affectat
 */

public interface IFactory {

	//creat Person (Etudiand/ProfEncadrant/stageEncadrant)
	
	Etudiant getInstance(String Etudiand_firstname,String Etudiand_Lastname);
	ProfEncadrant getInstance(String ProfEncadrant_firstname,String ProfEncadrant_Lastname,int Cap,String Etablissement);
    StageEncadrant getInstance();
}
