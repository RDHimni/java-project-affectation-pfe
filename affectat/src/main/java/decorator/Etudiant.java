package decorator;

import metie.Metie;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dhimni rida
 *Nov 2, 2019
 * affectat
 */

public class Etudiant extends Decorator{
	
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/	
	
    private Map<ProfEncadrant,Boolean> _trois_prof_choix;

	public Etudiant(IPerson p) {
		super(p);
		this._trois_prof_choix = new HashMap<>();
	}

/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/	

	public Map<ProfEncadrant,Boolean> get_trois_prof_choix() {
		return this._trois_prof_choix;
	}

	public void set_trois_prof_choix(List<ProfEncadrant> trois_prof_choix) {
		this._trois_prof_choix = trois_prof_choix.stream().collect(Collectors.toMap(x->x,x->false));
	}
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/	
   
	public boolean choix() {
		ProfEncadrant p =null;
		int rand = Metie.Random(3);
	    int	i=0;
           for (Iterator iterator = this._trois_prof_choix.keySet().iterator(); iterator.hasNext();)
           {
			p = (ProfEncadrant) iterator.next();

		   if(i==rand)break;
			i++;
		  }

	    if(p!=null) {
		this._trois_prof_choix.put(p, true);
		p.setEudiants(this);
		}
	    return p!=null;
	}

}