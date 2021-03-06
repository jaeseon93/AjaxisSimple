

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jeesie.emp.service.Service;
import co.jeesie.emp.service.ServiceImple;

@WebServlet("/DeleteEmpServlet")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteEmpServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	 protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String empId = request.getParameter("empId");
	      int eId = Integer.parseInt(empId);
	      
	      Service service= new ServiceImple();
	      service.delete(eId);
	   }

}
