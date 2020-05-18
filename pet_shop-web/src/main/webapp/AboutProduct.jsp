<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
       <META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
        <META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="uk-UK">
              	<META NAME="DESCRIPTION" CONTENT="Онлайн-магазин для домашніх тварин">
              	<META NAME="KEYWORDS" CONTENT="Онлайн-магазин, товар, домашние, животные, собака, кот, кошка, рыба, кролик, попугай, хомяк, крыса, шиншила">
              	<LINK rel="stylesheet" href="styles.css">
              	<LINK rel="stylesheet" href="reset.css">
        <title>Про товаре</title>
    </head>
	<body>
		
		  <jsp:include page="header.jsp" />
		  <h1 align="center"> <c:out value = "${prod.name}"/> </h1>
		  <table border=0>
		  	<tr>
		  		<td>
		  			<figure class="sign">
		  				<img src= prod.getPhoto_link() height = "300" width ="200">
		  			</figure>
		  		</td>
		  		<td>
		  			<h3>Информация о товаре</h3>
		  			<table>
		  				<tr>
		  					<td>Вес</td>
		  					<td><p align="right"> <c:out value = "${prod.weight}" /> </p></td>
		  				</tr>
		  				<tr>
		  					<td>Возраст</td>
		  					<td><p align="right"> <c:out value = "${prod.age}"/> </p></td>
		  				</tr>
		  				<tr>
		  					<td>Изготовитель</td>
		  					<td><p align="right"> <c:out value = "${prod.producer}"/> </p></td>
		  				</tr>
		  				<tr>
		  					<td>Вид корма</td>
		  					<td><p align="right"> <c:out value = "${type}"/> </p></td>
		  				</tr>
		  				<tr>
		  					<td>Порода</td>
		  					<td><p align="right"> <c:out value = "${breed}"/> </p></td>
		  				</tr>
		  			</table>
		  			<br>
		  			<form action="back" method = "GET" >
		  				<input type = "hidden" name = "id" value = <c:out value = "${prod.id}"/> >
		  				<button type="submit" id = "circular-button">Добавить в корзину</button>
		  		</td>
		  	</tr>
		  </table>
		  <br>
		  <br>
		  <br>
		  <h3 align="left">Описание товара</h3>
		  <p> <c:out value = "${prod.description}"/></p>

</body>
</html>
