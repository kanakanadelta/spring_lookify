<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="navbar">
		<span>Songs by artist: ${query}</span>
		<form action="/search" method="GET">
			<input type="text" name="query" placeholder="${query}"/>
			<input type="submit" value="Search"/>
		</form>
		<a href="/dashboard">Dashboard</a>
	</div>
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
				<c:forEach items="${queryResults}" var="song">
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