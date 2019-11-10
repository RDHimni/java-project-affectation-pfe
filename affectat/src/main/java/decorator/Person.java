package decorator;

/**
 * @author dhimni rida
 *Nov 2, 2019
 * affectat
 */

public class Person implements IPerson {
	
	private String FirstName;
	private String LastName;
	
	public Person(String FirstName,String LastName) {
        this.setFirstName(FirstName);
        this.setLastName(LastName);	
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}
	

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
		public String toString() {
			return getFirstName()+" "+getLastName();
		}
	
	
}
