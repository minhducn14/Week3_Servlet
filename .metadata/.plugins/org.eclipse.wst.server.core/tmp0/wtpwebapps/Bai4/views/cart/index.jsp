<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
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

.cart-table {
	width: 100%;
	border-collapse: collapse;
	margin-bottom: 20px;
}

.cart-table th, .cart-table td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

.cart-table th {
	background-color: #f4f4f4;
}

.cart-table img {
	width: 50px;
	height: auto;
}

.total-row {
	font-weight: bold;
}

.actions {
	text-align: center;
	margin-top: 20px;
}

.actions button {
	padding: 10px 15px;
	background-color: #28a745;
	color: #fff;
	border: none;
	cursor: pointer;
	border-radius: 5px;
	margin: 5px;
}

.actions button:hover {
	background-color: #218838;
}

.empty-cart {
	text-align: center;
	font-size: 18px;
	margin: 20px 0;
	color: #666;
}

.remove-link {
	color: #dc3545;
	cursor: pointer;
}

.remove-link:hover {
	text-decoration: underline;
}
</style>
<script>
	function updateCart(productId) {
	    var quantityInput = document.getElementById("quantity_" + productId);
	    var quantity = quantityInput.value;
	    console.log("Updated quantity: " + quantity); 
	    var form = document.getElementById("update-" + productId);
	    form.quantity.value = quantity; 
	    form.submit(); 
	}
</script>
</head>
<body>
	<div class="container">
		<h2>Shopping Cart</h2>
		<c:if test="${not empty cart}">
			<c:set var="total" value="0" />

			<table class="cart-table">
				<thead>
					<tr>
						<th>Image</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${cart}">
						<tr>
							<td><img
								src="${pageContext.request.contextPath}/resources/images/${item.product.image}"
								alt="${item.product.name}"></td>
							<td>${item.product.name}</td>
							<td>${item.product.price}</td>
							<td>
								<form id="update-${item.product.id}"
									action="${pageContext.request.contextPath}/cart" method="post">
									<input type="hidden" name="action" value="update"> <input
										type="hidden" name="productId" value="${item.product.id}">
									<input type="number" id="quantity_${item.product.id}"
										name="quantity" value="${item.quantity}" min="1"
										onchange="updateCart(${item.product.id})">
								</form>

							</td>
							<td><fmt:formatNumber
									value="${item.product.price * item.quantity}" type="number"
									maxFractionDigits="2" /></td>
							<td><a
								href="${pageContext.request.contextPath}/cart?action=remove&id=${item.product.id}"
								onclick="return confirm('Are you sure?')">Remove</a></td>
						</tr>
						<c:set var="total"
							value="${total + (item.product.price * item.quantity)}" />
					</c:forEach>
					<tr class="total-row">
						<td colspan="4">Total</td>
						<td><fmt:formatNumber value="${total}" type="number"
								maxFractionDigits="2" /></td>
						<td></td>
					</tr>
				</tbody>
			</table>

			<div class="actions">
				<form action="${pageContext.request.contextPath}/cart" method="post">
					<input type="hidden" name="action" value="clear">
					<button type="submit">Clear Cart</button>
				</form>
				<a href="${pageContext.request.contextPath}/product">
					<button type="button">Continue shopping</button>
				</a>
			</div>
		</c:if>

		<c:if test="${empty cart}">
			<p class="empty-cart">
				Your cart is empty. <a
					href="${pageContext.request.contextPath}/product">Continue
					shopping</a>.
			</p>
		</c:if>
	</div>
</body>
</html>
