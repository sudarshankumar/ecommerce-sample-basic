<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>e-Commerce Webapp | Browse Products</title>
<jsp:include page="fragments/header.jsp" />
</head>
<body>

	<jsp:include page="fragments/navbar.jsp"></jsp:include>

	<div class="container" style="padding-top: 40px;">
		<h3>Browse Products</h3>
		<div class="col-md-6 well">
			<div align="right">
				<button type="button" class="btn btn-primary"
							onclick="addProduct()">Add Product</button>
			</div>
			<c:if test="${not empty products}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Product Code</th>
							<th>Product Name</th>
							<th>Description</th>
							<th>Category</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<td>${product.code}</td>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td>${product.category}</td>
								<td><button type="button" class="btn btn-info" onclick="showPrice('${product.code}')">View Price</button></td>
								<td><button type="button" class="btn btn-danger" onclick="deleteProduct('${product.code}')">Delete</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<c:if test="${empty products}">
				<span><b>${message}</b>&nbsp;&nbsp;</span>
			</c:if>
		</div>
	</div>
</body>
<script type="text/javascript">
	function addProduct() {
		window.location.href = "/newProduct";
	}
	function deleteProduct(productCode){
		window.location.href="/removeProduct?productCode="+productCode;
	}
	
	function showPrice(productCode){
		window.location.href="/viewProductDetails?productCode="+productCode;
	}
</script>
</html>