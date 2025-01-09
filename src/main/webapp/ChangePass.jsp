<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Customer_Pkg.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bank_App</title>
<link href="style.css" rel="stylesheet">
<style>

/* Form Container */
.container {
	text-align: center;
	padding: 40px;
	margin: 50px auto;
	max-width: 400px;
}

</style>
</head>
<body>
	<!-- Navigation Bar -->
	<nav>
		<div>
			<a href="Dashboard.jsp">Home</a> <a href="About.jsp">About</a> <a href="close">Logout</a>
		</div>
	</nav>

	<!-- Main Content -->
	<div class="main">
		<h1 style="text-align: center;">Welcome to Your BANK</h1>

		<div class="container glass">
			<h2>Change Password</h2>
			<form action="changepass" method="get">
				<%
				CustBean cb1 = (CustBean) session.getAttribute("cbean");
				String msg = (String) request.getAttribute("msg");
				String msg1 = (String) request.getAttribute("msg1");
				
				int captcha = new Random().nextInt(1000, 9999);
				session.setAttribute("captcha", captcha);
				%>
				<h2 style="color: orange;">
					<%=msg != null ? msg : ""%></h2>
					<%=msg1 != null ? msg1 : ""%></h2>

				<label for="oPass">Enter old Password </label> <input type="text"
					name="oPass" placeholder="Enter Your Old Password " required>
				<label for="nPass">Enter new Password</label> <input type="text"
					name="nPass" placeholder="Enter New Password " required>
				<h2 style="color: orange;">
					<%= captcha %>
				</h2>
				<input type="text" name="enteredcaptcha" placeholder="Enter Captcha"
					required> <input type="submit" value="Enter>>">
			</form>
			<a href="Dashboard.jsp">Go To Dashboard</a>
		</div>
	</div>

	<!-- Footer -->
	<footer> &copy; 2024 Your Company. All Rights Reserved. </footer>

</body>
</html>
