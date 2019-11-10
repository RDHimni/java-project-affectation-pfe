package metie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import decorator.Etudiant;
import decorator.ProfEncadrant;
import decorator.StageEncadrant;
import factory.Factory;

/**
 * @author dhimni rida
 *Nov 2, 2019
 * affectat
 */

public class Metie implements IMetie {



	
	public Metie() {


	}
	
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////	

	public  Boolean Exist(List<Etudiant> listetudiant, Etudiant etudiand) {
		return listetudiant.contains(etudiand);
	}

	public  Boolean Exist(List<ProfEncadrant> listprofs, ProfEncadrant prof) {
		return listprofs.contains(prof);
	}

	public  Boolean Exist(List<StageEncadrant> liststageenca, StageEncadrant stageenca) {
		return liststageenca.contains(stageenca);
	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////		
	
	public ProfEncadrant getProfsByName(Set<ProfEncadrant> listprofs,String profFirstName,String profLastName) {
		
		ProfEncadrant prof = listprofs.stream()
				.filter(p->p.getFirstName().equalsIgnoreCase(profFirstName) && p.getLastName().equalsIgnoreCase(profLastName))
				.findAny()
				.orElse(null);
				 
		return prof;
	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static int Random(int size){		
return new Random().nextInt(size);
}


}
