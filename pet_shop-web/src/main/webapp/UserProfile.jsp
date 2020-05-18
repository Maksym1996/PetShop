

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<LINK rel="stylesheet" href="styles.css">
	<LINK rel="stylesheet" href="reset.css">
	<styles>
	    h1{
	        font-size:30px;
	    }
	</styles>
	<title>Мой профиль</title>
</head>
<body>
	 <jsp:include page="header.jsp" />
	 <h1 align= "center">Мои данные</h1>
	 <br>
	 <div>
	 	<p>Имя</p>
	 	<br>
	 	<p><c:out value="${user.name}"/></p>
	 	<br>
	 	<p>Фамилия</p>
	 	<br>
	 	<p><c:out value="${user.surname}"/></p>
	 	<br>
	 	<p>Телефон</p>
	 	<br>
	 	<p><c:out value="${user.phone}"/></p>
	 	<br>
	 	<p>Електронная почта</p>
	 	<br>
	 	<p><c:out value="${user.email}"/></p>
	 	<br>
	 	<br>
	 	<form action = "/pet_shop-web/">
	 		<button type = "submit" id = "circular-button">На главную</button>
	 	</form>
	 </div>
	 
</body>
</html>