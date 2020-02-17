

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeesie.emp.service.Service;
import co.jeesie.emp.service.ServiceImple;
import co.jessie.emp.dto.DTO;


@WebServlet("/InsertEmpServlet")
public class InsertEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public InsertEmpServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String FName = request.getParameter("FName");
		String LName = request.getParameter("LName");
		String email = request.getParameter("email");
		String salary = request.getParameter("salary");
		int e = Integer.parseInt(salary); // 스트링타입인 salary를 int로 바꿔주는 구문.
	
		DTO dto = new DTO();
		dto.setFirst_name(FName);
		dto.setLast_name(LName);
		dto.setEmail(email);
		dto.setJob_id("AD_VP");
		dto.setSalary(e);
		
		Service service = new ServiceImple();
		int empId = service.insert(dto);
		
		
		PrintWriter out = response.getWriter();
		out.print(empId);
		
	}

}
