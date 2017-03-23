<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>e-Commerce Webapp | Price Details</title>
<jsp:include page="fragments/header.jsp" />
</head>
<body>

	<jsp:include page="fragments/navbar.jsp"></jsp:include>

	<div class="container" style="padding-top: 40px;">
		<h3>Price Details</h3>
		<div class="col-md-6 well">
			<c:if test="${not empty product}">
				<table class="table table-striped">
					<tbody>
						<tr>
							<td>Product Code</td>
							<td>${product.code}</td>
						</tr>
						<tr>
							<td>Product Name</td>
							<td>${product.name}</td>
						</tr>
						<tr>
							<td>Description</td>
							<td>${product.description}</td>
						</tr>
						<tr>
							<td>Category</td>
							<td>${product.category}</td>
						</tr>
						<tr>
							<td>Currency</td>
							<td>${product.price.currency}</td>
						</tr>
						<tr>
							<td>Price</td>
							<td>${product.price.price}</td>
						</tr>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty product}">
				<span><b>${message}</b>&nbsp;&nbsp;</span>
			</c:if>
		</div>
	</div>
</body>
</html>