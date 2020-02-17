package co.jessie.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl extends BoardService {

	@Override
	public List<BoardDTO> allSelect(BoardDTO board) {
		String sql = "SELECT * FROM board WHERE parent_no is null order by 1 ";
		List<BoardDTO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(); // executeQuery() : 쿼리를 실행해달라는 뜻
			while (rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setBoardNo(rs.getInt("board_no")); // BoardDTO에서 rs.로 읽어올때의 " " 은 db의칼럼이름과 일치해야함!!
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriter(rs.getString("writer"));
				b.setSysdate(rs.getString("creation_date"));
				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void insertBoard(BoardDTO board) {
		String sql = "INSERT INTO board values(" + "(SELECT nvl(max(board_no),0)+1 FROM board),"
				+ "?, ?, ?, sysdate, null)"; // title, content, writer, date, parent_no
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateBoard(BoardDTO board) {

	}

	@Override
	public BoardDTO getBoard(int boardNo) {
		String sql = "SELECT * FROM board WHERE board_no = ?";
		BoardDTO b = new BoardDTO();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				b.setBoardNo(rs.getInt("board_no")); // BoardDTO에서 rs.로 읽어올때의 " " 은 db의칼럼이름과 일치해야함!!
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriter(rs.getString("writer"));
				b.setSysdate(rs.getString("creation_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
	}

	public List<BoardDTO> getReplyList(int boardNo) {
		String sql = "SELECT * FROM board WHERE parent_no = ? order by 1 desc";
		List<BoardDTO> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			rs = psmt.executeQuery(); // executeQuery() : 쿼리를 실행해달라는 뜻
			while (rs.next()) {
				BoardDTO b = new BoardDTO();
				b.setBoardNo(rs.getInt("board_no")); // BoardDTO에서 rs.로 읽어올때의 " " 은 db의칼럼이름과 일치해야함!!
				b.setTitle(rs.getString("title"));
				b.setContent(rs.getString("content"));
				b.setWriter(rs.getString("writer"));
				b.setSysdate(rs.getString("creation_date"));
				b.setParentNo(rs.getInt("parent_no"));
				list.add(b);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
