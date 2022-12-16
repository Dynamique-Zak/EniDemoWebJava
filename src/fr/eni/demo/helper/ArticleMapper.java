package fr.eni.demo.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.demo.bo.Article;
import fr.eni.demo.bo.Person;

public class ArticleMapper {

	/**
	 * Mapper/Convertir des données SQL en objet Person
	 * @param result La donnée SQL
	 * @return La personne convertie depuis la donnée SQL
	 */
	public static Article sqlToArticle(ResultSet result) {
		Article article = null;
		
		try {
			article = new Article(result.getInt(1), result.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return article;
	}
}
