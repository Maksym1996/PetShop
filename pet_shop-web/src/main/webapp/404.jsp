<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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
        <title>���������� ��������</title>
    </head>
	<body>

		  <jsp:include page="header.jsp" />

		  <div align="center" ><p>Error 404!!!</p>
              <p>������ �� ������. �������� ���-������ ������</p>
          </div>
          <form action = "/pet_shop-web/" >
              <button type = "submit"  id = "circular-button">��������� �� ������</button>
          </form>
       
    </body>
</html>