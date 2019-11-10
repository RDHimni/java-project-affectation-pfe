package decorator;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dhimni rida
 *Nov 2, 2019
 * affectat
 */

public class ProfEncadrant extends Decorator{
    
	private int Cap;
	private int Comp;
	private String Etablissement;
	private List<Etudiant> eudiants;
	
	public ProfEncadrant(IPerson p,int Cap,String Etablissement) {
		super(p);
		this.setCap(Cap);
		this.setEtablissement(Etablissement);
		this.Comp=0;
		
		eudiants = new LinkedList<>();
		
	}

	public int getCap() {
		return Cap;
	}

	public void setCap(int cap) {
		Cap = cap;
	}

	public int getComp() {
		return Comp;
	}

	public void setIncrComp() {
		this.Comp++;
	}
	
	public void setComp(int comp) {
		
		this.Comp =comp;
	}

	public String getEtablissement() {
		return Etablissement;
	}

	public void setEtablissement(String etablissement) {
		Etablissement = etablissement;
	}
	
	@Override
		public String toString() {
			return super.toString()+" "+getEtablissement()+" "+getCap()+"("+getComp()+")";
		}

	public List<Etudiant> getEudiants() {
		return eudiants;
	}

	public void setEudiants(Etudiant e) {
		this.eudiants.add(e);
	}

}
