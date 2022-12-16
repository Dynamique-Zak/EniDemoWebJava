package fr.eni.demo.dal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.demo.bo.Article;
import fr.eni.demo.dal.jdbc.JdbcTools;
import fr.eni.demo.helper.ArticleMapper;

public class DAOArticle extends DAOBase {

	public Article selectById(int id) {
		// Prepare les var
		Article article = null;
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("SELECT * FROM article WHERE id = ?");
			stmt.setInt(1, id);
			
			// Executer la requete
	        ResultSet result = stmt.executeQuery();
	        // Recupere la premiere ligne
	        result.next();
	        
	        // Mapper
	        article = ArticleMapper.sqlToArticle(result);
	        
	        // Fermer la connexion
	        cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return article;
	}

	public List<Article> selectAll() {
		// Prepare les var
		List<Article> articles = new ArrayList<Article>();
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			Statement stmt = cnx.createStatement();
			
			// Executer la requete
	        ResultSet result = stmt.executeQuery("SELECT * FROM article");
	        
	        // Recupere la premiere ligne
	        while (result.next()) {
		        articles.add(ArticleMapper.sqlToArticle(result));
	        }
	        
	        // Fermer la connexion
	        cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return articles;
	}

	public boolean insert(Article article) {
		// Prepare les var
		Connection cnx = null;
		
		try{
			// Ouvrir la connexion
			cnx = JdbcTools.getConnection();
			
			// La requête
			PreparedStatement stmt = cnx.prepareStatement("INSERT INTO article (title) VALUES (?)");
			stmt.setString(1, article.getTitle());
			
			// Executer la requete
	        stmt.execute();
	        
	        // Fermer la connexion
	        cnx.close();
	        
	        return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return false;
	}

	
}
