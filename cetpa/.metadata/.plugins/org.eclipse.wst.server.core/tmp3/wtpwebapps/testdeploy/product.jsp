<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.sql.*" %>
    <%@ page import="java.util.Random" %>
<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>piece of cake</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href='http://fonts.googleapis.com/css?family=Maven+Pro:400,900,700,500' rel='stylesheet' type='text/css'>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--- start-mmmenu-script---->
<script src="js/jquery.min.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="css/jquery.mmenu.all.css" />
<script type="text/javascript" src="js/jquery.mmenu.js"></script>
		<script type="text/javascript">
			//	The menu on the left
			$(function() {
				$('nav#menu-left').mmenu();
			});
		</script>
<!-- start top_js_button -->
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
   <script type="text/javascript">
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event){		
				event.preventDefault();
				$('html,body').animate({scrollTop:$(this.hash).offset().top},1200);
			});
		});
	</script>
</head>
<body>
<% 
//String a=request.getParameter("i");
//out.println(a);
Class.forName("com.mysql.jdbc.Driver");

Connection co = DriverManager.getConnection
		("jdbc:mysql://localhost/cakes?user=root&password=stark");

PreparedStatement ps = co.prepareStatement
		("select * from cake4");
//int[] price;
int []id=new int[100];
String name[]=new String[100];
int []price=new int[100];
String[] img=new String[100];
String[] des=new String[100];
int i=0;

ResultSet rs = ps.executeQuery();

while(i<6){
	rs.next();
	id[i]=rs.getInt(1);
	name[i]=rs.getString(2);
	price[i]=rs.getInt(3);
	des[i]=rs.getString(4);
	img[i]="images/cakes/"+rs.getString(5);
	i++;
}
//for(i=0;i<3;i++) out.println(id[i]);

i=0;
/* String name=rs.getString(2);
int price=rs.getInt(3);
String des=rs.getString(4);
String img=rs.getString(5);
String imgs="images/smalldynamic/"+img;
String imgl="images/Ldynamic/"+img; */

%>
<!-- start header -->
<div class="top_bg">
<div class="wrap">
	<div class="header">
		<div class="logo">
			<a href="index.html"><img src="images/cakes/logo (1).jpg" alt=""/></a>
		</div>
		 <div class="log_reg">
				<ul>
					<li><a href="login.html">Login</a> </li>
					<span class="log"> or </span>
					<li><a href="register.html">Register</a> </li>								   
					<div class="clear"></div>
				</ul>
		</div>	
		<div class="web_search">
		 	<form>
				<input type="text" value="" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
				<input type="submit" value=" " />
			</form>
	    </div>						
		<div class="clear"></div>
	</div>	
</div>
</div>
<!-- start header_btm -->
<div class="wrap">
<div class="header_btm">
		<div class="menu">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li class="active"><a href="products.html">products</a></li>
				<li><a href="about.html">about</a></li>
				<li><a href="index.html">pages</a></li>
				<li><a href="blog.html">blog</a></li>
				<li><a href="contact.html">Contact</a></li>
				<div class="clear"></div>
			</ul>
		</div>
		<div id="smart_nav">
			<a class="navicon" href="#menu-left"> </a>
		</div>
		<nav id="menu-left">
			<ul>
				<li><a href="index.html">Home</a></li>
				<li><a href="products.html">products</a></li>
				<li><a href="about.html">about</a></li>
				<li><a href="index.html">pages</a></li>
				<li><a href="blog.html">blog</a></li>
				<li><a href="contact.html">Contact</a></li>
				<div class="clear"></div>
			</ul>
		</nav>
	<div class="header_right">
		<ul>
			<li><a href="#"><i  class="art"></i><span class="color1">30</span></a></li>
			<li><a href="#"><i  class="cart"></i><span>0</span></a></li>
		</ul>
	</div>
	<div class="clear"></div>
</div>
</div>
<!-- start top_bg -->
<div class="top_bg">
<div class="wrap">
<div class="main_top">
	<h2 class="style">our products</h2>
</div>
</div>
</div>
<!-- start main -->
<div class="main_bg">
<div class="wrap">
<div class="main">
	<div class="top_main">
		<h2>new arrivals on piece of cake</h2>
		<a href="#">show all</a>
		<div class="clear"></div>
	</div>
	<!-- start grids_of_3 -->
	<div class="grids_of_3">
		<div class="grid1_of_3">
			<a href="fetchdetails.jsp?i=<%=id[i]%>">
				<img src=<%=img[i] %> alt="">
				<h3><%=name[i] %></h3>
				<span class="price"><%=price[i] %></span>
			</a>
		</div>
		<div class="grid1_of_3">
			<a href="fetchdetails.jsp?i=<%=id[i+1]%>">
				<img src=<%=img[i+1] %> alt="">
				<h3><%=name[i+1] %></h3>
				<span class="price"><%=price[i+1] %></span>
				<span class="price1 bg">on sale</span>
			</a>
		</div>
		<div class="grid1_of_3">
			<a href="fetchdetails.jsp?i=<%=id[i+2]%>">
				<img src=<%=img[i+2] %> alt="">
				<h3><%=name[i+2] %></h3>
				<span class="price"><%=price[i+2] %></span>
			</a>
		</div>
		<div class="clear"></div>
	</div>
	<div class="top_main">
		<h2>best sellers of the month</h2>
		<a href="#">show all</a>
		<div class="clear"></div>
	</div>
	<!-- start grids_of_3 -->
	<div class="grids_of_3">
		<div class="grid1_of_3">
			<a href="fetchdetails.jsp?i=<%=id[i+3]%>">
				<img src=<%=img[i+3] %> alt="">
				<h3><%=name[i+3] %></h3>
				<span class="price"><%=price[i+3] %></span>
			</a>
		</div>
		<div class="grid1_of_3">
			<a href="fetchdetails.jsp?i=<%=id[i+4]%>">
				<img src=<%=img[i+4] %> alt="">
				<h3><%=name[i+4] %></h3>
				<span class="price"><%=price[i+4] %></span>
			</a>
		</div>
		<div class="grid1_of_3">
			<a href="fetchdetails.jsp?i=<%=id[i+5]%>">
				<img src=<%=img[i+5] %> alt="">
				<h3><%=name[i+5] %></h3>
				<span class="price"><%=price[i+5] %></span>
				<span class="price1 bg1">out of stock</span>
			</a>
		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<!-- start grids_of_2 -->
	<div class="grids_of_2">
		<div class="grid1_of_2">
			<div class="span1_of_2">
				<h2>free shipping</h2>
				<p>Lorem Ipsum is simply dummy  typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
			</div>
			<div class="span1_of_2">
				<h2>testimonials</h2>
				<p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using [...]</p>
			</div>
		</div>
		<div class="grid1_of_2 bg">
			<h2>blog news</h2>
			<div class="grid_date">
				<div class="date1"> 
					<h4>apr 01</h4>
				</div>
				<div class="date_text">
					<h4><a href="#"> Donec vehicula est ac augue consectetur,</a></h4>
					<p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form</p> 
				</div>
				<div class="clear"></div>
			</div>
			<div class="grid_date">
				<div class="date1"> 
					<h4>feb 01</h4>
				</div>
				<div class="date_text">
					<h4><a href="#"> The standard chunk of Lorem Ipsum used since ,,</a></h4>
					<p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from </p> 
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
</div>
</div>
</div>
<!-- start footer -->
<div class="footer_top">
<div class="wrap">
<div class="footer">
	<!-- start grids_of_3 -->
	<div class="span_of_3">
		<div class="span1_of_3">
			<h3>text edit</h3>
			<p>But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.</p>
		</div>
		<div class="span1_of_3">
			<h3>twitter widget</h3>
			<p><a href="#">@Contrarypopular</a> I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give <a href="#">@accountofsystem</a> </p>
			<p class="top">19 days ago</p>
			<p class="top"><a href="#">@Contrarypopular</a> I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give <a href="#">@accountofsystem</a> </p>
			<p class="top">19 days ago</p>
		</div>
		<div class="span1_of_3">
			<h3>flickr widget</h3>
			<ul class="f_nav">
				<li><a href="#"><img src="images/f_pic1.jpg" alt="" /> </a></li>
				<li><a href="#"><img src="images/f_pic2.jpg" alt="" /> </a></li>
				<li><a href="#"><img src="images/f_pic3.jpg" alt="" /> </a></li>
				<li><a href="#"><img src="images/f_pic4.jpg" alt="" /> </a></li>
				<li><a href="#"><img src="images/f_pic5.jpg" alt="" /> </a></li>
				<li><a href="#"><img src="images/f_pic6.jpg" alt="" /> </a></li>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
</div>
</div>
</div>
<!-- start footer -->
<div class="footer_mid">
<div class="wrap">
<div class="footer">
	<div class="f_search">
		<form>
			<input type="text" value="" placeholder="Enter email for newsletter" />
			<input type="submit" value=""/>
		</form>
	</div>
	<div class="soc_icons">
			<ul>
				<li><a class="icon1" href="#"></a></li>
				<li><a class="icon2" href="#"></a></li>
				<li><a class="icon3" href="#"></a></li>
				<li><a class="icon4" href="#"></a></li>
				<li><a class="icon5" href="#"></a></li>
			</ul>	
	</div>
	<div class="clear"></div>
</div>
</div>
</div>
<!-- start footer -->
<div class="footer_bg">
<div class="wrap">
<div class="footer">
		<!-- scroll_top_btn -->
	    <script type="text/javascript">
			$(document).ready(function() {
			
				var defaults = {
		  			containerID: 'toTop', // fading element id
					containerHoverID: 'toTopHover', // fading element hover id
					scrollSpeed: 1200,
					easingType: 'linear' 
		 		};
				
				
				$().UItoTop({ easingType: 'easeOutQuart' });
				
			});
		</script>
		 <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
		<!--end scroll_top_btn -->
	<div class="f_nav1">
		<ul>
			<li><a href="#">home /</a></li>
			<li><a href="#">support /</a></li>
			<li><a href="#">Terms and conditions /</a></li>
			<li><a href="#">Faqs /</a></li>
			<li><a href="#">Contact us</a></li>
		</ul>
		</div>
	<div class="copy">
		<p class="link"><span>� All rights reserved | Template by&nbsp;<a href="http://w3layouts.com/"> W3Layouts</a></span></p>
	</div>
	<div class="clear"></div>
</div>
</div>
</div>
<%co.close(); %>
</body>
</html>