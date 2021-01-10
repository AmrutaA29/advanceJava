package com.zensar;

 

import java.sql.*;
import java.util.*;
import com.zensar.Bean.Employee;
import com.zensar.utility.DBUtil;

public class EmployeeRepository {

 

 public void addEmployee(Employee employee) {
    Connection con = DBUtil.getMySqlDbConnection();
    String sql = "insert into employee values (?,?,?,?,?,?)";
    try {
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, employee.getEmployeeId());
    pst.setString(2, employee.getEmployeeName());
    pst.setString(3, employee.getDesignation());
    pst.setInt(4, employee.getSalary());
    pst.setString(5, employee.getGender());
    pst.setString(6, employee.getCity());
    
    int result = pst.executeUpdate();
    if(result==0) {
    System.out.println("Database Operation Failed");
    }else {
    System.out.println("Database Operation Successful");
    }
    }catch(Exception e) {
    System.out.println("Exception Occured:"+e);
    }
 }
    
    public List<Employee> getAllEmployees(){
        List<Employee> listOfAllEmployees = new ArrayList<Employee>();
        // jdbc code to fetch all employees from db and add them to this list
        Connection con = DBUtil.getMySqlDbConnection();
        String sql = "select * from employee";
        try {
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()) {
        int employeeId = rs.getInt("employee_id");
        String employeeName = rs.getString("employee_name");
        String designation = rs.getString("designation");
        int salary = rs.getInt("salary");
        String gender = rs.getString("gender");
        String city = rs.getString("city");
        
        Employee employee = new Employee(employeeId, employeeName, designation, salary,gender,city);
        listOfAllEmployees.add(employee);
        }
        }catch(Exception e) {
        System.out.println("Exception Occured:"+e);
        }
        System.out.println("listOfAllEmployees:"+listOfAllEmployees);
        return listOfAllEmployees;
        }
    
    public void deleteemployee(int employeeId) {
    	Connection con = DBUtil.getMySqlDbConnection();
    	String sql = "delete from employee where employee_id=?";
    	try {
    		PreparedStatement psmt = con.prepareStatement(sql);
    		psmt.setInt(1,employeeId);
    		int re = psmt.executeUpdate();
    		if(re == 0) {
    			System.out.println("Deletion not successfull");
    		}
    		else {
    			System.out.println("Deletion successful");
    		}
    	}
    	catch(Exception e) {
    		System.out.println("Exception occured: "+e);
    	}
    	
    	
    }
    
    public Employee getEmployee(int employeeId) {
    	Employee employee = null;
    	Connection con = DBUtil.getMySqlDbConnection();
    	String sql = "select *from employee where employee_id = ?";
    	try {
    		PreparedStatement psmt = con.prepareStatement(sql);
    		psmt.setInt(1, employeeId);
    		ResultSet rs = psmt.executeQuery();
    		while(rs.next()) {
    			String name = rs.getString("employee_name");
    			String designation = rs.getString("designation");
    			int sal = Integer.parseInt(rs.getString("salary")); 
    			String gender = rs.getString("gender");
    			String city = rs.getString("city");
    			
    			employee = new Employee(employeeId,name,designation,sal,gender,city);
    			
    		}
    	}catch(Exception e) {
    		System.out.println("Exception occured: "+e);
    	}
    	return employee;
    }
    
   public void update(Employee employee) {
	   Connection con = DBUtil.getMySqlDbConnection();
	   String sql = "update employee set employee_name=?,designation=?,salary=?,gender=?,city=? where employee_id=?";
	  
	   
	   try {
		   PreparedStatement psmt = con.prepareStatement(sql);
		   psmt.setString(1,employee.getEmployeeName());
		   psmt.setString(2, employee.getDesignation());
		   psmt.setInt(3, employee.getSalary());
		   psmt.setString(4,employee.getGender());
		   psmt.setString(5, employee.getCity());
		   psmt.setInt(6, employee.getEmployeeId());
		   psmt.executeUpdate();
		   
		  
	   }catch(Exception e) {
		   System.out.println("Exception occured: "+e);
	   }
   }
}