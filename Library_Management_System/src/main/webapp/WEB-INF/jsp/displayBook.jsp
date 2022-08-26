<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<h1>Welcome to Java Training School Library</h1><br>
	<div> ${msg}  </div><br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Price</th>
			<th>Status</th>
			<th>Borrow</th>
		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.author}</td>
				<td>${book.price}</td>
				<td>${book.status}</td>
				<c:if test="${book.status == 'available'}">  
   					<td><a href="borrowForm/${book.id}">Borrow</a></td>  
				</c:if> 
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="addBookForm">Add a Book</a>
</body>
</html>