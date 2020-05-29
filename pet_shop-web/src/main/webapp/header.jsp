<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${not empty param.language}">
  <c:set var="language" value="${param.language}" scope="session"/>
</c:if>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="Bundles" />

<div id = "left-head" >
    &nbsp
    <form action="language" id="lang-flag" >
        <input type="hidden" name="lang" value="ua">
        <input type="image" name="image"  src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/Flag_UA.jpg" height="20"  width="25">&nbsp
    </form>

    <form action="language" id="lang-flag">
         <input type="hidden" name="lang" value="ru">
        <input type="image" src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/Flag_RU.jpg" height="20"  width="25">&nbsp
    </form>

    <form action="language" id="lang-flag">
        <input type="hidden" name="lang" value="en">
        <input type="image" src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/Flag_UK.jpg" height="20"  width="25">
     </form>
    <br>
    <br>
    <a href="/pet_shop-web/"><img src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/%D0%97%D0%BD%D0%B0%D1%87%D0%BE%D0%BA.PNG" width="130%"></a>
</div>

<div id = "right-head" class = "shadow">
    <img src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/%D0%9F%D1%80%D0%BE%D1%84%D0%B8%D0%BB%D1%8C.png" height="20"  width="5%"><a href="Profile"> <fmt:message key="header.profile"/></a>&nbsp
    <img src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/%D0%9A%D0%BE%D0%BD%D1%82%D0%B0%D0%BA%D1%82%D1%8B.png" height="20" width="5%"><a href="Contacts"><fmt:message key="header.contact"/></a>&nbsp
    <img src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/%D0%9A%D0%BE%D1%80%D0%B7%D0%B8%D0%BD%D0%B0.png" height="20"  width="5%"><a href="basket"><fmt:message key="header.basket"/></a>
    <br><br>
    <a href="https://www.purina-felix.com.ua/"><img src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/%D0%A0%D0%B5%D0%BA%D0%BB%D0%B0%D0%BC%D0%B0.jpg" height="150" width="100%"></a>

</div>

<div id = "middle-head">

    <br><br><br><br><br><br>
    <div class="wrapper">
        <div class="container">
            <form action= "SearchResult">
                <input type="text" class="input" name= "search" placeholder="<fmt:message key="header.label.search"/> ">
                <input type="submit" value="<fmt:message key="header.search"/>" class="close-btn">
            </form>
        </div>
    </div>
</div>


    <img src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/OrangeLine.PNG" height="15" width="100%">




<nav>
    <ul>
        <li><a href="Catalog?pet=0"><fmt:message key="header.dog"/></a>
            <ul>
                <li><a href="Catalog?pet=0&type_product=0"><fmt:message key="header.mainproduct"/></a></li>
                <li><a href="Catalog?pet=0&type_product=1"><fmt:message key="header.healthproducts"/></a></li>
                <li><a href="Catalog?pet=0&type_product=2"><fmt:message key="header.goodies"/></a></li>
                <li><a href="Catalog?pet=0&type_product=3"><fmt:message key="header.cannedfood"/></a></li>
            </ul>
        </li>
        <li><a href="Catalog?pet=1"><fmt:message key="header.cat"/></a>
            <ul>
                <li><a href="Catalog?pet=1&type_product=0"><fmt:message key="header.mainproduct"/></a></li>
                <li><a href="Catalog?pet=1&type_product=1"><fmt:message key="header.healthproducts"/></a></li>
                <li><a href="Catalog?pet=1&type_product=2"><fmt:message key="header.goodies"/></a></li>
                <li><a href="Catalog?pet=1&type_product=3"><fmt:message key="header.cannedfood"/></a></li>
            </ul>
        </li>
        <li><a href="Catalog?pet=2"><fmt:message key="header.rodent"/></a>
            <ul>
                 <li><a href="Catalog?pet=2&type_product=0" ><fmt:message key="header.mainproduct"/></a></li>
                 <li><a href="Catalog?pet=2&type_product=1"><fmt:message key="header.healthproducts"/></a></li>
                 <li><a href="Catalog?pet=2&type_product=2"><fmt:message key="header.goodies"/></a></li>
                 <li><a href="Catalog?pet=2&type_product=3"><fmt:message key="header.cannedfood"/></a></li>
            </ul>
        </li>
        <li><a href="Catalog?pet=3"><fmt:message key="header.fish"/></a>
             <ul>
                 <li><a href="Catalog?pet=3&type_product=0"><fmt:message key="header.mainproduct"/></a></li>
                    <li><a href="Catalog?pet=3&type_product=1"><fmt:message key="header.healthproducts"/></a></li>
                    <li><a href="Catalog?pet=3&type_product=2"><fmt:message key="header.goodies"/></a></li>
                    <li><a href="Catalog?pet=3&type_product=3"><fmt:message key="header.cannedfood"/></a></li>
             </ul>
        </li>
        <li> <a href="Catalog?pet=4"><fmt:message key="header.bird"/></a>
            <ul>
                <li><a href="Catalog?pet=4&type_product=0"><fmt:message key="header.mainproduct"/></a></li>
                <li><a href="Catalog?pet=4&type_product=1"><fmt:message key="header.healthproducts"/></a></li>
                <li><a href="Catalog?pet=4&type_product=2"><fmt:message key="header.goodies"/></a></li>
                <li><a href="Catalog?pet=4&type_product=3"><fmt:message key="header.cannedfood"/></a></li>
            </ul>
        </li>
    </ul>
</nav>

    <img src="https://raw.githubusercontent.com/Maksym1996/Diplom/master/OrangeLine.PNG" height="15" width="100%">


