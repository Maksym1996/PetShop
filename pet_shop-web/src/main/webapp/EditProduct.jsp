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
        <title>Измениение продукта</title>
    </head>
	<body>

		  <jsp:include page="header.jsp" />
		  <h1 align = "center">Изменение товара </h1>
		  <div>
              <form action="EditProduct" method="post">
                    <INPUT required  TYPE="hidden" NAME="id" id="id" value = "<c:out value = "${prod.id}" />"  />
                  <br>
                  <c:if test="${not empty errors and errors.containsKey('prodOrigin')}" >
                                       <p style="color: red" ><c:out value = "${errors.prodOrigin}" /></p>
                              </c:if>
                  <p>
                   <p>
                               <label for="name">Наименование: </label>
                           </p>
                           <br>
                           <INPUT required  TYPE="text" NAME="name" id="name" pattern= "^[А-Яа-яЁё\sA-Za-z]+$" value = "<c:out value = "${prod.name}" />" SIZE="30"/>
                           <c:if test="${not empty errors and errors.containsKey('name')}">
                              <p style="color: red"><c:out value = "${errors.name}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="price">Цена: </label>
                           </p>
                           <br>
                           <br>
                           <INPUT required TYPE="text" NAME="price" id="price" pattern="[0-9]+" value = "<c:out value = "${prod.price}" />" SIZE="20"/>
                           <c:if test="${not empty errors and errors.containsKey('price')}">
                              <p style="color: red"><c:out value = "${errors.price}" /></p>
                           </c:if>
                           <c:if test="${not empty errors and errors.containsKey('pricePattern')}">
                              <p style="color: red"><c:out value = "${errors.pricePattern}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="description">Описание: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="description" id="description" value = "<c:out value = "${prod.description}" />" SIZE="100"/>
                           <c:if test="${not empty errors and errors.containsKey('description')}">
                              <p style="color: red"><c:out value = "${errors.description}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="amount">Количество: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="amount" id="amount" pattern="[0-9]+" value = "<c:out value = "${prod.amount}" />" SIZE="20"/>
                           <c:if test="${not empty errors and errors.containsKey('amount')}">
                              <p style="color: red"><c:out value = "${errors.amount}" /></p>
                           </c:if>
                           <c:if test="${not empty errors and errors.containsKey('amountPattern')}">
                              <p style="color: red"><c:out value = "${errors.amountPattern}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="weight">Вес: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="weight" id="weight" pattern="[0-9]+" value = "<c:out value = "${prod.weight}" />" SIZE="20"/>
                           <c:if test="${not empty errors and errors.containsKey('weight')}">
                              <p style="color: red"><c:out value = "${errors.weight}" /></p>
                           </c:if>
                           <c:if test="${not empty errors and errors.containsKey('weightPattern')}">
                              <p style="color: red"><c:out value = "${errors.weightPattern}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="producer">Изготовитель: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="producer" id="producer" pattern= "^[А-Яа-яЁё\sA-Za-z]+$" value = "<c:out value = "${prod.producer}" />" SIZE="20"/>
                           <c:if test="${not empty errors and errors.containsKey('producer')}">
                              <p style="color: red"><c:out value = "${errors.producer}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="type_id">Категория товара: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="type_id" id="type_id" pattern = "[0-4]" value = "<c:out value = "${prod.type_id}" />" SIZE="20"/>
                           <c:if test="${not empty errors and errors.containsKey('type_id')}">
                              <p style="color: red"><c:out value = "${errors.type_id}" /></p>
                           </c:if>
                           <c:if test="${not empty errors and errors.containsKey('type_idPattern')}">
                              <p style="color: red"><c:out value = "${errors.type_idPattern}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="age">Для какого возраста: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="age" id="age" pattern= "^[А-Яа-яЁё\sA-Za-z]+$" value = "<c:out value = "${prod.age}" />" SIZE="20"/>
                           <c:if test="${not empty errors and errors.containsKey('age')}">
                              <p style="color: red"><c:out value = "${errors.age}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="breed">Порода питомца: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="breed" id="breed" pattern= "^[А-Яа-яЁё\sA-Za-z]+$" value = "<c:out value = "${prod.breed}" />" SIZE="20"/>
                           <c:if test="${not empty errors and errors.containsKey('breed')}">
                              <p style="color: red"><c:out value = "${errors.breed}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="pet_id">Для какого домашнего животного: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="pet_id" id="pet_id"  pattern = "[0-4]" value = "<c:out value = "${prod.pet_id}" />" SIZE="20"/>
                           <c:if test="${not empty errors and errors.containsKey('pet_id')}">
                              <p style="color: red"><c:out value = "${errors.pet_id}" /></p>
                           </c:if>
                           <c:if test="${not empty errors and errors.containsKey('pet_idPattern')}">
                              <p style="color: red"><c:out value = "${errors.pet_idPattern}" /></p>
                           </c:if>
                           <br>
                           <br>
                           <p>
                               <label for="photo_link">Ссылка на картинку: </label>
                           </p>
                           <br>
                           <INPUT required TYPE="text" NAME="photo_link" id="photo_link" value = "<c:out value = "${prod.photo_link}" />" SIZE="50"/>
                           <c:if test="${not empty errors and errors.containsKey('photo_link')}">
                              <p style="color: red"><c:out value = "${errors.photo_link}" /></p>
                           </c:if>
                  <br>
                  <br>
                  <button type = "submit"  id = "circular-button">Изменить товар</button>
              </form>
             </div>
              <br>
              <br>
       

       
    </body>
</html>