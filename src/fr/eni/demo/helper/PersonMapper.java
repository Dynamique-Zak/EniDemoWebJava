package fr.eni.demo.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.demo.bo.Person;

public class PersonMapper {

	/**
	 * Mapper/Convertir des données SQL en objet Person
	 * @param result La donnée SQL
	 * @return La personne convertie depuis la donnée SQL
	 */
	public static Person sqlToPerson(ResultSet result) {
		Person person = null;
		
		try {
			person = new Person(result.getInt(1), result.getString(2), result.getString(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return person;
	}
}
