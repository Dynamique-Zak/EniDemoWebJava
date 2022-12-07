package fr.eni.demo.servet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.demo.bo.Person;
import fr.eni.demo.dal.DAOArticle;
import fr.eni.demo.dal.DAOFactory;
import fr.eni.demo.dal.DAOPerson;

/**
 * Servlet implementation class DemoJDBCServlet
 */
@WebServlet("/DemoJDBCServlet")
public class DemoJDBCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoJDBCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recupere DAO Personne (par sa classe)
		DAOPerson daoPerson = DAOFactory.getDAOByClass(DAOPerson.class);

		Person person = daoPerson.selectById(1);
		
		System.out.println(person);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
