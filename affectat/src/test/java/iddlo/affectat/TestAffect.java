package iddlo.affectat;


/**
 * @author dhimni rida
 *Nov 5, 2019
 * affectat
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import metie.Affectation;



public class TestAffect {
	
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
 

private Affectation affectation;
               
	
	
	 @Before
	    public void initialize_test_data() {
		 affectation = new Affectation();
	 }
	    
	    @Test
	    public void peut_on_enregistrer_un_Etudiant() {
	        Assert.assertEquals(true, affectation.addEutdiant("rida", "dhimni"));

	    }
	    
	    @Test
	    public void peut_on_enregistrer_un_Etudiant_deux_fois() {
	        affectation.addEutdiant("rida", "dhimni");	    	
	        Assert.assertEquals(false, affectation.addEutdiant("rida", "dhimni"));

	    }

	    @Test
	    public void peut_on_enregistrer_un_ProfEncadrant() {
	        Assert.assertEquals(true, affectation.addProf("khttabi", "fatima", 2, "FSR"));
	    }
	
	    @Test
	    public void peut_on_enregistrer_un_ProfEncadrant_deux_fois() {
	        Assert.assertEquals(true, affectation.addProf("khttabi", "fatima", 2, "FSR"));
	        Assert.assertEquals(false, affectation.addProf("khttabi", "fatima", 2, "FSR"));

	    }    
	    
	    @Test
	    public void affechage_de_liste_Etudiant() {
	        Assert.assertEquals(true, affectation.addEutdiant("rida", "dhimni"));
	        Assert.assertEquals(true, affectation.addEutdiant("mehdi", "bachir"));
	        System.out.println(affectation.getListEtudiants());
	        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::");

	    }
	    
	    @Test
	    public void affechage_de_liste_ProfEncadrant() {
	        Assert.assertEquals(true, affectation.addProf("khttabi", "fatima", 2, "FSR"));
	        Assert.assertEquals(true, affectation.addProf("ziti", "hayat", 1, "FSR"));
	        System.out.println(affectation.getListprofs());
	        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::");

	    }
	    
	    
	    @Test
	    public void affectation_trois_profs_de_choix_pour_chaque_etudiant() {
	        Assert.assertEquals(true, affectation.addEutdiant("rida", "dhimni"));
	        Assert.assertEquals(true, affectation.addEutdiant("mehdi", "bachir"));
	        Assert.assertEquals(true, affectation.addEutdiant("othmane", "afifi"));
	        Assert.assertEquals(true, affectation.addEutdiant("ayoub", "fetwaki"));
	        Assert.assertEquals(true, affectation.addEutdiant("ayoub", "el omari"));
	        Assert.assertEquals(true, affectation.addEutdiant("aymane", "bourhil"));
	        Assert.assertEquals(true, affectation.addEutdiant("hamza", "lattare"));
	        Assert.assertEquals(true, affectation.addEutdiant("hamza", "saber"));
	        Assert.assertEquals(true, affectation.addEutdiant("bader", "nuisi"));
	        Assert.assertEquals(true, affectation.addEutdiant("yousser", "hh"));
	        Assert.assertEquals(true, affectation.addEutdiant("zakaria", "hh"));
	        Assert.assertEquals(true, affectation.addEutdiant("naoufal", "hh"));
	        Assert.assertEquals(true, affectation.addEutdiant("ayoube", "blouche"));
	        Assert.assertEquals(true, affectation.addEutdiant("elyase", "hh"));
	        Assert.assertEquals(true, affectation.addEutdiant("aymane", "hh"));
	        Assert.assertEquals(true, affectation.addEutdiant("hassnae", "hh"));
	        Assert.assertEquals(true, affectation.addEutdiant("mohamed", "mamoune"));
	        Assert.assertEquals(true, affectation.addEutdiant("mareyme", "hh"));
	        Assert.assertEquals(true, affectation.addEutdiant("salima", "hh"));
	        Assert.assertEquals(true, affectation.addEutdiant("younsse", "hh"));
	        
	        Assert.assertEquals(true, affectation.addProf("khttabi", "", 2, "FSR"));
	        Assert.assertEquals(true, affectation.addProf("ziti", "h", 1, "FSR"));
	        Assert.assertEquals(true, affectation.addProf("ahyoud", "", 5, "FSR"));
	        Assert.assertEquals(true, affectation.addProf("bouhdadi", "", 4, "FSR"));
	        Assert.assertEquals(true, affectation.addProf("riadesolhe", "", 3, "FSR"));
	        Assert.assertEquals(true, affectation.addProf("Raoui", "", 3, "FSR"));
	        Assert.assertEquals(true, affectation.addProf("suidi", "", 3, "FSR"));

	        
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println(":::::La colletion des profsEnc par d'etudiant:::::::::::");
	        System.out.println("///////////////////////////////////////////////////////");
	        Assert.assertEquals(true, affectation.setAffectation_trois_profs());
	        Assert.assertEquals(true, affectation.affectation_trois_profs_est_bien_passee());
	        affectation.les_prof_de_choix_par_etudiant();
	        
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::::::::::::Le choix d'etudiant:::::::::::::");
	        System.out.println("///////////////////////////////////////////////////////");	
	        Assert.assertEquals(true, affectation.tous_les_etudaints_ont_choisi_un_profEncadrant());
	        affectation.les_prof_de_choix_par_etudiant();

	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::::::::::::::AVANT LA CORRECTION::::::::::::::::::");
	        System.out.println("///////////////////////////////////////////////////////");		        
	        
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::::::::::::Les Etudtiands par ProfEnc:::::::::::::");
	        System.out.println("///////////////////////////////////////////////////////");	
	         affectation.les_etudaints_par_profencadrant();
	        
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::::::::::::Les Profs Non selectionnee:::::::::::::");
	        System.out.println("///////////////////////////////////////////////////////");	        
            System.out.println(affectation.getListprofs_Non_Selectionnee());
            
            
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::Les Profs selectionnee plus que la capacite::::::");
	        System.out.println("///////////////////////////////////////////////////////");	        
            System.out.println(affectation.getListprofs_Selectionnee_plus_que_cap());
            
            
//	        System.out.println();
//	        System.out.println("///////////////////////////////////////////////////////");	        
//	        System.out.println("::::::Les Etudiants a reAffecter::::::");
//	        System.out.println("///////////////////////////////////////////////////////");	        
//            System.out.println(affectation.getListEtudiands_a_reaffecter());
            
	        Assert.assertEquals(true, affectation.correction());
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::::::::::::::APREE LA CORRECTION::::::::::::::::::");
	        System.out.println("///////////////////////////////////////////////////////");		        

	       
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::::::::::::Les Etudtiands par ProfEnc:::::::::::::");
	        System.out.println("///////////////////////////////////////////////////////");	
	        affectation.les_etudaints_par_profencadrant();
	        
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::::::::::::Les Profs Non selectionnee:::::::::::::");
	        System.out.println("///////////////////////////////////////////////////////");	        
            System.out.println(affectation.getListprofs_Non_Selectionnee());
            
            
	        System.out.println();
	        System.out.println("///////////////////////////////////////////////////////");	        
	        System.out.println("::::::Les Profs selectionnee plus que la capacite::::::");
	        System.out.println("///////////////////////////////////////////////////////");	        
            System.out.println(affectation.getListprofs_Selectionnee_plus_que_cap());
            
	  
	    }
	    

}

