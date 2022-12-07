package fr.eni.demo.bo;

public class Person {

	private int id;
	private String firstname;
	private String lastname;
	
	public Person(int id, String firstname, String lastname) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return String.format("La personne : %s %s", firstname, lastname);
	}
}
