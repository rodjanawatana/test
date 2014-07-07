<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%@ taglib uri="/WEB-INF/html-tags.tld" prefix="h" %>

<sql:setDataSource var="ds" dataSource="jdbc/mysql" />

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Book List</title>
		<link rel="stylesheet" href="../css/style.css" />
		<link href='http://fonts.googleapis.com/css?family=Josefin+Sans' rel='stylesheet'/>
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' />
	</head>
	
	<body>
		
		<div id="user-info">
			Login User: ${userAccount.name} / <a href="logout.do">Logout</a>
		</div>
		
		<h1>Book List</h1>
	
		<form action="search.do" method="post" class="search-box">
			ISBN: <input type="text" name="isbn" /> 
			TITLE: <input type="text" name="title" />
			PUBLISHER: <h:dropdown ds="${ds}" tbl="publisher" key="code" value="name" />
			<input type="submit" value="Search" />
		</form>
	
		<table id="book-list">
			<tr>
				<th>TITLE</th>
				<th>PUBLISHER</th>
				<th>AUTHORS</th>
			</tr>
		
			<c:forEach var="book" items="${bookList}">
				
				<c:set var="authors" value="${book.authors}" />
			
				<tr>
					<td>
						<img src="../images/${book.isbn}.gif" />
						${book.isbn}<br />
						<span class="book-title">${book.title}</span><br />
						$${book.price}<br />
						${book.releaseDate}						
					</td>
					<td>${book.publisher.name}</td>
					<td>
						<c:forEach var="author" items="${authors}">
							${author.name} <br />
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>