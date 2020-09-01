<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updated</title>
</head>
<body style="background-color:powderblue;font-family:verdana;">

<h1 style="font-size:60px;color:blue;text-align:center;background-color:LightGray;border:2px solid Tomato;">CarLelo.ank</h1>
<%
String a=request.getParameter("id");
String b=request.getParameter("cname");
String c=request.getParameter("model");
String d=request.getParameter("type");
String e=request.getParameter("maker");

Class.forName("com.mysql.jdbc.Driver");

Connection co = DriverManager.getConnection
		("jdbc:mysql://localhost/cars?user=root&password=stark");

// get the PS
PreparedStatement ps = co.prepareStatement
		("update car set name=?,model=?,type=?,maker=? "+"where id=?");

// lets provide values in place of ? marks
ps.setString(1,b);
ps.setString(2,c);
ps.setString(3,d);
ps.setString(4,e);
ps.setString(5,a);

// lets execute this query
ps.executeUpdate();

co.close();
%>

<center><h2>data updated.<br>Thanks for your valuable information.</h2><br>

  <center><a href="index.jsp" title="Go to home"><img src="2010_nfs_hot_pursuit-2560x1600.jpg" alt="carlelo" width="200" height="200"></a></center>
</body>
</html>