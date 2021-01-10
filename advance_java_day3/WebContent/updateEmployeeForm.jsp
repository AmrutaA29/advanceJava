<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "com.zensar.Bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%Employee employee  = (Employee)request.getAttribute("employee"); %>
<body>
<form action="updateEmployee" method="get">
<input type="hidden" name="requestAction" value="update" />
<h2>Update employee form</h2>
<table>
<tr>
<td> Employee Id: </td>
<td> <input type="text" name="employeeId" value="<%=employee.getEmployeeId() %>" /></td>
</tr>
<tr>
<td> Employee Name: </td>
<td> <input type="text" name="employeeName" value ="<%=employee.getEmployeeName() %>" /></td>
</tr>
<tr>
<td> Designation: </td>
<td> <input type="text" name="designation" value=<%=employee.getDesignation() %>/></td>
</tr>
<tr>
<td> Salary: </td>
<td> <input type="text" name="salary" value="<%=employee.getSalary() %>"/></td>
</tr>
<tr>
<td>Male <input type="radio" name="gender" value="male" <%if(employee.getGender().equalsIgnoreCase("male")){ %>checked<%} %> />
&nbsp;&nbsp; Female<input type="radio" name="gender" value="female" <%if(employee.getGender().equalsIgnoreCase("female")){ %>checked<%} %> />
</td>
</tr>

<tr>
<td>City:</td>
<td>
<select name="city">
<option value="Pune" label="Pune" <%if(employee.getCity().equalsIgnoreCase("Pune")){ %>selected<%} %> />
<option value="Mumbai" label="Mumbai" <%if(employee.getCity().equalsIgnoreCase("Mumbai")){ %>selected<%} %>/>
<option value="Delhi" label="Delhi" <%if(employee.getCity().equalsIgnoreCase("Delhi")){ %>selected<%} %>/>
</select>
</td>
<tr>
<td> &nbsp; </td>
<td> <input type="submit" value="Update Employee" /></td>
</tr>
</table>
</form>
</body>
</html>