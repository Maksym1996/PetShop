<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
              	        div{
              	            margin-left: 30px;
              	        }
                        p{
                            font-family:'Courier New';
                            font-size: 20px;
                        }

                        h1{
                             font-family: 'Courier New';
                             font-size: 50px;
                        }
                    </style>
        <title><fmt:message key="404.title"/></title>
    </head>
	<body>

		  <jsp:include page="header.jsp" />

		  <div align="center" ><p><fmt:message key="404.label1"/></p>
              <p><fmt:message key="404.label2"/></p>
          </div>
          <form action = "/pet_shop-web/" >
              <button type = "submit"  id = "circular-button"><fmt:message key="404.button"/></button>
          </form>
       
    </body>
</html>