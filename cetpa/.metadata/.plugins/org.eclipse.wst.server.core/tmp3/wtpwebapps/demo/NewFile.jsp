<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(2>3) out.println(2+3);
else out.println("i m porwal");
for(int i=1;i<=6;i++) out.println("<h"+(7-i)+">"+i+"</h"+(7-i)+">");
%>
</body>
</html>