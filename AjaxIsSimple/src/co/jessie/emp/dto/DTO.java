package co.jessie.emp.dto;

import java.sql.Date;

public class DTO {
	private int employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private int salary;

	private void DTO() {
		
	}

	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public Date getHire_date() {
		return hire_date;
	}


	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}


	public String getJob_id() {
		return job_id;
	}


	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		System.out.print(employee_id + " : ");
		System.out.print(first_name + " : ");
		System.out.print(last_name + " : ");
		System.out.print(email + " : ");
		System.out.print(phone_number + " : ");
		System.out.print(hire_date + " : ");
		System.out.print(job_id + " : ");
		System.out.println(salary);
		return "";
		
	}
	
	
}	

