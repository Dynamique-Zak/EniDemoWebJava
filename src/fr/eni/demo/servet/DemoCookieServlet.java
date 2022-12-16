package fr.eni.demo.servet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.demo.bo.User;

/**
 * Servlet implementation class DemoCookieServlet
 */
@WebServlet("/demo-cookie")
public class DemoCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PARTIE COOKIE (Propre au navigateur)
		// demo
		Cookie[] cookies = request.getCookies();

		// Si aucun cookie 
		if (cookies == null) {
			// creer un cookie mail
			Cookie cookie = new Cookie("email", "darksasuke@gmail.com");
			
			// ajouter un cookie dans la reponse
			response.addCookie(cookie);
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
		} else { // sinon lire les cookies
			for (Cookie cookie : cookies) {
				response.getWriter().append(String.format("Cookie Nom=%s et Valeur=%s \n", cookie.getName(), cookie.getValue()));
			}
		}
		
		// PARTIE SESSION (Propre au serveur)
		// Si premier fois (donc null)
		if(request.getSession().getAttribute("user") == null) {
			// Creer un user
			User user = new User("darksasuke@gmail.com", "DarkSasuke44300", "Stagiaire ENI");
			
			// Ajouter le user dans la session
			request.getSession().setAttribute("user", user);
			
			 // 
			response.getWriter().append("\n Je créer un user en session");
			
		} else {
			// Doit caster car type Object
			User loggedUser = (User) request.getSession().getAttribute("user");
			
			response.getWriter().append(String.format("\n Utilisateur connecté : %s", loggedUser));
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
