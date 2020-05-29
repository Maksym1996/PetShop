<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />
<HTML>
<HEAD>
    <TITLE><fmt:message key="registration.title"/></TITLE>
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



<h1 align ="center"><fmt:message key="registration.main"/></h1>
<br>
<br>
<div>
    <h3><fmt:message key="registration.label"/></h3>
    <br>
    <form action="Registration" method="POST">
        <p><fmt:message key="registration.name"/></p>
        <br>
        <INPUT required TYPE="TEXT" NAME="name" SIZE="20" MAXLEN="20"/>
        <c:if test="${not empty errors and errors.containsKey('name')}">
            <p style="color: red"><c:out value = "${errors.name}"/></p>
        </c:if>
        <br>
        <br>
        <p><fmt:message key="registration.surname"/></p>
        <br>
        <INPUT required TYPE="TEXT" NAME="surname" SIZE="20" MAXLEN="20"/>
        <c:if test="${not empty errors and errors.containsKey('sur')}">
            <p style="color: red"><c:out value = "${errors.sur}"/></p>
        </c:if>
        <br>
        <br>
        <p><fmt:message key="registration.phone"/></p>
        <br>
        <INPUT required TYPE="tel" NAME="mobile" placeholder="(XXX)-XXX-XXXX" pattern="[0-9]{10}" SIZE="20" MAXLEN="20"/>
<c:if test="${not empty errors and errors.containsKey('phone')}">
   <p style="color: red"><c:out value = "${errors.phone}"/></p>
</c:if>
         <c:if test="${not empty errors and errors.containsKey('phoneOrigin')}">
             <p style="color: red"><c:out value = "${errors.phoneOrigin}"/></p>
         </c:if>
         <c:if test="${not empty errors and errors.containsKey('phonePattern')}">
             <p style="color: red"><c:out value = "${errors.phonePattern}"/></p>
         </c:if>
        <br>
        <br>
        <p><fmt:message key="registration.email"/></p>
        <br>
        <INPUT required TYPE="email" NAME="email" placeholder="user@gmail.com"
            pattern="^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(?:\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@(?:[a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\.)*(?:aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$"
            SIZE="20" />
        <c:if test="${not empty errors and errors.containsKey('mail')}">
            <p style="color: red"><c:out value = "${errors.mail}"/></p>
        </c:if>
        <c:if test="${not empty errors and errors.containsKey('mailOrigin')}">
            <p style="color: red"><c:out value = "${errors.mailOrigin}"/></p>
        </c:if>
        <c:if test="${not empty errors and errors.containsKey('mailPattern')}">
           <p style="color: red"><c:out value = "${errors.mailPattern}"/></p>
        </c:if>
        <br>
        <br>
        <p>
            <label for="password"><fmt:message key="registration.pass"/>: </label>
        </p>
        <br>
        <INPUT required TYPE="PASSWORD" NAME="pass" id="password" SIZE="20"
               MAXLEN="20"/>
         <c:if test="${not empty errors and errors.containsKey('pass')}">
            <p style="color: red"><c:out value = "${errors.pass}"/></p>
         </c:if>
        <br>
        <br>
        <button type="submit" id="circular-button"><fmt:message key="registration.button"/></button>
    </form>
</div>


</BODY>
</HTML>