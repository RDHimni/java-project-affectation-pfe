package metie;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import decorator.Etudiant;
import decorator.ProfEncadrant;
import factory.Factory;

/**
 * @author dhimni rida
 *Nov 2, 2019
 * affectat
 */


public class Affectation {
	
	
private	List<ProfEncadrant> listprofs ;
private	List<Etudiant> listEtudiants;
private	Map<Etudiant,List<ProfEncadrant>> affectation_trois_profs;

private Factory creator;


public Affectation() {
	 this.listEtudiants = new LinkedList<>();
	 this.listprofs = new LinkedList<>();
	 this.affectation_trois_profs = new HashMap<>();
	 this.creator = new Factory();
	 

}

	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*::::::::::::::::::::::::::::::::::::Partie_Affectation:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public List<ProfEncadrant> trois_profsA(List<ProfEncadrant> listprofsA){
		List<ProfEncadrant> trois_profs = new LinkedList<>();
		
		for (int i = 0; i < 3; i++) {
				int p =Metie.Random(listprofsA.size());
				while((listprofsA.get(p).getCap()==1 || listprofsA.get(p).getCap()==2) && listprofsA.get(p).getComp() == listprofsA.get(p).getCap()) {
				    {p =Metie.Random(listprofsA.size());}
				}
		
		switch(i) {
				case 0 : while(listprofsA.get(p).getComp() == listprofsA.get(p).getCap())p =Metie.Random(listprofsA.size());
					trois_profs.add(listprofsA.get(p));
					listprofsA.get(p).setIncrComp();
					break;
				case 1 : while(listprofsA.get(p).getComp() == listprofsA.get(p).getCap()
					|| listprofsA.get(p) == trois_profs.get(0))p = Metie.Random(listprofsA.size());
					trois_profs.add(listprofsA.get(p));
					listprofsA.get(p).setIncrComp();          
					break;
				case 2 : while(listprofsA.get(p).getComp() == listprofsA.get(p).getCap()
					|| listprofsA.get(p) == trois_profs.get(1)
					|| listprofsA.get(p) == trois_profs.get(0))p = Metie.Random(listprofsA.size());
					trois_profs.add(listprofsA.get(p));
					listprofsA.get(p).setIncrComp();          
					break;
				default:
			       	break;
				}
		
		}

return trois_profs;
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

public  List<ProfEncadrant> trois_profsB(List<ProfEncadrant> listprofsB){
		List<ProfEncadrant> trois_profsB = new LinkedList<>();
		
		for (int i = 0; i < 3; i++) {
				int p = Metie.Random(listprofsB.size());
				while((listprofsB.get(p).getCap()==1 || listprofsB.get(p).getCap()==2) && listprofsB.get(p).getComp() == listprofsB.get(p).getCap()) {
				    {p = Metie.Random(listprofsB.size());}
		}
		
		switch(i) {
				case 0 :   trois_profsB.add(listprofsB.get(p));
				           listprofsB.get(p).setIncrComp();
				            break;
				case 1 : while(listprofsB.get(p) == trois_profsB.get(0))p = Metie.Random(listprofsB.size());
							trois_profsB.add(listprofsB.get(p));
							listprofsB.get(p).setIncrComp();          
							break;
				case 2 : while(listprofsB.get(p) == trois_profsB.get(1) || listprofsB.get(p) == trois_profsB.get(0))p = Metie.Random(listprofsB.size());
							trois_profsB.add(listprofsB.get(p));
							listprofsB.get(p).setIncrComp();          
							break;
				default:
				     break;
		}

}


return trois_profsB;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public  Map<Etudiant, List<ProfEncadrant>> AffectationA(List<ProfEncadrant> listprofsA, List<Etudiant> listetudiantA){
		Map<Etudiant, List<ProfEncadrant>> AffectationA = new HashMap<>();
		
		for (int i = 0; i < listetudiantA.size(); i++) {
				List<ProfEncadrant> lA =trois_profsA(listprofsA);
				AffectationA.put(listetudiantA.get(i), lA);				
				listetudiantA.get(i).set_trois_prof_choix(lA);
		}

return AffectationA;
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//


public  Map<Etudiant, List<ProfEncadrant>> AffectationB(List<ProfEncadrant> listprofsB, List<Etudiant> listetudiantB){
			Map<Etudiant, List<ProfEncadrant>> AffectationB = new HashMap<>();
			
			for (int i = 0; i < listetudiantB.size(); i++) {
					List<ProfEncadrant> lB = trois_profsB(listprofsB);
					AffectationB.put(listetudiantB.get(i),lB);
					listetudiantB.get(i).set_trois_prof_choix(lB);
			}

return AffectationB;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public Map<Etudiant, List<ProfEncadrant>>  Affectation() {

			Map<Etudiant, List<ProfEncadrant>> Affectation = new HashMap<>();
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			List<ProfEncadrant> listprofsA = this.listprofs;
			List<Etudiant> listetudiant = this.listEtudiants;
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			int SC = 0;for (ProfEncadrant prof : listprofsA)SC += prof.getCap();
			int NA = SC/3 -2;
			List<Etudiant> listetudiantA = new LinkedList<>();
			List<Etudiant> listetudiantB = new LinkedList<>();
			
			for (int i = 0; i < NA; i++) {
			    listetudiantA.add(listetudiant.get(i));			
			}
			
			for (int i = NA; i < listetudiant.size() ; i++) {
			     listetudiantB.add(listetudiant.get(i));			
			}
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			List<ProfEncadrant> listprofsB = new LinkedList<>();
			listprofsB= (List<ProfEncadrant>) listprofsA.stream().filter(p->p.getCap()>2).collect(Collectors.toList());
			
			
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			Map<Etudiant, List<ProfEncadrant>> AffectationA = new HashMap<>();
			Map<Etudiant, List<ProfEncadrant>> AffectationB = new HashMap<>();
			AffectationA = AffectationA(listprofsA, listetudiantA);
			for (int i = 0; i < listprofsA.size() ; i++) {
					if (listprofsA.get(i).getCap() == 1 && listprofsA.get(i).getComp()==0) {
					listprofsB.add(listprofsA.get(i));			
			}
			if (listprofsA.get(i).getCap() == 2 && (listprofsA.get(i).getComp()==0 || listprofsA.get(i).getComp()==1)) {
		         	listprofsB.add(listprofsA.get(i));			
			}
			}
			AffectationB = AffectationB(listprofsB, listetudiantB);
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			Affectation.putAll(AffectationA);
			Affectation.putAll(AffectationB);
			//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//
			


return Affectation;
}
/////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
public boolean affectation_trois_profs_est_bien_passee() {	

					Etudiant checkedEtudiant = this.listEtudiants.stream()
					        .filter(p->p.get_trois_prof_choix().size()<3)
					        .findAny()
					        .orElse(null);

return checkedEtudiant==null;

}

public void les_prof_de_choix_par_etudiant() {
		
		for (Iterator iterator = this.listEtudiants.iterator(); iterator.hasNext();) {
		          Etudiant etudiant = (Etudiant) iterator.next();
	         	  System.out.println(etudiant+" -> "+etudiant.get_trois_prof_choix());
	         	  System.out.println("---------------------------------------------------------");
          }

//        for (int i = 0; i < this.listEtudiants.size(); i++) {
//                  System.out.println(this.listEtudiants.get(i) +"->"+this.listEtudiants.get(i).get_trois_prof_choix());
//         }

}


public void les_etudaints_par_profencadrant() {
	
	for (Iterator iterator = this.listprofs.iterator(); iterator.hasNext();) {
	          ProfEncadrant prof = (ProfEncadrant) iterator.next();
	          prof.setComp(prof.getEudiants().size());
         	  System.out.println(prof+" -> "+prof.getEudiants());
         	  System.out.println("---------------------------------------------------------");
      }

//    for (int i = 0; i < this.listEtudiants.size(); i++) {
//              System.out.println(this.listEtudiants.get(i) +"->"+this.listEtudiants.get(i).get_trois_prof_choix());
//     }

}

public boolean tous_les_etudaints_ont_choisi_un_profEncadrant() {
	 
	boolean oui = true;
	
	for (Etudiant etudiant : this.listEtudiants) {
		
		if(etudiant.choix() == false)oui = false;
		
	}
	
	return oui;
		
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public Map<Etudiant,List<ProfEncadrant>> getAffectation_trois_profs() {
return this.affectation_trois_profs;
}



public boolean setAffectation_trois_profs() {
				this.affectation_trois_profs = Affectation();
				return this.affectation_trois_profs.size() == this.listEtudiants.size();
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*::::::::::::::::::::::::::::::::::::Partie_Enrgistrement:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public boolean addEutdiant(String Firstname,String LastName) {
	    Etudiant et = this.listEtudiants.stream()
	    		.filter(y-> y.getFirstName().equalsIgnoreCase(Firstname) 
	    		       && y.getLastName().equalsIgnoreCase(LastName))
	    		    .findAny()
	    		    .orElse(null);
	     if(et == null)this.listEtudiants.add(this.creator.getInstance(Firstname, LastName));
	    
        return et ==null;
}

public boolean addProf(String FirstName,String LastName,int Cap ,String etablissemnt) {
	        ProfEncadrant pr =    this.listprofs.stream()
	        		.filter(y-> y.getFirstName().equalsIgnoreCase(FirstName) 
	    		       && y.getLastName().equalsIgnoreCase(LastName)
	    		       && y.getEtablissement().equalsIgnoreCase(etablissemnt))
	    		    .findAny()
	    		.orElse(null);
	        
	        if(pr ==null)this.listprofs.add(this.creator
	        		.getInstance(FirstName, LastName, Cap, etablissemnt));
	        	
	
	       return  pr ==null;
}



public List<ProfEncadrant> getListprofs() {
return this.listprofs;
}




public List<Etudiant> getListEtudiants() {
return this.listEtudiants;
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*::::::::::::::::::::::::::::::::::::Partie_Correction:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public List<ProfEncadrant> getListprofs_Non_Selectionnee() {
	List<ProfEncadrant> l = (List<ProfEncadrant>) this.listprofs.stream()
			.filter(p->p.getEudiants().size() == 0)
			.collect(Collectors.toCollection(LinkedList :: new));
	
return l;
}

public List<ProfEncadrant> getListprofs_Selectionnee_plus_que_cap() {
	List<ProfEncadrant> l = (List<ProfEncadrant>) this.listprofs.stream()
			.filter(p->p.getEudiants().size() > p.getCap())
			.collect(Collectors.toCollection(LinkedList :: new));
	
return l;
}

public List<ProfEncadrant> getListprofs_Selectionnee_moin_que_cap() {
	List<ProfEncadrant> l = (List<ProfEncadrant>) this.listprofs.stream()
			.filter(p->p.getEudiants().size() < p.getCap())
			.collect(Collectors.toCollection(LinkedList :: new));
	
return l;
}

public List<ProfEncadrant> getListprofs_Selectionnee_complets() {
	List<ProfEncadrant> l = (List<ProfEncadrant>) this.listprofs.stream()
			.filter(p->p.getEudiants().size() == p.getCap())
			.collect(Collectors.toCollection(LinkedList :: new));
	
	
return l;
}

public List<Etudiant> getListEtudiands_a_reaffecter(){
	List<Etudiant> l = new LinkedList<>();
	List<ProfEncadrant> lp = getListprofs_Selectionnee_plus_que_cap();
	
    for (Iterator iterator = lp.iterator(); iterator.hasNext();) {
         int size = 0;
         int rand = -1;
		ProfEncadrant prof= (ProfEncadrant) iterator.next();
		size = prof.getEudiants().size();
		while(size > prof.getCap()) {
		rand = Metie.Random(size);
		l.add(prof.getEudiants().get(rand));
		prof.getEudiants().remove(rand);
		size = prof.getEudiants().size();
		}
	}
	
	return l;
}


public boolean correction() {
	List<Etudiant> le = getListEtudiands_a_reaffecter();
//:::::::::::::::::::::::::::::::Prof non selctionner::::::::::::::::::::::::://	
	List<ProfEncadrant> lp = getListprofs_Non_Selectionnee();
	
    System.out.println();
    System.out.println("///////////////////////////////////////////////////////");	        
    System.out.println("::::::Les Etudiants a reAffecter 1::::::");
    System.out.println("///////////////////////////////////////////////////////");	        
    System.out.println(le);
    
	
	if(lp.size()!=0) {
		
		
		int SC = 0;for (ProfEncadrant prof : lp)SC += prof.getCap();
		
		if(le.size() >= SC) {

			    for (Iterator iterator = lp.iterator(); iterator.hasNext();) {
			        int size = 0;
			        int rand = -1;
					ProfEncadrant prof= (ProfEncadrant) iterator.next();
					size = prof.getEudiants().size();
					while(size < prof.getCap()) {
					rand = Metie.Random(le.size());
					prof.setEudiants(le.get(rand));
					le.remove(rand);
					size = prof.getEudiants().size();
					}
					lp = getListprofs_Non_Selectionnee();   
              
		    }
			
		}else {
			
			if(le.size() >= lp.size()) {
				
			    for (Iterator iterator = lp.iterator(); iterator.hasNext();) {
			        int rand = -1;
					ProfEncadrant prof= (ProfEncadrant) iterator.next();
					rand = Metie.Random(le.size());
					prof.setEudiants(le.get(rand));
					le.remove(rand);
					
			    }
				lp = getListprofs_Non_Selectionnee();   

				
			}else {
				List<ProfEncadrant> lpC = getListprofs_Selectionnee_complets().stream()
						.filter(p->p.getCap() > 3)
						.collect(Collectors.toCollection(LinkedList :: new));
				
				while(le.size() < lp.size()) {
			 	
			     for (Iterator iterator = lpC.iterator(); iterator.hasNext();) {
			           int rand = -1;
				     	ProfEncadrant prof= (ProfEncadrant) iterator.next();
					    rand = Metie.Random(prof.getEudiants().size());
					    le.add(prof.getEudiants().get(rand));
					    prof.getEudiants().remove(rand);
					
			    }     
				}
				
			    for (Iterator iterator = lp.iterator(); iterator.hasNext();) {
			        int rand = -1;
					ProfEncadrant prof= (ProfEncadrant) iterator.next();
					rand = Metie.Random(le.size());
					prof.setEudiants(le.get(rand));
					le.remove(rand);
					
			    }
				lp = getListprofs_Non_Selectionnee();   

				
			}
			
						
		}

	}
	

//    System.out.println();
//    System.out.println("///////////////////////////////////////////////////////");	        
//    System.out.println("::::::Les Etudiants a reAffecter 2::::::");
//    System.out.println("///////////////////////////////////////////////////////");	        
//    System.out.println(le);
    
    if(le.size() !=0) {
    	List<ProfEncadrant> lpNC = getListprofs_Selectionnee_moin_que_cap().stream()
    			.filter(p-> ((p.getCap()>=3 && p.getEudiants().size()<2) 
    					|| (p.getCap()>3 && p.getEudiants().size()<=2)))
    			.collect(Collectors.toCollection(LinkedList :: new));
    	
    	if(lpNC.size() == 0)lpNC = getListprofs_Selectionnee_moin_que_cap().stream()
    			.filter(p-> p.getCap()>=3)
    			.collect(Collectors.toCollection(LinkedList :: new));
    	
    	while(le.size() > 0) {
    		int rand = Metie.Random(lpNC.size());
			lpNC.get(rand).setEudiants(le.get(le.size() -1));
			le.remove(le.size() -1);
			
    		
    	}
    	
    }
    
//    System.out.println();
//    System.out.println("///////////////////////////////////////////////////////");	        
//    System.out.println("::::::Les Etudiants a reAffecter 3::::::");
//    System.out.println("///////////////////////////////////////////////////////");	        
//    System.out.println(le);
    
	
	return lp.size() == 0;
}

}
