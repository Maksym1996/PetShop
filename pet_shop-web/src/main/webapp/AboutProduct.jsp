<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />
<html>
    <head>
       <META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
        <META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="uk-UK">
              	<META NAME="DESCRIPTION" CONTENT="Онлайн-магазин для домашніх тварин">
              	<META NAME="KEYWORDS" CONTENT="Онлайн-магазин, товар, домашние, животные, собака, кот, кошка, рыба, кролик, попугай, хомяк, крыса, шиншила">
              	<LINK rel="stylesheet" href="styles.css">
              	<LINK rel="stylesheet" href="reset.css">
              	<style>
              	    h3{
              	         margin-left:10px;
              	    }
              	    h1{
              	    font-size: 50px;
              	    font-family: 'Courier New'
              	    }
              	   .leftimg {
                       float:left; /* Выравнивание по левому краю */
                       margin: 7px 10% 7px 0; /* Отступы вокруг картинки */
                      }
                      .bot {
                                             float:left; /* Выравнивание по левому краю */
                                             margin: 7px 7px 7px 10px; /* Отступы вокруг картинки */

                                            }
              	</style>
        <title><fmt:message key="aboutProduct.title"/></title>
    </head>
	<body>
		
		  <jsp:include page="header.jsp" />
		  <h1 align="center"> <c:out value = "${prod.name}"/> </h1>
		  <p>
		  		<img src= <c:out value = "${prod.photo_link}"/> height = "300" width ="200" class= "leftimg">
		  	</p>

		  	<h3><fmt:message key="aboutProduct.main"/></h3>
		  			<table>
		  				<tr>
		  					<td><fmt:message key="aboutProduct.weight"/></td>
		  					<td><p align="right"> <c:out value = "${prod.weight}" /> </p></td>
		  				</tr>
		  				<tr>
		  					<td><fmt:message key="aboutProduct.age"/></td>
		  					<td><p align="right"> <c:out value = "${prod.age}"/> </p></td>
		  				</tr>
		  				<tr>
		  					<td><fmt:message key="aboutProduct.producer"/></td>
		  					<td><p align="right"> <c:out value = "${prod.producer}"/> </p></td>
		  				</tr>
		  				<tr>
		  					<td><fmt:message key="aboutProduct.type"/></td>
		  					<td><p align="right"> <c:out value = "${type}"/> </p></td>
		  				</tr>
		  				<tr>
		  					<td><fmt:message key="aboutProduct.breed"/></td>
		  					<td><p align="right"> <c:out value = "${breed}"/> </p></td>
		  				</tr>
		  				<tr>
                        	<td><fmt:message key="aboutProduct.price"/></td>
                        	<td><p align="right"> <c:out value = "${prod.price}"/> </p></td>
                        </tr>
		  			</table>
		  			<br>
		  			<form action="back" method = "GET" >
		  				<input type = "hidden" name = "id" id = "id" value = <c:out value = "${prod.id}"/> />
		  				<button type="submit" id = "circular-button"><fmt:message key="aboutProduct.button"/></button>
		  			</form>
		  		</td>
		  	</tr>
		  </table>

		  <br>
		  <br>
		  <br>
		  <div class = "bot">
		  <h3 align="left"><fmt:message key="aboutProduct.description"/></h3>
		  <p> <c:out value = "${prod.description}"/></p>
            </div>
</body>
</html>
