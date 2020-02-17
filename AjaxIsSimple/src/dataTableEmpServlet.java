

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


@WebServlet("/dataTableEmpServlet")
public class dataTableEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public dataTableEmpServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8"); 
		PrintWriter out = response.getWriter();
		List<DTO> list = new ArrayList<>();
		Service service = new ServiceImple();
		list = service.allSelect();
		JSONArray ary = new JSONArray();		
		for (DTO emp : list) {
			JSONArray ary2 = new JSONArray();    // [] 을 만들고 []안에 밑에 내용들을 넣음.		
			ary2.add(emp.getEmployee_id());
			ary2.add(emp.getFirst_name());
			ary2.add(emp.getLast_name());
			ary2.add(emp.getEmail());
			ary2.add(emp.getHire_date()+ "");  //hire_date가 date타입이기때문에 가져오지못함. 뒤에 ""을 붙여서 문자열로 인식하게해야함.
			ary2.add(emp.getSalary());
			ary.add(ary2);
		}
		
		 JSONObject obj = new JSONObject();
	      obj.put("data", ary);
	      
	      out.print(obj.toString());
	}
}
