package api.Person.updatePerson;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.Person.Address;
import api.Person.Person;
import api.dataBase.SaveObject;

/**
 * Servlet implementation class UpdatePerson
 */
public class UpdatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPut(request, response);
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

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		long phoneNumber = Long.parseLong(request.getParameter("phonenumber"));
		String province = request.getParameter("province");
		String city = request.getParameter("city");
		String mainStreet = request.getParameter("mainstreet");
		String street = request.getParameter("street");
		int number = Integer.parseInt(request.getParameter("number"));
		long zipCode = Long.parseLong(request.getParameter("zipcode"));
		Address address = new Address(province, city, mainStreet, street, number, zipCode);
		Person person = new Person(id, firstName, lastName, phoneNumber, address);

		SaveObject so = new SaveObject();

		try {

			so.setJavaObject(person);
			so.updateObject();

			response.getWriter().append("Object is successfully updated!");

		} catch (Exception e) {
			response.getWriter().append("Object is NOT successfully updated! ");
			e.printStackTrace();
		}
	}
}
