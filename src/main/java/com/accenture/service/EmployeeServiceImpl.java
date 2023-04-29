package com.accenture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.beans.Employee;
import com.accenture.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
   EmployeeRepository repo;
	@Override
	public List<Employee> getEmpDetails() {
		// TODO Auto-generated method stub
		List<Employee> ls =repo.getEmployee();
		return ls;
		
	}
	@Override
	public void saveEmpDetails(Employee emp) {
		// TODO Auto-generated method stub
		repo.save( emp);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		int result=repo.delete(id);
		return result;
	}
	@Override
	public int update(Employee emp) {
		// TODO Auto-generated method stub
		int result=repo.update(emp);
		return result;
	}
	@Override
	public Employee getEmpById(int id) {
		// TODO Auto-generated method stub
		System.out.println("Inside service getEmpById() starts---------------------------");
		Employee result=repo.getEmpById(id);
		System.out.println("the details of employee from servuuice ----"+result.getId());
		return result;
	}

}
