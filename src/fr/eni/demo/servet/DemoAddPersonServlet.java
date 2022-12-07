package fr.eni.demo.servet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.demo.bll.EniDemoResponse;
import fr.eni.demo.bll.ManagerFactory;
import fr.eni.demo.bll.PersonManager;
import fr.eni.demo.bo.Person;

/**
 * Servlet implementation class DemoAddPersonServlet
 */
@WebServlet("/add-person")
public class DemoAddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoAddPersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Afficher le formulaire en JSP
		RequestDispatcher rd = request.getRequestDispatcher("demo_person/add-person-form.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Récupérer les données formulaire
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		// Hydrater une classe à partir des données du formulaire
		Person person = new Person(firstname, lastname);
		
		// Appeler le Service/Métier/BLL/Manager pour ajouter une personner
		EniDemoResponse responseManager = ManagerFactory.getManagerByClass(PersonManager.class).addPerson(person);
	
		// Si c'est valide
		if (responseManager.isValid()) {
			response.getWriter().append("Personne ajouté avec succès");
		}
		else {
			response.getWriter().append(String.format("Erreur : %d - %s", responseManager.responseCode, responseManager.responseMessage));
		}
	}

}
