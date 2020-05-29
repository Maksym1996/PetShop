<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />

<html>
    <head>
       <META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=UTF-8">
        <META HTTP-EQUIV="CONTENT-LANGUAGE" CONTENT="uk-UK">
              	<META NAME="DESCRIPTION" CONTENT="������-������� ��� ������� ������">
              	<META NAME="KEYWORDS" CONTENT="������-�������, �����, ��������, ��������, ������, ���, �����, ����, ������, �������, �����, �����, �������">
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
        <title><fmt:message key="gratitude.title"/></title>
    </head>
	<body>

		  <jsp:include page="header.jsp" />
		  <h1 align="center">
              <fmt:message key="gratitude.label"/>!!!</h1>
          <br>
          <div align="center">
              <img
                      src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/Joy.jpg">
              <br>
              <br>
              <form action = "/pet_shop-web/" >
                  <button type = "submit"  id = "circular-button">
                      <fmt:message key="gratitude.button"/></button>
              </form>
          </div>
          </BODY>
          </HTML>
       
