package com.accenture.repository;

import java.sql.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.accenture.beans.Employee;





@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	String url="jdbc:mysql://localhost:3306/springmvc";
	String username="root";
	String password="root";
	public JdbcTemplate template;
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	public List<Employee> getEmployee(){  
	    return template.query("select * from employee",new RowMapper<Employee>(){  
	        public Employee mapRow(ResultSet rs, int row) throws SQLException {  
	            Employee e=new Employee();  
	            e.setId(rs.getInt(1));  
	            e.setName(rs.getString(2));  
	            e.setLocation(rs.getString(3));  
	            e.setPhoneno(rs.getString(4));  
	            return e;  
	        }  
	    });  
	}
	
	@Override
	/*public void getEmployee()  {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql="select * from employee";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			if(conn!=null)
			{
				System.out.println("Connected to database-----------------");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}*/

	
	/*public int save(Employee emp){ 
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,username,password);
			String sql="insert into employee(empId,empName,location,phoneno) values('"+emp.getId()+"','"+emp.getName()+"','"+emp.getLocation()+"','"+emp.getPhoneno()+"')"; 
			PreparedStatement ps=conn.prepareStatement(sql);
			 result=ps.executeUpdate();
			if(conn!=null)
			{
				System.out.println("Connected to database-----------------");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	      
	    return result;  
	}*/
	public int save(Employee emp){  
	    String sql="insert into employee(empId,empName,location,phoneno) values('"+emp.getId()+"','"+emp.getName()+"','"+emp.getLocation()+"','"+emp.getPhoneno()+"')";  
	    return template.update(sql);  
	}  
	
	public int delete(int id){  
	    String sql="delete from Employee where empId="+id+"";  
	    return template.update(sql);  
	}  
	public int update(Employee p){  
	    String sql="update Employee set empName='"+p.getName()+"', location='"+p.getLocation()+"',phoneno='"+p.getPhoneno()+"' where empId="+p.getId()+""; 
	    System.out.println("employee id in update---------------------------"+p.getId());
	    return template.update(sql);  
	}
	/*public Employee getEmpById(int id){  
		 System.out.println("employee id in repository getEmpById()---------------------------"+id);
	    String sql="select * from employee where empId=?";  
	    Employee emp= template.queryForObject(sql, new Object[]{id},new  BeanPropertyRowMapper<Employee>(Employee.class)); 
	    emp.setId(id);
	    System.out.println("The employee id in getEmpId repo ends-----------------------------"+emp.getId()+"------"+emp.getLocation()+"---"+emp.getPhoneno()+"--"+emp.getName());
	    return emp;
	}*/
	public Employee getEmpById(int id)  {
		//String sql="select * from employee where empId=?";
		Employee emp=new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,username,password);
			
			PreparedStatement ps=conn.prepareStatement("select * from employee where empId=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
		
			while(rs.next()) {
				String empName=rs.getString("empName");
				String location=rs.getString("location");
				String phoneno=rs.getString("phoneno");
				System.out.println("getempbyid()----------------"+empName+"-------"+location+"----------"+phoneno);
				emp.setName(empName);
				emp.setLocation(location);
				emp.setPhoneno(phoneno);
				emp.setId(id);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
		 
		
	}
	

}
