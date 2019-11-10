package iddlo.affectat;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import decorator.Etudiant;
import decorator.ProfEncadrant;
import factory.Factory;
import metie.Metie;

/**
 * @author dhimni rida
 *Nov 5, 2019
 * affectat
 */

public class Main {
	static Map<Etudiant,List<ProfEncadrant>> affectation_trois_profs;

	static List<ProfEncadrant> listprofs;
	static List<Etudiant> listEtudiants;
	static Etudiant e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20,
	          e21,e22,e23,e24,e25,e26,e27,e28,e29,e30,e31,e32,e33;
	static ProfEncadrant p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;

	static Factory creator;

	static Metie metie;
		

	public static void main(String[] args) {


				 affectation_trois_profs = new HashMap<>();
				 listprofs = new LinkedList<>();
				 listEtudiants = new LinkedList<>();
				 creator = new Factory();
				 metie = new Metie();
				 e1  = creator.getInstance("E1", "");
				 e2  = creator.getInstance("E2", "");
				 e3  = creator.getInstance("E3", "");
				 e4  = creator.getInstance("E4", "");
				 e5  = creator.getInstance("E5", "");
				 e6  = creator.getInstance("E6", "");
				 e7  = creator.getInstance("E7", "");
				 e8  = creator.getInstance("E8", "");
				 e9  = creator.getInstance("E9", "");
				 e10 = creator.getInstance("E10","");
				 e11 = creator.getInstance("E11","");
				 e12 = creator.getInstance("E12","");
				 e13 = creator.getInstance("E13","");
				 e14 = creator.getInstance("E14","");
				 e15 = creator.getInstance("E15","");

				 
				 listEtudiants.add(e1);listEtudiants.add(e2);
				 listEtudiants.add(e3);listEtudiants.add(e4);
				 listEtudiants.add(e5);listEtudiants.add(e6);
				 listEtudiants.add(e7);listEtudiants.add(e8);
				 listEtudiants.add(e9);listEtudiants.add(e10);
				 listEtudiants.add(e11);listEtudiants.add(e12);
				 listEtudiants.add(e13);listEtudiants.add(e14);
				 listEtudiants.add(e15);

				 
				 p1  = creator.getInstance("P1", "", 2, "FSR");
				 p2  = creator.getInstance("P2", "", 5, "FSR");
				 p3  = creator.getInstance("P3", "", 1, "FSR");
				 p4  = creator.getInstance("P4", "", 2, "ESTS");
				 p5  = creator.getInstance("P5", "", 3, "FSR");
				 p6  = creator.getInstance("P6", "", 4, "FSR");
				 p7  = creator.getInstance("P7", "", 3, "FSR");

				  
				 listprofs.add(p1);listprofs.add(p2);listprofs.add(p3);
				 listprofs.add(p4);listprofs.add(p5);listprofs.add(p6);
				 listprofs.add(p7);

			//	 affectation_trois_profs = metie.Affectation(listprofs, listEtudiants); 
				 
				 affichage_affectation_trois_profs_achaque_etudians();
				 les_prof_choisi_par_chaque_etudiant();
				 les_choix_des_etudiands();
	}
	
	
	
	    public static void affichage_affectation_trois_profs_achaque_etudians() {
		 
		 affectation_trois_profs.forEach((k,v)->System.out.println(k+"->"+v));
		 
	 }
	 
	 
	 	
	 public static void les_prof_choisi_par_chaque_etudiant(){
	//	 metie.les_prof_choisi_par_chaque_etudiant(listEtudiants);
	 }

	    public static void les_choix_des_etudiands() {
		 e1.choix();
		 e2.choix();
		 e3.choix();
		 e4.choix();
		 e5.choix();
		 e6.choix();
		 e7.choix();
		 e8.choix();
		 e9.choix();
		 e10.choix();
		 e11.choix();
		 e12.choix();
		 e13.choix();
		 e14.choix();
		 e15.choix();


	 }
}
