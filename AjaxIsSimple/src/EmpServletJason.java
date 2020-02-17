

import java.io.IOException;
import java.io.PrintWriter;
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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class EmpServletJason
 */
@WebServlet("/EmpServletJason")
public class EmpServletJason extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpServletJason() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); // 데이터에 한글있을경우 추가해주면 나타남.
		PrintWriter out = response.getWriter();
		List<DTO> list = new ArrayList<>();
		Service service = new ServiceImple();
		list = service.allSelect();
		JSONArray ary = new JSONArray();
		for (DTO emp : list) {
			JSONObject obj = new JSONObject();
			obj.put("firstName", emp.getFirst_name());
			obj.put("lastName", emp.getLast_name());
			obj.put("email", emp.getEmail());
			obj.put("salary", emp.getSalary());
			obj.put("email", emp.getEmail());
			obj.put("employeeId", emp.getEmployee_id());
			ary.add(obj);
		}
		out.print(ary.toString());
//		{"employees":[
//                      { "firstName":"John", "lastName":"Doe" },
//		              { "firstName":"Anna", "lastName":"Smith" },
//		              { "firstName":"Peter", "lastName":"Jones" }
//		            ]}
//		String emps = "{\"employees\":[";
//		int cnt = list.size();
//		int iCnt = 0;
//		for(DTO emp : list) {
//			emps += "{\"empId\":\""+emp.getEmployee_id() + "\","
//				+ "\"firstName\":\"" + emp.getFirst_name() + "\","
//				+ "\"lastName\":\"" + emp.getLast_name() + "\","
//				+ "\"email\":\"" + emp.getEmail() + "\","
//				+ "\"salary\":\"" + emp.getSalary() + "\"}";
//				
//		        
//			if(++iCnt != cnt) {
//				emps += ",";
//			}
//		}
//		
//		emps += "]}";
		
		
		
	}

}
