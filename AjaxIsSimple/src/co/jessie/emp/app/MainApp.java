package co.jessie.emp.app;

import java.util.ArrayList;
import java.util.List;

import co.jeesie.emp.service.ServiceImple;
import co.jessie.emp.dto.DTO;

public class MainApp {

	public static void main(String[] args) {
		List<DTO> list = new ArrayList<DTO>();
		DTO dto = new DTO();
		ServiceImple service = new ServiceImple();
	
		list = service.allSelect();
		toPrint(list);
	
	}

	public static void toPrint(List<DTO> list) {
		for(DTO dto : list) {
			System.out.print(dto.getEmployee_id() + " | ");
			System.out.print(dto.getFirst_name() + " | ");
			System.out.print(dto.getLast_name() + " | ");
			System.out.print(dto.getEmail() + " | ");
			System.out.print(dto.getPhone_number() + " | ");
			System.out.print(dto.getHire_date() + " | ");
			System.out.print(dto.getJob_id() + " | ");
			System.out.println(dto.getSalary());
		}
	}
	
}
