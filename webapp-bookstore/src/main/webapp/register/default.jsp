<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="../css/style.css" />
		<link href='http://fonts.googleapis.com/css?family=Josefin+Sans' rel='stylesheet'/>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' />
	</head>
	
	<body>
		<h1>Register New Account</h1>
		<form action="confirm.do" method="post">
			<table>
				<tr>
					<th>E-mail</th>
					<td><input type="text" name="email" value="${formBean.email}" required ${formBean.readOnly} /></td>
				</tr>
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" value="${formBean.name}" required ${formBean.readOnly} /></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password1" value="${formBean.password1}" required ${formBean.readOnly} /></td>
				</tr>
				<tr>
					<th>Password (Re-type)</th>
					<td><input type="password" name="password2" value="${formBean.password2}" required ${formBean.readOnly} /></td>
				</tr>
				<tr>
					<td colspan="2" class="button">
						<c:choose>
							<c:when test="${formBean.confirmed}">
								<input type="button" value="Back" onClick="history.back(); return false;"/>
							</c:when>
							<c:otherwise>
								<a href="../" class="josefin-sans">Go back to Login</a>
								<input type="reset" value="Reset" />
							</c:otherwise>
						</c:choose>
						<input type="submit" value="<c:out value='${formBean.buttonCaption}' default='Confirm' />" />
					</td>
				</tr>
			</table>
			
			<ul class="error">
				<c:forEach var="message" items="${messages}">
					<li>${message}</li>
				</c:forEach>
			</ul>
			
			<input type="hidden" name="confirmed" value="${formBean.confirmed}" />
			
		</form>
	</body>
</html>