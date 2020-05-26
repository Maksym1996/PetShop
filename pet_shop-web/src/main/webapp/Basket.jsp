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
              	<style>
              	    b{
              	    font-size: 40px;
              	    }

              	</style>
        <title>Моя корзина</title>
    </head>
    <body>
    
       <jsp:include page="header.jsp" />
       
       <div align="center"><b>Выбранный вами товар:</b></div>
       <table>
        <c:forEach var="prod" items="${basket.products}">
            <tr>

                    <td>
                        <figure class="sign">
                        <img src=<c:out value="${prod.photo_link}"/> height="150" width="150"> </figure>
                        <br>
                        <p> <c:out value="${prod.name}"/> , <c:out value="${prod.weight}"/> гр.</p>
                        <p> <font size=+2 color=green>  <c:out value="${prod.price}"/> ГРН</font></p>
                        <form action="basket" method = "GET" >
                        	<input type = "hidden" name = "id" id = "id" value = <c:out value = "${prod.id}"/> />
                            <button type="submit" id = "circular-button">Удалить из корзины</button>
                        </form>
                    </td>

                    <td>
                        <div>
                        <form action = "BuyOneProduct">
                          <input type = "hidden" name = "id" id = "id" value = <c:out value = "${prod.id}"/> />
                          <input type="number" step="1" min="1" max="30" id="num_count" name="quantity" value="1" title="Qty">
                          <button type="submit" id= "circular-button">Заказать</button>
                          </form>
                        </div>

                    </td>

             </tr>
            </c:forEach>
        </table>
       <br><br><br><br><br>
        <form  action="SuccessBuy">
        <div align="center">
            <button type="submit" id= "circular-button">ЗАКАЗАТЬ ВСЁ</button>
        </div>

    </body>
</html>