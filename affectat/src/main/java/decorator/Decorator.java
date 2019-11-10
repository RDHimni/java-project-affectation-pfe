package decorator;

/**
 * @author dhimni rida
 * Nov 2, 2019
 * affectat
 */

public abstract class Decorator implements IPerson {
 private IPerson p;
 
 public Decorator(IPerson p) {
    this.p=p;
 }

@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return this.p.getFirstName();
	}

@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return this.p.getLastName();
	}
	@Override
	public String toString() {
		return this.p.toString();
	}
}
