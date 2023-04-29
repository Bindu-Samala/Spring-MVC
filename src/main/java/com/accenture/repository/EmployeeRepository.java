package com.accenture.repository;

import java.util.List;

import com.accenture.beans.Employee;

public interface EmployeeRepository {
	
	public List<Employee> getEmployee();
	public int save(Employee emp);
	public int delete(int id);
	public int update(Employee emp);
	public Employee getEmpById(int id);

}
