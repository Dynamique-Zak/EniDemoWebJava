package fr.eni.demo.servet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.demo.bo.Person;

/**
 * Servlet implementation class ExampleButtonValue
 */
@WebServlet("/ExampleButtonValue")
public class ExampleButtonValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExampleButtonValueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Example objet complet
		Person person = new Person("Isaac");
		request.setAttribute("person", person);
		
		// Afficher page HTML
		RequestDispatcher rd = request.getRequestDispatcher("example-button.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String selection = request.getParameter("selection");
		
		
		
		response.getWriter().append(String.format("Vous avez selectionné %s", selection));
	}

}
