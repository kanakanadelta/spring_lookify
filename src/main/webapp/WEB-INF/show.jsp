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
	<table id="songinfo">
		<tbody>
			<tr>
				<td>Title</td>
				<td>${song.title}</td>
			</tr>
			<tr>
				<td>Artist</td>
				<td>${song.artist}</td>
			</tr>
			<tr>
				<td>Rating (1-10)</td>
				<td>${song.rating}</td>
			</tr>
			<tr>
				<td>
					<form action="/songs/${song.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete">
					</form>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>