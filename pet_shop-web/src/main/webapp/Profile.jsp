<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />
<HTML>
<HEAD>
    <TITLE><fmt:message key="profile.title"/></TITLE>
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

        <h1><fmt:message key="profile.title"/></h1>
        <br>
        <br>
        <p>
            <label for="email"> <fmt:message key="profile.email"/>:</label>
        </p>
        <br>
        <INPUT required ID="email" TYPE="email" NAME="email" SIZE="50" MAXLEN="50"/>
        <br>
        <br>
        <p>
            <label for="pass"><fmt:message key="profile.pass"/>:</label>
        </p>
        <br>

        <INPUT required ID="pass" TYPE="PASSWORD" NAME="pass" SIZE="30" MAXLEN="30"/>
        <br>
        <c:if test="${not empty errors and errors.containsKey('error')}">
                    <p style="color: red"><c:out value = "${errors.error}"/></p>
        </c:if>
        <br>

        <button type="submit" id="circular-button"><fmt:message key="profile.button"/></button>
    </form>
    <br>
    <p>
        <fmt:message key="profile.label1"/> <a
            href="Registration"><u><font
            color=orange><fmt:message key="profile.label2"/></font></u></a> <fmt:message key="profile.label3"/>!
    </p>
</div>
</BODY>
</HTML>