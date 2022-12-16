package fr.eni.demo.bll;

import java.util.List;

import fr.eni.demo.bo.Article;
import fr.eni.demo.dal.DAOArticle;
import fr.eni.demo.dal.DAOFactory;

public class ArticleManager extends ManagerBase {
	
	public boolean addArticle(Article article) {

		// j'appel La DAO pour mettre en base
		return DAOFactory.getDAOByClass(DAOArticle.class).insert(article);
	}

	
	public Article getArticle(int id) {

		// j'appel La DAO pour mettre en base
		Article article = DAOFactory.getDAOByClass(DAOArticle.class).selectById(id);
		
		return article;
	}

	public List<Article> getAllArticle() {
		// j'appel La DAO pour mettre en base
		List<Article> articles = DAOFactory.getDAOByClass(DAOArticle.class).selectAll();
				
		return articles;
	}
}
