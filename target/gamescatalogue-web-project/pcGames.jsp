
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
    <title>pcGames</title>
</head>

<body>
    <c:forEach var="pcGame" items="${pcGames}">
        <li><c: value="${pcGame.title}" /></li>
    </c:forEach>

    <form action="/pcGame" method="POST">
        Title:
        <input name="title"/>
        <br><br>
        Release year:
        <input type="date" name="year" id="1">
        <br><br>
        <input name="">

    </form>

</body>
</html>
