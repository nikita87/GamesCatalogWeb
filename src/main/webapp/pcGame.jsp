
<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 18.04.2020
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>PcGames</title>
</head>

<body>
    <c:forEach var="pcGame" items="${pcGames}">
        <li><c: value="${pcGame.title}" /></li>
        <li><c: value="${pcGame.description}" /></li>

    </c:forEach>

    <form action="/pcGame" method="POST">
        Title:
        <input name="title"/>
        <br><br>
        Release year:
        <input type="date" name="year" id="masthead-label-1">
        <br><br>
        Description:
        <input name="description">
        <br><br>
        Price:
        <input type="number" name="price" id="masthead-label-2">
        <br><br>
        Currency:
        <input type="radio" name="USD" id="ssv3-checkbox">
        <input type="radio" name="EUR" id="ssv4-checkbox">
        <br><br>
        <input type="Add" value="Add" />
    </form>

</body>
</html>
