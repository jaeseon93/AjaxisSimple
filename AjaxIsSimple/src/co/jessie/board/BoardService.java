package co.jessie.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BoardService {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public BoardService() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public abstract List<BoardDTO> allSelect (BoardDTO board);
	public abstract void insertBoard(BoardDTO board);
	public abstract void updateBoard(BoardDTO board);
	public abstract BoardDTO getBoard(int boardNo);   // 한건만 가지고 오는것
	public abstract List<BoardDTO> getReplyList(int boardNo);
	
}
