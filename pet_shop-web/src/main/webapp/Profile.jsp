<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<HTML>
<HEAD>
    <TITLE>Страница регистрации</TITLE>
    <META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
    <META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="uk-UK">
   	<LINK rel="stylesheet" href="styles.css">
	<LINK rel="stylesheet" href="reset.css">
    <style>

        h1{
            font-size:30px;
        }
        div{
          margin-left: 30px;
         }
    </style>
</HEAD>
<BODY>
<jsp:include page="header.jsp" />

<div align="center">
    <form method="POST" action="Profile">

        <h1>Вход в систему</h1>
        <br>
        <br>
        <p>
            <label for="email"> Введите адресс электронной почты:</label>
        </p>
        <br>
        <INPUT required ID="email" TYPE="email" NAME="email" SIZE="50" MAXLEN="50"/>
        <br>
        <br>
        <p>
            <label for="pass">Введите пароль:</label>
        </p>
        <br>

        <INPUT required ID="pass" TYPE="PASSWORD" NAME="pass" SIZE="30" MAXLEN="30"/>
        <br>
        <c:if test="${not empty errors and errors.containsKey('error')}">
                    <p style="color: red"><c:out value = "${errors.error}"/></p>
        </c:if>
        <br>

        <button type="submit" id="circular-button">Войти</button>
    </form>
    <br>
    <p>
        Вы еще не с нами?! Тогда <a
            href="Registration"><u><font
            color=orange>зарегистрируйтесь</font></u></a> прямо сейчас!
    </p>
</div>
</BODY>
</HTML>