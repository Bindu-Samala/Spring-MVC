package com.accenture.service;

import java.util.List;

import com.accenture.beans.Employee;

public interface EmployeeService {
	public List<Employee> getEmpDetails();
	public void saveEmpDetails(Employee emp);
	public int delete(int id);
	public int update(Employee emp);
	public Employee getEmpById(int id);
}
