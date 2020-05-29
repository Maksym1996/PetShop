<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />
<HTML>
<HEAD>
    <TITLE><fmt:message key="errorSearch.title"/></TITLE>
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
<h1 align="center"><fmt:message key="errorSearch.label"/>!!!</h1>

</body>
</html>