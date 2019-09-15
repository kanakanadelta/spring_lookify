<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="style.css" />
<title>Lookify</title>
</head>
<body>
	<!-- 1. NAVBAR -->
	<div id="navbar">
		<a href="/songs/new">Add New</a>
		<a href="/search/topTen">Top Ten</a>
		<form:form action="/search" method="post" modelAttribute="song">
			<span>
				<form:input id="searchbar" path="title" />
				<input type="submit" value="Submit"/>
			</span>
		</form:form>
	</div>
	
	<!-- 2. SONG LIST -->
	<div id="songtable">
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>rating</th>
					<th>actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td>
							<a href="/songs/${song.id}">
								<c:out value="${song.title}" />
							</a>
						</td>
						<td>
							<c:out value="${song.rating}" />
						</td>
						<td>
							<form action="/songs/${song.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Delete">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>