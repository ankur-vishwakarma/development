<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DETAILS</title>
</head>
<body style="background-color:powderblue;font-family:verdana;">
<h1 style="font-size:60px;color:blue;text-align:center;background-color:LightGray;border:2px solid Tomato;">CarLelo.ank</h1>
      <% 
      String a=request.getParameter("id");
      
      Class.forName("com.mysql.jdbc.Driver");

      Connection co = DriverManager.getConnection
      		("jdbc:mysql://localhost/cars?user=root&password=stark");

      PreparedStatement ps = co.prepareStatement
      		("select id from car");

      ResultSet rs = ps.executeQuery();

      int index = 0;

      String str = "";

      while(rs.next()) // fetch a record from the result-set
      {
      	String name = rs.getString("id");
      	str = str + name + ",";
      	index++;
      }

      String[] fileNames = str.split(",");
      int flag=0;

      for(int i=0;i<index;i++) if(fileNames[i].equals(a)) flag=1;

      if(flag==1){
      	String query = "select * from car where id = ?";

      	PreparedStatement ps2 = co.prepareStatement(query);

      	ps2.setString(1, a);

      	ResultSet rs2 = ps2.executeQuery();

      	rs2.next();

      		String p=rs2.getString(2);
      		String q=rs2.getString(3);
      		String r=rs2.getString(4);
      		String s=rs2.getString(5);
      		/*out.println("<h2>"+"Details"+"</h2>");
      		out.println("<ul>"
      				+"<li>"+res+"</li>"+
      				"<li>"+res2+"</li>"+
      				"<li>"+res3+"</li>"+
      				"</ul>");*/
      		%>
      <form action="update.jsp">
  <center>$$$DETAILS$$$<br><br>
                 ID:
  <input type="text" name="id" value=<%=a %> readonly><br><br>
  CAR NAME:
  <input type="text" name="cname" value=<%=p %>><br><br>
  MODEL:
  <input type="text" name="model" value=<%=q %>><br><br>
  TYPE:
  <input type="text" name="type" value=<%=r %>><br><br>
  MAKER:
  <input type="text" name="maker" value=<%=s %>><br><br>
  
  
   <a href="http://www.animatedimages.org/cat-cars-67.htm"><img src="http://www.animatedimages.org/data/media/67/animated-car-image-0016.gif" border="0" alt="animated-car-image-0016" /></a><br>
   
   <input type="submit" value="Update details">
   </center>
   
   </form>
      <% }
      else{
      	out.println("PLEASE ENTER A VALID CAR ID."+"<br>");
      	out.println("<a href='http://localhost:8080/asssigmentjsp2/index.jsp'>HOME</a> ");
      }
      // close the connection
      co.close();
      %>
</body>
</html>