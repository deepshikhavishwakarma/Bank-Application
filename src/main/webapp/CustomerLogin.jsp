<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bank_App</title>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

/* Body Styling */
body {
	display: flex;
	flex-direction: column;
	min-height: 100vh;
	background: linear-gradient(to right, rgba(0, 0, 0, 0.8),
		rgba(0, 0, 0, 0.9)),
		url('https://th.bing.com/th/id/OIP.tgyNDr4LvB67hOStUOdbiAHaEr?w=1125&h=710&rs=1&pid=ImgDetMain');
	background-size: cover;
	background-position: center;
	color: #fff;
}

/* Glassmorphic Effect */
.glass {
	background: rgba(255, 255, 255, 0.1);
	backdrop-filter: blur(10px);
	-webkit-backdrop-filter: blur(10px);
	border: 1px solid rgba(255, 255, 255, 0.18);
	border-radius: 10px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
}

/* Footer */
footer {
	text-align: center;
	padding: 10px 20px;
	margin-top: auto;
	font-size: 0.9rem;
}

/* Form Container */
.container {
	text-align: center;
	padding: 40px;
	margin: 50px auto;
	max-width: 400px;
}

form {
	display: flex;
	flex-direction: column;
}

input[type="text"], input[type="password"] {
	padding: 10px;
	margin: 10px 0;
	border: none;
	border-radius: 8px;
/* 	background: rgba(255, 255, 255, 0.1); */
	color: #fff;
	outline: none;
}

input[type="text"]::placeholder, input[type="password"]::placeholder {
	color: rgba(255, 255, 255, 0.7);
}
 
input[type="submit"] {
	padding: 12px;
	background: rgba(255, 255, 255, 0.1);
	color: #fff;
	border: 1px solid rgba(255, 255, 255, 0.2);
	border-radius: 8px;
	font-size: 1.1rem;
	cursor: pointer;
	transition: all 0.3s ease;
}

label {
	/*  padding: 2px;*/
	font-style: san-sarif, monospace;
	font-size: 1rem;
	margin: 0px 2px 2px 0px;
	justify-content : start;
}

input[type="submit"]:hover {
	background: rgba(255, 255, 255, 0.2);
	border-color: rgba(255, 255, 255, 0.5);
}

h1 {
	margin-bottom: 20px;
	font-size: 2rem;
	color:orange;
}

.main h1 {
	margin: 30px;
}

.container a {
	display: block;
	margin: 10px 0;
	padding: 15px 20px;
	text-decoration: none;
	color: #fff;
	background: rgba(0, 0, 0, 0.7);
	border: 1px solid rgba(255, 255, 255, 0.2);
	border-radius: 5px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.3);
	transition: all 0.3s;
}

.container a:hover {
	background: rgba(255, 255, 255, 0.2);
	color: orange;
	border-color: #fff;
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
			<%
			String msg = (String) request.getAttribute("msg");
			%><h2 style="color: orange;">
				<%=msg != null ? msg : ""%></h2>

			<h1>Customer Login</h1>
			<form action="login" method="post">
				<label for="accNo">Enter Account Number :</label> <input type="text"
					name="accNo" placeholder="Customer Account Number "> 
					<label for="pword">Enter Password</label><input
					type="password" name="pword" placeholder="Password"> <input
					type="submit" value="Login">

			</form>
			<a href="Register.html">Don't have an account?<br>Register
				here
			</a>
		</div>
	</div>


	<!-- Footer -->
	<footer> &copy; 2024 Your Company. All Rights Reserved. </footer>
</body>
</html>




