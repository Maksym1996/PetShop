<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />
<HTML>
<HEAD>
    <TITLE><fmt:message key="wrong.title"/></TITLE>
    <META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
    <META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="uk-UK">
   	<LINK rel="stylesheet" href="styles.css">
	<LINK rel="stylesheet" href="reset.css">
    <style>

    </style>
</HEAD>
<BODY>
<jsp:include page="header.jsp" />
<h1 align="center"><fmt:message key="wrong.label"/></h1>
<br><br><br>
<div align=" center">
    <form  action = "pet_shop-web/">
        <button type="submit" ><fmt:message key="wrong.button"/></button>
    </form></div>
</BODY>
</HTML>