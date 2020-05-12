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
        <title>Каталог товаров</title>
    </head>
	<body>
		
		  <jsp:include page="header.jsp" />
		  <div align = "center">
		  	<font size+=10><b>  Каталог товаров</b></font></div>
		  	<table>
		  		<tr>
		  			<td>
		  			<c:forEach var="prod" items="${products}">
		  				<figure class="sign">
		  					<img src=<c:out value="${prod.photo_link}"/> height="150" width="150"> </figure>
                    	<br>
                    	<p> <c:out value="${prod.name}"/> , <c:out value="${prod.weight}"/> gr.</p>
                    	<p>	<form action="AboutProduct" method="GET">
                    		<input type = "hidden" name = "id" value = p.getId()>
                    		<font size=+2 color=green> <c:out value="${prod.price}"/> UAH</font>
                    		<button type="submit" id = "circular-button">Сведения о товаре</button>></form>
                    	</p>
                    	</c:forEach>>
                    </td>
	</body>
</html>