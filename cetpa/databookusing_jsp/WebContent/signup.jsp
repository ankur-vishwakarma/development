<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup page</title>
</head>
<body>
       <h1 style="font-size:60px;color:blue;text-align:center;background-color:LightGray;border:2px solid Tomato;">DataBook</h1>
      
<%-- <form action="jha p dta bhejna h uss jsp k naam" method="get y phir post"> --%>
<form action="SignupValidator.jsp" method="post">
<b>input ur name</b><br>
<input type="text" name="username"><br>

<b>input your email</b><br>
<input type="text" name="email"><br>

<b>input ur mobile-no</b><br>
<input type="text" name="mobile"><br>

<b>input your address</b><br>
<input type="text" name="address"><br>

<b>input a strong password</b><br>
<input type="password" name="password"><br>

<input type="submit" value="Signup">

</form>
</body>
</html>