package co.jessie.calEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CalDAO {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	private String driver;
	private String url;
	private String user;
	private String password;

	public CalDAO() {
//		getConfiguration(); //driver,url,user,password 값을 담아서 환경파일을 읽고 conn실행.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	   
	   public void insertCal(CalEvent event) {
	      String sql = "insert into schedule values(?,?,?,?)";
	      try {
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, event.getGroup_id());
	         psmt.setString(2, event.getTitle());
	         psmt.setString(3, event.getStart_date());
	         psmt.setString(4, event.getEnd_date());
	         int r = psmt.executeUpdate();
	         System.out.println( r + "건 입력됨");	         
	       } catch (SQLException e) {
	          e.printStackTrace();
	       } finally {
	    	   try {
	    		   conn.close();
	    	   } catch (SQLException e) {
	    		   e.printStackTrace();
	    	   }
	       }
	   } // end of insertCal
	   
	   public List<CalEvent> getTotalEvent(){
		   String sql = "select * from schedule";
		   List<CalEvent> list = new ArrayList<>();
		   try {
			   psmt = conn.prepareStatement(sql);
			   rs = psmt.executeQuery();
			   while (rs.next()) {
				   CalEvent e = new CalEvent();
				     e.setGroup_id(rs.getInt("group_Id"));
			         e.setStart_date(rs.getString("start_date"));
			         e.setEnd_date(rs.getString("end_date"));
			         e.setTitle(rs.getString("title"));
			         list.add(e);

			   }
		   } catch (SQLException e) {
		          e.printStackTrace();
		       } finally {
		    	   try {
		    		   if (conn != null) {
		    		   conn.close();
		    		 }
		    	   } catch (SQLException e) {
		    		   e.printStackTrace();
		    	   }
		       }
		return list;
	   }
	
}
