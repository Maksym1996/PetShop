<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />
<HTML>
<HEAD>
    <TITLE><fmt:message key="contacts.title"/></TITLE>
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
<h1 align="center"><fmt:message key="contacts.title"/></h1>
<div align="center">
    <br>
    <p> <fmt:message key="contacts.label1"/></p>
    <br>
    <p><fmt:message key="contacts.label2"/>: +380969055386</p>
    <br>
    <p>
        <fmt:message key="contacts.label3"/>: <a href="mailto:my@email">kordonetsmax@gmail.com</a>
    </p>
    <br>
    <form action="MainPage">
        <button id = "circular-button"><fmt:message key="contacts.button"/></button>
        </form>
</div>
    </body>
</html>