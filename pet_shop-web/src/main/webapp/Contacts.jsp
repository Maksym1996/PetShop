<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
    <TITLE>Страница регистрации</TITLE>
    <META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
    <Meta charset="utf8">
    <META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="uk-UK">
   	<LINK rel="stylesheet" href="styles.css">
	<LINK rel="stylesheet" href="reset.css">
    <style>

        h1{
                     font-family: 'Courier New';
                     font-size: 50px;
                }
                p {
                    font-family: 'Courier New';
                    font-size: 30px;
                 }
    </style>
</HEAD>
<BODY>
<jsp:include page="header.jsp" />
<br>
<br>
<br>
<h1 align="center">Наши Контакты</h1>
<div align="center">
    <br>
    <p> Контактное лицо: студент КН-316в Кордонец Максим</p>
    <br>
    <p>Обращайтесь по телефону: +380969055386</p>
    <br>
    <p>
        или пишите на электронную почту: <a href="mailto:my@email">kordonetsmax@gmail.com</a>
    </p>
    <br>
    <form action="MainPage">
        <button id = "circular-button">На главную</button>
        </form>
</div>
    </body>
</html>