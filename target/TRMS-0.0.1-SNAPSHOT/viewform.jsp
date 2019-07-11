
<%@page import="com.revature.pojo.Reimbursement"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
<h1>show all list in reimbursement in data base</h1>

<%@ page import="com.revature.dao.*" %> 
<%
	
		ReimbursementDao  rd= new ReimbursementDao();
 		List <Reimbursement> list= rd.viewAllReimbursement();
 		for(Reimbursement l:list)
 		{
 			%>
 		<table>
 		<tr>
 			<td> <%= l.getCourse_cost() %> </td>
 		</tr>
 		
 		
 		</table>	
 		
 			
 			
 			
 			
 			<% } %>
 			
 		
 
 		
  <script src="./JS/javas.js"></script> 		
</body>

</html>