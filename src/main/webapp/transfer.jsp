<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="Customer_Pkg.*"%>
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

nav {
	display: flex;
	justify-content: space-around;
	align-items: center;
	padding: 15px 20px;
	background: rgba(0, 0, 0, 0.8);
	border-bottom: 1px solid rgba(255, 255, 255, 0.2);
}

nav a {
	text-decoration: none;
	color: #fff;
	padding: 10px 20px;
	border-radius: 5px;
	transition: background-color 0.3s;
}

nav a:hover {
	background-color: rgba(255, 255, 255, 0.2);
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
	background: rgba(255, 255, 255, 0.1);
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
	margin-top: 5px;
}

label {
	padding: 2px;
	font-style: san-sarif, monospace;
	font-size: 1rem;
	margin: 0px 2px;
}

input[type="submit"]:hover {
	background: rgba(255, 255, 255, 0.2);
	border-color: rgba(255, 255, 255, 0.5);
}

h1 {
	margin-bottom: 20px;
	font-size: 2rem;
	scolor: #cc3300;
}

h2 {
	margin: 5px;
	padding: 2px;
	color: #cc9900;
}

h3 {
	margin-top: 2rem;
	padding: 2px;
	color: #ff9933
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
	color: #000;
	border-color: #fff;
}
</style>
</head>
<body>

	<!-- Navigation Bar -->
	<nav>
		<div>
			<a href="Dashboard.jsp">Home</a> <a href="About.jsp">About</a> <a
				href="close">Logout</a>
		</div>
	</nav>

	<!-- Main Content -->
	<div class="main">
		<h1 style="text-align: center;">Welcome to Your BANK</h1>

		<div class="container glass">
			<h2>Fund Transfer</h2>
			<%
			CustBean cb1 = (CustBean) session.getAttribute("cbean");
			String msg = (String) request.getAttribute("msg");
			%>


			<form action="transfer" method="get">
				<h2 style="color: orange;">
					<%=msg != null ? msg : ""%></h2>
				<label for="accNo">Enter Account No </label> <input type="text"
					name="accNo" placeholder="Enter Your Account Number " required>
				<label for="sAccNo">Sender Account No </label> <input type="text"
					name="sAccNo" placeholder="Enter Sender Account Number " required><label
					for="amt">Enter Amount</label> <input type="text" name="amt"
					placeholder="Enter Amount "> <input type="submit"
					value="Enter>>">
			</form>
			<a href="Dashboard.jsp">Go To Dashboard</a>
		</div>
	</div>




	<!-- Footer -->
	<footer> &copy; 2024 Your Company. All Rights Reserved. </footer>
</body>
</html>










<%-- <%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fund Transfer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 400px;
            text-align: center;
        }

        .container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .input-group {
            margin-bottom: 15px;
            text-align: left;
        }

        .input-group label {
            font-weight: bold;
            color: #555;
            display: block;
            margin-bottom: 5px;
        }

        .input-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 2px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        .input-group input:focus {
            border-color: #007bff;
            outline: none;
        }

        .submit-btn {
            background-color: #28a745;
            color: white;
            font-size: 18px;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .submit-btn:hover {
            background-color: #218838;
        }

        .submit-btn:active {
            background-color: #1e7e34;
        }

        .error {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>Fund Transfer</h2>
        <form action="transfer" method="post">
            
            <div class="input-group">
                <label for="senderAccno">Sender Account No:</label>
                <input type="text" id="senderAccno" name="senderAccno" required>
            </div>

            <div class="input-group">
                <label for="receiverAccno">Receiver Account No:</label>
                <input type="text" id="receiverAccno" name="receiverAccno" required>
            </div>

            <div class="input-group">
                <label for="amount">Amount:</label>
                <input type="number" id="amount" name="amount" required>
            </div>

            <button type="submit" class="submit-btn">Submit</button>
        </form>
    </div>

</body>
</html>
 --%>