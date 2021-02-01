<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Customers</title>

<!--  references CSS file -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer [Relationship] Management</h2>
		</div>
	</div>

	<div id="button-primary">
		<input type="button" value="Add New Customer"
			onClick="window.location.href='addCustomerForm'; return false;" />
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers}">

					<c:url var="updateLink" value="/customer/updateCustomerForm">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>

					<tr>
						<td>${ customer.firstName }</td>
						<td>${ customer.lastName }</td>
						<td>${ customer.email }</td>
						<td><a href="${updateLink}">Update</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>