package fr.eni.demo.bo;

public class Person {

	public String firstname;

	public Person(String firstname) {
		super();
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return String.format("La personne : %s", this.firstname);
	}
}
