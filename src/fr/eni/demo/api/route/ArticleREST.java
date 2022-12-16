package fr.eni.demo.api.route;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.eni.demo.bll.ArticleManager;
import fr.eni.demo.bll.ManagerFactory;
import fr.eni.demo.bo.Article;

@Path("article")
public class ArticleREST {

	@GET
	@Path("/getArticle/{id : \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Article getArticleById(@PathParam("id") int id) {
		
		// Je récupère ma BLL/Manager
		ArticleManager articleManager = ManagerFactory.getManagerByClass(ArticleManager.class);
		
		// Je récupère mon article
		Article article = articleManager.getArticle(id);
		
		// Je simule du lag (je dis au thread java d'attendre 1 sec)
		try {
		  Thread.sleep(1000);
		} catch (InterruptedException e) {
		  Thread.currentThread().interrupt();
		}
		// --
		
		// Je retourne mon article
		return article;
	}
	
	@GET
	@Path("/getAllArticle")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Article> getAllArticle() {
		
		// Je récupère ma BLL/Manager
		ArticleManager articleManager = ManagerFactory.getManagerByClass(ArticleManager.class);
		
		// Je récupère mon article
		List<Article> articles = articleManager.getAllArticle();
		
		// Je simule du lag (je dis au thread java d'attendre 1 sec)
		try {
		  Thread.sleep(1000);
		} catch (InterruptedException e) {
		  Thread.currentThread().interrupt();
		}
		// --
		
		// Je retourne mon article
		return articles;
	}


	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean addArticle(Article article) {
		// Je récupère ma BLL/Manager
		ArticleManager articleManager = ManagerFactory.getManagerByClass(ArticleManager.class);
				
		
		return articleManager.addArticle(article);
	}
}
