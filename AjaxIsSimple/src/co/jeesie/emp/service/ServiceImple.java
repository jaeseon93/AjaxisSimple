package co.jeesie.emp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.jessie.emp.dto.DTO;

public class ServiceImple extends DAO implements Service {
	private final String ALL_SELECT = "SELECT * FROM emp order by 1";
	private final String delete = "Delete FROM emp WHERE employee_id = ?";
	private final String insert = "INSERT INTO emp (employee_id, first_name, last_name, hire_date, job_id, email, salary)" 
	                                + "VALUES (emp_seq.nextval, ?, ?, sysdate, ?, ?, ?)";
	
	private final String insert2 = "SELECT emp_seq.nextval as cnt FROM dual";		                       
	
	@Override
	public List<DTO> allSelect() {
		List<DTO> list = new ArrayList<DTO>();
		DTO dto;
		try {
			psmt = conn.prepareStatement(ALL_SELECT);
			rs = psmt.executeQuery();
			while (rs.next()) {
				dto = new DTO();
				dto.setEmployee_id(rs.getInt("employee_id"));
				dto.setFirst_name(rs.getString("first_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone_number(rs.getString("phone_number"));
				dto.setHire_date(rs.getDate("hire_date"));
				dto.setJob_id(rs.getString("job_id"));
				dto.setSalary(rs.getInt("salary"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void delete(int eId) {
		try {
			psmt = conn.prepareStatement(delete);
			psmt.setInt(1, eId);
			int n = psmt.executeUpdate();
			System.out.println(n + "건 삭제");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int insert(DTO emp) {
		int newEmpId = 0;
		try {
			// 새로 생성되는 emp값을 확인후
			psmt = conn.prepareStatement(insert2);
			rs = psmt.executeQuery();
			if(rs.next()) {
				newEmpId = rs.getInt("cnt");
				
			}
			
			// empId로 사용.
			psmt = conn.prepareStatement(insert);
			psmt.setInt(1, newEmpId);
			psmt.setString(2, emp.getFirst_name());
			psmt.setString(3, emp.getLast_name());
			psmt.setString(4, emp.getJob_id());
			psmt.setString(5, emp.getEmail());
			psmt.setInt(5, emp.getSalary());
			
			int n = psmt.executeUpdate();
			System.out.println(n+ "건 입력 ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newEmpId;
	}
}
