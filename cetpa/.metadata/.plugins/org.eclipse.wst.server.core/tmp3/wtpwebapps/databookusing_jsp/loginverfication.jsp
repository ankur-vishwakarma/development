<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1 style="font-size:60px;color:blue;text-align:center;background-color:LightGray;border:2px solid Tomato;">DataBook</h1>
      
<%
String b=request.getParameter("email");
String c=request.getParameter("password");

Class.forName("com.mysql.jdbc.Driver");

Connection co = DriverManager.getConnection
		("jdbc:mysql://localhost/Databook?user=root&password=stark");

PreparedStatement ps = co.prepareStatement
		("select email from userdetails");

ResultSet rs = ps.executeQuery();

int index = 0;

String str = "";

while(rs.next()) // fetch a record from the result-set
{
	String name = rs.getString("email");
	//System.out.println(index+":"+name);
	str = str + name + ",";
	index++;
}

String[] fileNames = str.split(",");
int flag=0;

for(int i=0;i<index;i++) if(fileNames[i].equals(b)) flag=1;

if(flag==1){
	String query = "select * from userdetails where email = ?";

	PreparedStatement ps2 = co.prepareStatement(query);

	ps2.setString(1, b);

	ResultSet rs2 = ps2.executeQuery();

	rs2.next();

	String pw=rs2.getString(5);
     
	if(pw.equals(c)){
		String res="Name: "+rs2.getString(1);
		String res2="Mobile: "+rs2.getString(3);
		String res3="Address: "+rs2.getString(4);
		out.println("<h2>"+"Details"+"</h2>");
		out.println("<ul>"
				+"<li>"+res+"</li>"+
				"<li>"+res2+"</li>"+
				"<li>"+res3+"</li>"+
				"</ul>");
	}
	else out.println("Invalid Password");
}
else{
	out.println("This email doesnt exist in database."+"<br>");
	out.println("<a href='signup.jsp'>Signup</a> ");
}
// close the connection
co.close();
%>
</body>
</html>