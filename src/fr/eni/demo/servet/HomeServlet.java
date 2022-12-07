package fr.eni.demo.servet;

import java.io.IOException;
import java.util.Random;

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
		
		//
		int[] notes = new int[2];
		
		notes[0] = 1;
		notes[1] = 2;
		
		// bad
		// notes[0] = "es";
		
		//
		/*
		Object[] objects = new Object[2];
		
		objects[0] = new Person("Arnaud");
		objects[1] = new Article("Bière");
		
		for (int i = 0; i < objects.length; i++) {
			
			if (objects[i] instanceof Person) {
				Person person = (Person) objects[i];
				System.out.println(person.firstname);
			}
		}
		*/
		
		// Envoyer des variables String dans la vue JSP 
		// Warning : SetAttribute attend en valeur un Object 
		// Donc faut caster aprés pour exploiter la donner
		String client = "Isaac";
		
		request.setAttribute("firstname", client);
		request.setAttribute("lastname", "Test");
		
		// Afficher page HTML
		RequestDispatcher rd = request.getRequestDispatcher("demo/home.jsp");
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
			RequestDispatcher rd = request.getRequestDispatcher("demo/success.html");
			rd.forward(request, response);
		}
		else {
			// Erreur
			RequestDispatcher rd = request.getRequestDispatcher("demo/error.html");
			rd.forward(request, response);
		}
	}

}
