<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<LINK rel="stylesheet" href="styles.css">
	<LINK rel="stylesheet" href="reset.css">
	<style>
	     h1{
                    font-family: 'Courier New';
                    font-size: 50px;
                    margin-left:10px;
               }
          p{
            font-family: 'Courier New';
            font-size: 20px;
          }
          td{
                          width: 60px;
                          height:60px;
                          border: solid 1px silver;
                          text-align:center;
                      }

	</style>
	<title><fmt:message key="userProfile.title"/></title>
</head>
<body>
	 <jsp:include page="header.jsp" />
	 <h1><fmt:message key="userProfile.title"/></h1>
	 <br>

	 <div id="left-head">

	 	<p><fmt:message key="userProfile.name"/></p>
	 	<br>
	 	<p style="color:#000080"><c:out value="${user.name}"/></p>
	 	<br>
	 	<p><fmt:message key="userProfile.surname"/></p>
	 	<br>
	 	<p style="color:#000080"><c:out value="${user.surname}"/></p>
	 	<br>
	 	<p><fmt:message key="userProfile.phone"/></p>
	 	<br>
	 	<p style="color:#000080"><c:out value="${user.phone}"/></p>
	 	<br>
	 	<p><fmt:message key="userProfile.email"/></p>
	 	<br>
	 	<p style="color:#000080"><c:out value="${user.email}"/></p>
	 	<br>
	 	<br>
	 	<form action = "/pet_shop-web/">
	 		<button type = "submit" id = "circular-button"><fmt:message key="userProfile.button"/></button>
	 	</form>

         <form action = "Profile">
	            <input type="hidden" name="logout" id = "logout" value = "logout" />
     	 		<button type = "submit" id = "circular-button"><fmt:message key="userProfile.escapeButton"/></button>
         </form>
     </div>

    <% /*<div id = "middle-head">
           <table>
           <thread>
            <tr>
                        <th>№ заказа</th>  <th>Покупатель</th> <th>Товар</th>
              </tr>
           </thread>
            <c:forEach var="or" items="${order.orders}">
           <tr>
           <td>
                <p>${or.['id']}</p>
           </td>

           <td>
                <p>${or.['user_id']}</p>
           </td>
           <td>
                <p>${or.['produc_id']}</p>
            </td>
           </tr>
           </c:forEach>
     </div>*/
      %>
</body>
</html>