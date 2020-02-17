
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeesie.emp.service.Service;
import co.jeesie.emp.service.ServiceImple;
import co.jessie.emp.dto.DTO;

/**
 * Servlet implementation class EmpServletXML
 */
@WebServlet("/EmpServletXML")
public class EmpServletXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public EmpServletXML() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DTO> list = new ArrayList<>();
		Service service = new ServiceImple();
		list = service.allSelect();
		String emps = "<employees>";
		for (DTO emp : list) {
			emps += "<employee>"
			+ "<EmployeeId>" + emp.getEmployee_id() + "</EmployeeId>"
			+ "<FirstName>" + emp.getFirst_name() + "</FirstName>"
			+ "<LastName>" + emp.getLast_name() + "</LastName>"
			+ "<Email>" + emp.getEmail() + "</Email>"
			+ "<PhoneNumber>" + emp.getPhone_number() + "</PhoneNumber>"
			+ "<HireDate>" + emp.getHire_date() + "</HireDate>"
			+ "<JobId>" + emp.getJob_id() + "</JobId>"
			+ "<Salary>" + emp.getSalary() + "</Salary>";
			emps += "</employee>";
		}
		emps += "</employees>";
		response.getWriter().append(emps);
	}
}
