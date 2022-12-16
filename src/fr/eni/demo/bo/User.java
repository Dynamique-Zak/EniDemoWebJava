package fr.eni.demo.bo;

public class User {

	public String email;

	public String password;
	public String pseudo;
	
	public User(String email, String password, String pseudo) {
		super();
		this.email = email;
		this.password = password;
		this.pseudo = pseudo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Email=%s et Pseudo=%s", email, pseudo);
	}
}
