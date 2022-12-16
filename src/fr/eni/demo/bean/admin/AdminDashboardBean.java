package fr.eni.demo.bean.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fr.eni.demo.bll.ArticleManager;
import fr.eni.demo.bll.ManagerFactory;
import fr.eni.demo.bo.Article;

public class AdminDashboardBean {

	
	public String render(HttpServletRequest request) {
		
		String html = "<ul>";
		
		List<Article> articles = ManagerFactory.getManagerByClass(ArticleManager.class).getAllArticle();
		
		for (Article article : articles) {
			html += String.format("<li>Article id: %d et title: %s</li>", article.getId(), article.getTitle());
		}
		
		html += "</ul>";
		
		return html;
	}
	
}
