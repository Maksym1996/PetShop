<%@ page contentType="text/html;charset=utf-8" import = "maksym.db.entity.UserRole" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
<META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="uk-UK">
<META NAME="DESCRIPTION" CONTENT="Онлайн-магазин для домашніх тварин">
<META NAME="KEYWORDS"
	CONTENT="Онлайн-магазин, товар, домашние, животные, собака, кот, кошка, рыба, кролик, попугай, хомяк, крыса, шиншила">
<LINK rel="stylesheet" href="styles.css">
<LINK rel="stylesheet" href="reset.css">
<title>Каталог товаров</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div align="center">
		<font size+=10><b> Каталог товаров</b></font>
	</div>
	          <c:if test = "${role == 1 and not empty role}">
    					<form action="AddProduct">
    						<button type="submit" id="circular-button">Добавить товар</button>
    					</form>
    		  </c:if>
	<table>
		<tr>
		  <c:forEach var="prod" items="${products}">
            <td>
					<figure class="sign">
						<img src=<c:out value="${prod.photo_link}"/> height="150"
							width="150">
					</figure>
					<br>

						<c:out value="${prod.name}" />
						,
						<c:out value="${prod.weight}" />
						gr.

					<br>
					<form action="AboutProduct" method="GET">
						<input type="hidden" name="id" value=<c:out value = "${prod.id}"/>>
						<font size=+2 color=green> <c:out value="${prod.price}" />
							UAH
						</font>
						<button type="submit" id="circular-button">Сведения о
							товаре</button>
					</form>
					<c:if test = "${not empty role and role eq 1}">
					    <form action="EditProduct" method="GET">
						<input type="hidden" name="id" value=<c:out value = "${prod.id}"/>>
						<button type="submit" id="circular-button">Изменить товар</button>
					</form>
					</c:if>

                </td>
			</c:forEach>

		</tr>
	</table>

</body>
</html>