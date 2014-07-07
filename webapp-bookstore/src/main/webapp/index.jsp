<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Top page</title>
		<link rel="stylesheet" href="css/style.css" />
		<link href='http://fonts.googleapis.com/css?family=Josefin+Sans' rel='stylesheet'/>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' />
	</head>
	
	<body>
		<h1>Book Store</h1>
		<h2>Please Login!</h2>
		<form action="login.do" method="post">
			<table>
				<tr>
					<th>E-Mail</th>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td colspan="2" class="button"><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</form>
		<p class="error">${message}</p>
		<a href="register/">Register New Account</a>
	</body>
</html>