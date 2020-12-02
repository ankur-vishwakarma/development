<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Database cars</title>
</head>
<body>
 <% 
      int flag=Integer.parseInt(request.getParameter("flag"));
      int id=Integer.parseInt(request.getParameter("i"));
      Class.forName("com.mysql.jdbc.Driver");

      Connection co = DriverManager.getConnection
      		("jdbc:mysql://localhost/cars?user=root&password=stark");
      if(flag==1){
    	 PreparedStatement ps1 = co.prepareStatement
    	      		("delete from car where id = ?");

       	ps1.setInt(1, id);
       	
    	  ps1.executeUpdate();
      }
      PreparedStatement ps = co.prepareStatement
      		("select * from car");

      ResultSet rs = ps.executeQuery();
      int i=0;

      
      	while(rs.next()){
      		
                String a=rs.getString(1);
          		String p=rs.getString(2);
          		String q=rs.getString(3);
          		String r=rs.getString(4);
          		String s=rs.getString(5);
          		i++;
          		%>
          	<table  border="1" width="600px">
          	<tr>
          	<td width="100px"><%=a %></td>
          	<td width="100px"><%=p %></td>
          	<td width="100px"><%=q %></td>
          	<td width="100px"><%=r %></td>
          	<td width="100px"><%=s %></td>
          	<td width="100px"><a href="showall.jsp?i=<%=a %>&flag=1">delete</a></td>
    
          	</tr>
          	</table>
          		
          		
         <% 		
      	}
      		
 
      
      // close the connection
      co.close();
   %>
</body>
</html>