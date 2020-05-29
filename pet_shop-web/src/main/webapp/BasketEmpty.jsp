<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />
<HTML>
<HEAD>
    <TITLE><fmt:message key="basketEmpty.title"/></TITLE>
    <META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
    <META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="uk-UK">
   	<LINK rel="stylesheet" href="styles.css">
	<LINK rel="stylesheet" href="reset.css">
    <style>

     div{
             margin-left: 30px;
         }
    </style>
</HEAD>
<BODY>
<jsp:include page="header.jsp" />
<p align="center">
    <font size=+2> <fmt:message key="basketEmpty.label1"/>:( <br> <fmt:message key="basketEmpty.label2"/> !!!
    </font> <br> <br> <img
        src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/%D0%93%D1%80%D1%83%D1%81%D1%82%D0%BD%D1%8B%D0%B9%20%D0%BA%D0%BE%D1%82.jpg">
</p>


</BODY>
</HTML>