package co.jessie.calEvent;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/CalListServlet")
public class CalListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CalListServlet() {
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
		CalDAO dao = new CalDAO();		
		List<CalEvent> list = new ArrayList<CalEvent>();
		list = dao.getTotalEvent();
		JSONArray ary = new JSONArray();
		for (CalEvent e : list) {
			JSONObject obj = new JSONObject();
			obj.put("groupid", e.getGroup_id());
			obj.put("title", e.getTitle());
			obj.put("start", e.getStart_date());
			obj.put("end", e.getEnd_date());
			ary.add(obj);
			
		}
		PrintWriter out = response.getWriter();	
		out.print(ary.toString());
	}
}
