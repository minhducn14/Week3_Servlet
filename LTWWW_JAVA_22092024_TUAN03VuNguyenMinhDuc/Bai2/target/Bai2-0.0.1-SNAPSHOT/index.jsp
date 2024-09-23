<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Registration Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.registration-form {
	background: #ffffff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
}

.registration-form h2 {
	text-align: center;
	margin-bottom: 20px;
}

.form-group {
	display: flex;
	flex-direction: column;
	margin-bottom: 15px;
}

.form-group input, .form-group select {
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 14px;
	width: 100%;
	box-sizing: border-box;
}

.form-group label {
	margin-bottom: 5px;
	font-weight: bold;
}

.birthday-group {
	display: flex;
	justify-content: space-between;
}

.birthday-group select {
	width: 32%;
}

.gender-group {
	display: flex;
	justify-content: space-between;
}

.gender-group input {
	margin-right: 5px;
}

button {
	background-color: #007bff;
	color: #ffffff;
	border: none;
	padding: 10px;
	border-radius: 4px;
	width: 100%;
	font-size: 16px;
	cursor: pointer;
}

button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="registration-form">
		<h2>User Registration Form</h2>
		<form action="UserController" name="formSignUp" method="post">
			<div class="form-group">
				<input type="text" placeholder="First Name" name="firstName"
					required> <input type="text" placeholder="Last Name"
					name="lastName" required>
			</div>
			<div class="form-group">
				<input type="email" placeholder="Your Email" name="email" required>
				<input type="email" placeholder="Re-enter Email" name="reEmail"
					required>
			</div>
			<div class="form-group">
				<input type="password" placeholder="New Password" name="password"
					required>
			</div>
			<div class="form-group">
				<label>Birthday</label>
				<div class="birthday-group">
					<select name="month">
						<option value="">Month:</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select> <select name="day">
						<option value="">Day:</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						<option value="24">24</option>
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>

					</select> <select name="year">
						<option value="">Year:</option>
						<option value="1990">1990</option>
						<option value="1991">1991</option>
						<option value="1992">1992</option>
						<option value="1993">1993</option>
						<option value="1994">1994</option>
						<option value="1995">1995</option>
						<option value="1996">1996</option>
						<option value="1997">1997</option>
						<option value="1998">1998</option>
						<option value="1999">1999</option>
						<option value="2000">2000</option>
						<option value="2001">2001</option>
						<option value="2002">2002</option>
						<option value="2003">2003</option>
						<option value="2004">2004</option>
						<option value="2005">2005</option>
						<option value="2006">2006</option>
						<option value="2007">2007</option>
						<option value="2008">2008</option>
						<option value="2009">2009</option>
						<option value="2010">2010</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label>Gender</label>
				<div class="gender-group">
					<input type="radio" name="gender" value="female"> Female <input
						type="radio" name="gender" value="male"> Male
				</div>
			</div>
			<input type="submit" value="Sign Up">
		</form>
	</div>
</body>
</html>
