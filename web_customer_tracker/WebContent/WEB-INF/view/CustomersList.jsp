<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.inclined.utility.SortUtilities" %>

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

	<br/>
	<div id="button-primary">
		<input type="button" value="Add New Customer" 
			onClick="window.location.href='addCustomerForm'; return false;" />
	</div>
	
	<br/>
		
	<form:form action="search" method="GET">
		<input type="text" id="searchField" name="searchQuery" placeholder="Type name, email" />
		<input type="submit" id="searchButton" value="Search" class="save"/>
	</form:form>
	
	<br/>
	
	<div class="footer">
		<c:if test="${search}">
			<a href="${pageContext.request.contextPath}/customer/list">Show All</a>
		</c:if>
	</div>	

	<!-- construct a sort link for First name -->
	<c:url var="sortLinkFirstName" value="/customer/list">
		<c:param name="sort" value="<%= Integer.toString(SortUtilities.firstName) %>" />
	</c:url>	

	<!-- construct a sort link for last name -->
	<c:url var="sortLinkLastName" value="/customer/list">
		<c:param name="sort" value="<%= Integer.toString(SortUtilities.lastName) %>" />
	</c:url>					
 
	<!-- construct a sort link for email -->
	<c:url var="sortLinkEmail" value="/customer/list">
		<c:param name="sort" value="<%= Integer.toString(SortUtilities.email) %>" />
	</c:url>	

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th><a href="${sortLinkFirstName}">First Name</a></th>
					<th><a href="${sortLinkLastName}">Last Name</a></th>
					<th><a href="${sortLinkEmail}">Email</a></th>
					<th>Action</th>
				</tr>
				<c:forEach var="customer" items="${customers}">

					<c:url var="updateLink" value="/customer/updateCustomerForm">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>

					<tr>
						<td>${ customer.firstName }</td>
						<td>${ customer.lastName }</td>
						<td>${ customer.email }</td>
						<td><a href="${updateLink}">Update</a>
						  | <a href="${deleteLink}"
						  		onclick="return confirm('Are you sure you want to delete ${customer.firstName} ${customer.lastName}')"
						  	>Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<c:if test="${empty customers}">
			No Customer Found...
			<br />
		</c:if>
	</div>
	
</body>
</html>