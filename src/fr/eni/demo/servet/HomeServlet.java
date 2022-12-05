package fr.eni.demo.servet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Afficher page HTML
		RequestDispatcher rd = request.getRequestDispatcher("home.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer le prenom du formulaire
		String firstname = request.getParameter("firstname");
		
		// Si prenom valid
		if (!firstname.isEmpty()) {
			// Ok
			RequestDispatcher rd = request.getRequestDispatcher("success.html");
			rd.forward(request, response);
		}
		else {
			// Erreur
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}
	}

}
