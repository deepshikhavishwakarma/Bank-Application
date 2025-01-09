<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Customer_Pkg.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bank_App</title>
<link href="style.css" rel="stylesheet">
<style>
    .container {
        text-align: center;
        padding: 40px;
        margin: 50px auto;
        max-width: 500px;
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
        <h1>Welcome to Your BANK</h1>
       
        <div class="container glass">
       
       <% 
       CustBean cb = (CustBean)session.getAttribute("cbean");
       String msg = (String)request.getAttribute("msg");
       /*  String cName = (String)request.getAttribute("alist");*/
       
      
		 %><h2 style="color:orange;"> <% out.println("Welcome "+cb.getCname());%></h2>
        <%--  <jsp:include page="">abc</jsp:include> --%>
           
            <h1>Please Select Option</h1>
          
            <a href="balance">Balance</a>
            <a href="Deposit.jsp">Deposit</a>
            <a href="WithDraw.jsp">Withdraw</a>
            <a href="transfer.jsp">Transfer Money</a>
            <a href="About.jsp">About</a>
            <a href="ChangePass.jsp">Change Password</a>
            <a href="close">Close Account</a>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        &copy; 2024 Your Company. All Rights Reserved.
    </footer>
    
</body>
</html>
