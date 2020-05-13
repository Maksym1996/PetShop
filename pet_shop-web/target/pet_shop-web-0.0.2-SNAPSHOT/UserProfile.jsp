<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<LINK rel="stylesheet" href="styles.css">
	<LINK rel="stylesheet" href="reset.css">
	<title>Мой профиль</title>
</head>
<body>
	 <jsp:include page="header.jsp" />
	 <h1>Мои данные</h1>
	 <div>
	 	<p>Имя</p>
	 	<p><c:out value="${user.name}"/></p>
	 	<p>Фамилия</p>
	 	<p><c:out value="${user.surname}"/></p>
	 	<p>Телефон</p>
	 	<p><c:out value="${user.phone}"/></p>
	 	<p>Електронная почта</p>
	 	<p><c:out value="${user.email}"/></p>
	 	<form action = "MainPage.jsp">
	 		<button type = "submit" id = "circular-button">На главную</button>
	 	</form>
	 </div>
	 
</body>
</html>