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
	 
	 <div id = "left-head">
	 	<h1>Мои данные</h1>
	 	<p>Имя</p>
	 	<p><c:out value="${user.name}"/></p>
	 	<p>Фамилия</p>
	 	<p><c:out value="${user.surname}"/></p>
	 	<p>Телефон</p>
	 	<p><c:out value="${user.phone}"/></p>
	 	<p>Електронная почта</p>
	 	<p><c:out value="${user.email}"/></p>
	 </div>
	  
	  <div id = "middle-head">
	  	<h1>Административная часть</h1>
	  	<form action = "AddProduct">
	  		<p>
	  			Перейти на страницу добавления нового товара:
	  		</p>
	  		<p>
	  			<button id = "circular-button">Добавить товар</button>>
	  		</p>
	  	</form>
	  	<br>
	  	<br>
	  	<br>
	  	<form action = "UpdateProduct" method = "POST">
	  		<p>
	  			<label for = "name">Изменить поле(поля) товара:</label>
	  		</p>
	  		<p>
	  			<input id = "name" type = "text" name = "name" size = 50 maxlen = 100/>
	  		</p>
	  		<p>
	  			<button type = "submit" id = "circular-button">Продолжить</button>
	  		</p>
	  	</form>
	 	
	 </div>
	 
</body>
</html>