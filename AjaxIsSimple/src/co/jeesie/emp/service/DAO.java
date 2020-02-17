package co.jeesie.emp.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DAO {
	public Connection conn;
	public PreparedStatement psmt;
	public ResultSet rs;

	private String driver;
	private String url;
	private String user;
	private String password;

	public DAO() {
//		getConfiguration(); //driver,url,user,password 값을 담아서 환경파일을 읽고 conn실행.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getConfiguration() {
		Properties properties = new Properties();
		try {		
			Reader reader = new FileReader("src/config/db.propertise");
			properties.load(reader);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

