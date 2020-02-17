package co.jessie.board;

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

@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
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
		List<BoardDTO> list = new ArrayList<>();
		BoardService service = new BoardServiceImpl();
		list = service.allSelect(null);
		JSONArray ary = new JSONArray();
		for (BoardDTO b : list) {
			JSONObject obj = new JSONObject();
			obj.put("boardNo", b.getBoardNo());  // JSONObject의 put해서 들어가는" "은 화면에서 뿌려줄때 값앞에 부제목처럼 내맘대로정해주는것.
			obj.put("title", b.getTitle());
			obj.put("content", b.getContent());
			obj.put("writer", b.getWriter());
			obj.put("date", b.getSysdate());
			ary.add(obj);
		}
		out.print(ary);
	}

}
