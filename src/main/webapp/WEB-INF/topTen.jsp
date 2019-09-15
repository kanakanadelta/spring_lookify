<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
	body {
		padding: 10px;
		font-family: Comic Sans MS;
	}
	ul {
		display: inline-block;
		padding: 20px;
		border: 2px solid #000;
		list-style: none;
	}
	nav {
		display: flex;
		justify-content: flex-end;
	}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav>
		<a href="/dashboard">Dashboard</a>
	</nav>
	<h1>Top 10 Songs:</h1>
	<ul>
		<c:forEach begin="0" end="10" items="${sortedSongs}" var="song">
			<li>${song.rating} - ${song.title} - ${song.artist }</li>
		</c:forEach>
	</ul>
</body>
</html>