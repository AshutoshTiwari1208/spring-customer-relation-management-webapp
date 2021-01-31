<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Form</title>

<!-- Resources Import -->
<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
			
<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Customer Relationship Management</h2>
		</div>
	</div>
	
	<div id="container">
		<form:form action="saveForm" method="POST" modelAttribute="customer">
			<table>
			<tbody>
				<tr>
					<td><label for="first_name">First Name: </label></td>
					<td><form:input type="text" path="firstName" /></td>
				</tr>
				<tr>
					<td><label for="first_name">Last Name: </label></td>
					<td><form:input type="text" path="lastName" /></td>
				</tr>	
				<tr>
					<td><label for="first_name">Email: </label></td>
					<td><form:input type="text" path="email" /></td>
				</tr>					
			</tbody>
			</table>
				<input type="submit" value="Submit" class="save"/>
		</form:form>
		
		<br/><br/>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Go back to Home</a>
		</p>
	</div>
	

</body>
</html>