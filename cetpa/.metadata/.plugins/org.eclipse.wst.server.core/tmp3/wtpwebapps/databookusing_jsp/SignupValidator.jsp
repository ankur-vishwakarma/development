<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verification</title>
</head>
<body>
 <h1 style="font-size:60px;color:blue;text-align:center;background-color:LightGray;border:2px solid Tomato;">DataBook</h1>
      
<%
        String a=request.getParameter("username");
        String b=request.getParameter("email");
        String c=request.getParameter("mobile");
        String d=request.getParameter("address");
        String e=request.getParameter("password");
        
        Class.forName("com.mysql.jdbc.Driver");
		
		Connection co = DriverManager.getConnection
				("jdbc:mysql://localhost/Databook?user=root&password=stark");
		
		// get the PS
		PreparedStatement ps = co.prepareStatement
				("insert into userdetails "
						+ "values(?,?,?,?,?)");
		
		// lets provide values in place of ? marks
		ps.setString(1,a);
		ps.setString(2,b);
		ps.setString(3,c);
		ps.setString(4,d);
		ps.setString(5,e);
		
		// lets execute this query
		int r = ps.executeUpdate();
		
		co.close();
%>
<h4>data updated</h4><br>
<a href="login.jsp">LOGIN</a>
</body>
</html>