
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Product List</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.container {
	width: 80%;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
}

.product-grid {
	display: flex;
	flex-wrap: wrap;
	gap: 20px;
	justify-content: center;
}

.product {
	border: 1px solid #ccc;
	padding: 10px;
	width: 200px;
	text-align: center;
	background-color: #f9f9f9;
}

.product img {
	max-width: 100%;
	height: auto;
}

.product h3 {
	font-size: 18px;
	margin: 10px 0;
}

.product p {
	font-size: 16px;
	color: #333;
	margin: 10px 0;
}

.product input[type="number"] {
	width: 50px;
	text-align: center;
	margin-bottom: 10px;
}

.product button {
	padding: 10px 15px;
	background-color: #28a745;
	color: #fff;
	border: none;
	cursor: pointer;
	border-radius: 5px;
}

.product button:hover {
	background-color: #218838;
}

.view-cart {
	text-align: right;
	margin-bottom: 20px;
}

.view-cart a {
	text-decoration: none;
	color: #007bff;
	font-size: 18px;
}

.view-cart a:hover {
	text-decoration: underline;
}
</style>
<script>
	function addToCart(productId) {
	    var quantityInput = document.getElementById("quantity_" + productId);
	    var quantity = quantityInput.value;
	    var url = "${pageContext.request.contextPath}/cart?action=buy&id=" + productId + "&number=" + quantity;
	    window.location.href = url;
	}
	</script>
</head>
<body>
	<div class="container">
		<div class="view-cart">

			<a href="${pageContext.request.contextPath}/cart">View Cart</a>
		</div>
		<h2>Product List</h2>
		<div class="product-grid">
			<c:forEach var="product" items="${products}">
				<div class="product">
					<h3>${product.name}</h3>
					<img
						src="${pageContext.request.contextPath}/resources/images/${product.image}"
						alt="${product.name}">
					<p>Price: ${product.price}</p>
					<input type="number" id="quantity_${product.id}" value="1" min="1">
					<button onclick="addToCart(${product.id})">Add To Cart</button>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>