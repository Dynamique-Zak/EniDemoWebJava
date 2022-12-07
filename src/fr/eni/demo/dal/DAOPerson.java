package fr.eni.demo.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.bo.Person;
import fr.eni.demo.dal.jdbc.JdbcTools;
import fr.eni.demo.helper.PersonMapper;

public class DAOPerson extends DAOBase {

	/**
	 * 
	 * @param person
	 * @return True quand insert OK. False quand erreur
	 */
	public boolean insert(Person person) {
		// Prepare les var
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("insert into person (firstname, lastname) values (?, ?)");
	        
			// je set les parametres
			stmt.setString(1, person.getFirstname());
			stmt.setString(2, person.getLastname());
			
			// J'execute la requete
			stmt.execute();

	        // Fermer la connexion
	        cnx.close();
	        
	        // Retourne vrai 
	    	return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public Person selectById(int id) {
		// Prepare les var
		Person person = null;
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM person WHERE id = ?");
			stmt.setInt(1, id);
			
			// Executer la requete
	        ResultSet result = stmt.executeQuery();
	        // Recupere la premiere ligne
	        result.next();
	        
	        // Mapper
	        person = PersonMapper.sqlToPerson(result);
	        
	        // Fermer la connexion
	        cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return person;
	}
	
	public List<Person> selectAll() {
		// Prepare les var
		List<Person> persons = new ArrayList<Person>();
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			Statement stmt = cnx.createStatement();
	        ResultSet result = stmt.executeQuery("SELECT * FROM person");
			
	        // Tant qu'on a des lignes
		    while ( result.next() ) {
	        	// Ajouter dans la liste
	        	persons.add(PersonMapper.sqlToPerson(result));
	        }
		    
	        // Fermer la connexion
	        cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return persons;
	}
	
	
	public List<Person> selectAllLimit(int max) {
		// Prepare les var
		List<Person> persons = new ArrayList<Person>();
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("SELECT TOP ? * FROM person");
	        
			stmt.setInt(1, max);
			
			ResultSet result = stmt.executeQuery();
			
	        // Tant qu'on a des lignes
		    while ( result.next() ) {
	        	// Ajouter dans la liste
	        	persons.add(PersonMapper.sqlToPerson(result));
	        }
		    
	        // Fermer la connexion
	        cnx.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return persons;
	}
}
