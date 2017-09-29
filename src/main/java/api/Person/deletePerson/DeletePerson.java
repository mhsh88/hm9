package api.Person.deletePerson;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import api.dataBase.DB;

/**
 * Servlet implementation class DeletePerson
 */
public class DeletePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DB db = new DB();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doDelete(request, response);
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

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String sql = "DELETE FROM javaobject WHERE id = " + id + ";";
		try {
			boolean dataBaseCheck = db.doExcute(sql);
			if (dataBaseCheck)
				response.getWriter().append("the person with id = " + id + " is deleted!");
			else
				response.getWriter().append("the person is not added so it is not in database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.getWriter().append("server has encountered error" + e.getMessage());
			e.printStackTrace();
		}

	}

}
