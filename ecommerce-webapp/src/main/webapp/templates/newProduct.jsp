<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>e-Commerce Webapp | Add Product</title>
<jsp:include page="fragments/header.jsp" />
</head>
<body>

	<jsp:include page="fragments/navbar.jsp"></jsp:include>

	<div class="container" style="padding-top: 40px;">
		<h3>Add Product</h3>
		<form:form action="/saveProduct" method="post" commandName="product">
			<div class="form-group">
			    <label for="inputsm">Product Code</label>
			    <spring:bind path="product.code">
			    	<input class="form-control input-sm" name="code" type="text" required="required" />
			    </spring:bind>
			</div>
			<div class="form-group">
			    <label for="inputsm">Product Name</label>
			    <spring:bind path="product.name">
			    	<input class="form-control input-sm" name="name" type="text" required="required" />
			    </spring:bind>
			</div>
			<div class="form-group">
			    <label for="inputsm">Product Description</label>
			    <spring:bind path="product.description">
			    	<textarea class="form-control input-sm" name="description" ></textarea>
			    </spring:bind>
			</div>
			<div class="form-group">
			    <label for="inputsm">Product Category</label>
			    <spring:bind path="product.category">
				    <select class="form-control input-sm" name="category">
				        <option>ELECTRONICS</option>
				        <option>HOME_APPLIANCES</option>
				        <option>LIFESTYLE</option>
				    </select>
				 </spring:bind>
			</div>
			<div class="form-group">
			    <label for="inputsm">Price</label>
			    <spring:bind path="price.price">
			    	<form:input type="number" class="form-control input-sm" path="price.price" required="required" />
			    </spring:bind>
			</div>
			
			<div class="form-group">
			    <label for="inputsm">Product Category</label>
			    <spring:bind path="price.currency">
				    <form:select class="form-control input-sm" name="currency" path="price.currency">
				        <option>INR</option>
				        <option>USD</option>
				        <option>EURO</option>
				    </form:select>
			    </spring:bind>
			</div>
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>