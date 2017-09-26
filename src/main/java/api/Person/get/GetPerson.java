package api.Person.get;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import api.Person.Person;
import api.dataBase.SaveObject;

/**
 * Servlet implementation class GetPerson
 */
public class GetPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		SaveObject so = new SaveObject();

		try {
			@SuppressWarnings("unchecked")
			ArrayList<Person> person = (ArrayList<Person>) so.getObject(id);
			if (person.size() > 0)
				response.getWriter().append("The information of Person with id = "
						+ person.get(person.size() - 1).getId() + " is: \n " + mapper.writeValueAsString(person));
			else
				response.getWriter().append("the person with id of " + id + " is not in the database");

		} catch (Exception e) {
			response.getWriter().append("this person is not here ");
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
