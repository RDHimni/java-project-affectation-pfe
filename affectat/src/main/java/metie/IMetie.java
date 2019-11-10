package metie;

import java.util.List;
import java.util.Map;
import java.util.Set;

import decorator.Etudiant;
import decorator.ProfEncadrant;
import decorator.StageEncadrant;

/**
 * @author dhimni rida
 *Nov 2, 2019
 * affectat
 */

public interface IMetie {
	
	Boolean  Exist(List<Etudiant> listetudiant ,Etudiant etudiand);
	Boolean  Exist(List<ProfEncadrant> listprofs,ProfEncadrant prof);
	Boolean  Exist(List<StageEncadrant> liststageenca,StageEncadrant stageenca);
	ProfEncadrant getProfsByName(Set<ProfEncadrant> listprofs,String profFirstName,String profLastName);
}
