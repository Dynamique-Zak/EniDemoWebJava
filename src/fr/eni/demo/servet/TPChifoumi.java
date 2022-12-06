package fr.eni.demo.servet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TPChifoumi
 */
@WebServlet("/chifumi")
public class TPChifoumi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private HashMap<String, String> dicto = new HashMap<String, String> () 
	{
		{
			put("chi", "fu");
			put("fu", "mi");
			put("mi", "chi");
		}
	};
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TPChifoumi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Afficher page HTML
		RequestDispatcher rd = request.getRequestDispatcher("tp3/chifumi.jsp");
		rd.forward(request, response);
		
		// String fakeSelection = "chi";
		// dicto.get(fakeSelection); // un get de "chi" qui va retourner "fu"
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupérer la selection du Joueur
		
		String selection = request.getParameter("selection");
		
		// Liste des choix possibles pour l'IA
		String[] possibleChoices = new String[3];
		possibleChoices[0] = "chi";
		possibleChoices[1] = "fu";
		possibleChoices[2] = "mi";
		
		// Prepare le random
		Random r = new Random();
		
		// L'IA selectionne un choix aleatoire
		String aISelection = possibleChoices[r.nextInt(3)];
		
		// Afficher la selection des joueurs
		System.out.println(String.format("IA = %s; Joueur = %s", aISelection, selection));
		
		// Si la valeur de ma clé est égal au choix de l'ia alors j'ai perdu
		// Example (chi) ca ma retourne "fu" et si l'ia mis "fu" alors j'ai perdu:
		// - si c'est chi la clé alors ca retourne fu
		// - si l'ia à mis fu
		// Example (fu) ca ma retourne "mi" et si l'ia mis "mi" alors j'ai perdu:
		// - si c'est chi la clé alors ca retourne fu
		// - si l'ia à mis fu
		// Si l'ia à gagné
		// Version ternaire
		/*
		String result = dicto.get(selection).equals(aISelection) ? "L'ia à gagné" : (selection.equals(aISelection)) ? "Match nul" : "Le joueur à gagné";
		System.out.println(result);
		*/
		String result;
		
		if (dicto.get(selection).equals(aISelection)) {
			result = "L'ia à gagné";
		}
		else {
			if (selection.equals(aISelection)) {
				result = "Match nul";
			}
			else {
				result = "Le joueur à gagné";
			}
		}
		
		// Envoyer l'attribut dans la page
		request.setAttribute("selection", selection);
		request.setAttribute("aISelection", aISelection);
		request.setAttribute("result", result);
		
		// Afficher page HTML
		RequestDispatcher rd = request.getRequestDispatcher("tp3/result.jsp");
		rd.forward(request, response);
				
	}
}
