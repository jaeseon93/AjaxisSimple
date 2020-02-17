package co.jeesie.emp.service;

import java.util.List;

import co.jessie.emp.dto.DTO;

public interface Service {
	public List<DTO> allSelect();
	public void delete(int eId);
	public int insert(DTO emp);
}
