<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <%
         int x=Integer.parseInt(request.getParameter("a"));
        int y=Integer.parseInt(request.getParameter("b"));
        int z=Integer.parseInt(request.getParameter("c"));
         int res=x+y+z;
        %>
        <table border="1">
        <tr>
        <td>x</td>
        <td><%=x %></td>
        <td>y</td>
        <td><%=y %></td>
        <td>z</td>
        <td><%=z %></td>
        <td>resu</td>
        <td><%=x %></td>
        </tr>
        </table>
</body>
</html>