package co.jessie.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
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
		BoardService service = new BoardServiceImpl();
		String bNo = request.getParameter("boardNo");
		int boardNo = Integer.parseInt(bNo);
		//댓글
		List<BoardDTO> replyList = service.getReplyList(boardNo);
		JSONArray replyAry = new JSONArray();
		for (BoardDTO b : replyList) {
		JSONObject robj = new JSONObject();
		robj.put("rboardNo", b.getBoardNo());
		robj.put("rcontent", b.getContent());
		robj.put("rwriter", b.getWriter());
		robj.put("rdate", b.getSysdate());
		robj.put("rpNo", b.getParentNo());
		replyAry.add(robj);
		}
		//원본 글
		service = new BoardServiceImpl();
		JSONObject obj = new JSONObject();
		BoardDTO brd = service.getBoard(boardNo);
		obj.put("boardNo", brd.getBoardNo());
		obj.put("title", brd.getTitle());
		obj.put("content", brd.getContent());
		obj.put("writer", brd.getWriter());
		obj.put("cDate", brd.getSysdate());
		obj.put("rList", replyAry);
		
		out.print(obj);
		
		
	}

}
