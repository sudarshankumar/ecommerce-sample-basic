<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1" />
<title>e-Commerce Webapp | Search Product</title>
<jsp:include page="fragments/header.jsp" />
</head>
<body>

	<jsp:include page="fragments/navbar.jsp"></jsp:include>

	<div class="container" style="padding-top:40px;">
		<h3>Product Search</h3>
		<form action="/searchProduct" method="get">
			<fieldset>
			    <span>Product Category</span>
			    <select class="form-control input-sm" name="category">
			        <option>ELECTRONICS</option>
			        <option>HOME_APPLIANCES</option>
			        <option>LIFESTYLE</option>
			    </select>
			</fieldset>
			<input type="submit" value="Search">
		</form>		
	</div>
</body>
</html>