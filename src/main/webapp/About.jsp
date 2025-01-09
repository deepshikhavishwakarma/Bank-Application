

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
.container {
	text-align: center;
	padding: 40px;
	margin: 50px auto;
	max-width: 1180px;
}

.container a{
 width:20%;
 justify-content:center;
 align-item:center;
 text-align:center;
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

			<h2>Our Mission</h2>
			<section>
				<p>We aim to provide reliable, accessible, and innovative
					banking solutions that empower our customers to achieve their
					financial goals. Our mission is to create a seamless and secure
					banking experience by leveraging the latest technology, fostering
					long-term relationships, and prioritizing customer satisfaction. We
					are committed to promoting financial literacy and inclusion,
					ensuring that everyone has the tools and opportunities to build a
					prosperous future.</p>

				<hr style="height: 2px">
			</section>
			<h2>Our Core Values</h2>
			<section>

				<div class="values">
					<div class="value">
						<h3>Integrity</h3>
						<p>Ensuring trust in every transaction.</p>
					</div>
					<div class="value">
						<h3>Innovation</h3>
						<p>Staying ahead with cutting-edge technology.</p>
					</div>
					<div class="value">
						<h3>Customer Focus</h3>
						<p>Listening and responding to your needs.</p>
					</div>
				</div>
			</section>
			<h2>Our Journey</h2>
			<section style>

				<p>Founded in 2000, our bank has achieved remarkable milestones,
					including launching mobile banking, achieving customer excellence
					awards, and expanding to serve millions globally.</p>

			</section>
			<h2>What We Offer</h2>
			<section>

				<ul class="styled-list">
					<li>Savings & Checking Accounts</li>
					<li>Loans & Mortgages</li>
					<li>Investment & Wealth Management</li>
					<li>Online & Mobile Banking</li>
				</ul>
			</section>
			<h2>Join Us Today</h2>
			<section>

				<p>Be a part of our journey. Open an account with us or contact
					our support team to learn more.</p>
			
			</section>
			 <a href="Dashboard.jsp">Go To Dashboard</a>
		</div>


	</div>

	<%--  <%@include file="Dashboard.jsp" %> --%>



	<!-- Footer -->
	<footer> &copy; 2024 Your Company. All Rights Reserved. </footer>
</body>
</html>






