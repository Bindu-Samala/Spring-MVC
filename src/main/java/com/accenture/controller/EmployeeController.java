package com.accenture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.beans.Employee;
import com.accenture.service.EmployeeService;






@Controller
public class EmployeeController {
	@Autowired
	EmployeeService ser;
	@RequestMapping("/empform")  
    public String showform(Model m){  
    	m.addAttribute("emp",new Employee());
    	return "empform"; 
    }
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Employee emp){  
		System.out.println("This is controller----------------------------------------------------");
        ser.saveEmpDetails(emp);  
        return "redirect:/viewemp";//will redirect to viewemp request mapping  
    }
	@RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Employee> list=ser.getEmpDetails();  
        m.addAttribute("list",list);
        return "viewemp";  
    }
	
	@RequestMapping("/getAllEmp")
	public void getEmpDetails() {
		ser.getEmpDetails();
		
	}
	@RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
		System.out.println("employee id from edit-------------------"+id);
        Employee emp=ser.getEmpById(id); 
        System.out.println("employee details------------------"+emp.getId()+"------"+emp.getName()+"-----"+emp.getLocation());
        m.addAttribute("emp",emp);
        return "empeditform";  
    } 
	@RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        int result=ser.delete(id);  
        return "redirect:/viewemp";
        
    }
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)  
	public String editsave(@ModelAttribute("emp") Employee emp){  
        ser.update(emp);  
        return "redirect:/viewemp";  
    } 

}
