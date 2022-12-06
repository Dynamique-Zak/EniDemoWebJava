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
 * Servlet implementation class TP1Servlet
 */
@WebServlet("/tp1")
public class TP1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int randomNumber;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TP1Servlet() {
        super();
        
        this.randomNumber = -1;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Afficher page HTML (formulaire)
		RequestDispatcher rd = request.getRequestDispatcher("tp1.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Etape 1
		// Si le nombre est égal à -1 alors il n'as pas été généré
		if (randomNumber == -1) {
			// Je genere un nombre aléatoire
			Random random = new Random(); // outil/utilitaire/helper
			this.randomNumber = random.nextInt(11); // nombre de 0 a 10
			
			System.out.println(String.format("Le nombre généré est %d", randomNumber));
		}
		
		// Etape 2
		// tester si le nombre de l'utilisateur est égal au nombre random
		int userNumber = Integer.parseInt(request.getParameter("number")); // Pour l'instant en dur
		
		// Si les deux nombres concordent
		if (userNumber == randomNumber) {
			// Reset 
			this.randomNumber = -1;
			
			// Afficher page HTML (formulaire)
			RequestDispatcher rd = request.getRequestDispatcher("success.html");
			rd.forward(request, response);
		}
		else {
			// pas ok
			// Afficher page HTML (formulaire)
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.forward(request, response);
		}
	}

}
