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
                    <INPUT required  TYPE="hidden" NAME="id" id="id" value = "<c:out value = "${prod.id}"/>" />
                  <br>
                  <p>
                      <label for="name">Наименование: </label>
                  </p>
                  <br>

                  <INPUT required  TYPE="text" NAME="name1" id="name1" SIZE="30" value = "<c:out value = "${prod.name}" />" />
                  <br>
                  <br>
                  <p>
                      <label for="price">Цена: </label>
                  </p>
                  <br>
                  <br>
                  <INPUT required TYPE="text" NAME="price" id="price" SIZE="20" value = "<c:out value = "${prod.price}"/>" />
                  <br>
                  <br>
                  <p>
                      <label for="description">Описание: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="description" id="description" SIZE="100" value = "<c:out value = "${prod.description}"/>" />

                  <br>
                  <br>
                  <p>
                      <label for="amount">Количество: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="amount" id="amount" SIZE="20" value = "<c:out value = "${prod.amount}"/>" />
                  <br>
                  <br>
                  <p>
                      <label for="weight">Вес: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="weight" id="weight" SIZE="20" value = "<c:out value = "${prod.weight}"/>" />
                  <br>
                  <br>
                  <p>
                      <label for="producer">Изготовитель: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="producer" id="producer" SIZE="20" value = "<c:out value = "${prod.producer}"/>" />
                  <br>
                  <br>
                  <p>
                      <label for="type_id">Категория товара: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="type_id" id="type_id" SIZE="20" value = "<c:out value = "${prod.type_id}"/>" />
                  <br>
                  <br>
                  <p>
                      <label for="age">Для какого возраста: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="age" id="age" SIZE="20" value = "<c:out value = "${prod.age}"/>" />
                  <br>
                  <br>
                  <p>
                      <label for="breed">Порода питомца: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="breed" id="breed" SIZE="20" value = "<c:out value = "${prod.breed}"/>" />
                  <br>
                  <br>
                  <p>
                      <label for="pet_id">Для какого домашнего животного: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="pet_id" id="pet_id" SIZE="20" value = "<c:out value = "${prod.pet_id}"/>" />
                  <br>
                  <br>
                  <p>
                      <label for="photo_link">Ссылка на картинку: </label>
                  </p>
                  <br>
                  <INPUT required TYPE="text" NAME="photo_link" id="photo_link" SIZE="50" value = "<c:out value = "${prod.photo_link}"/>" />
                  <br>
                  <br>
                  <button type = "submit"  id = "circular-button">Изменить товар</button>
              </form>
             </div>
              <br>
              <br>
       

       
    </body>
</html>