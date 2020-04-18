<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 18.04.2020
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Genre</title>
</head>

<body>
<c:forEach var="genre" items="${genre}">
    <li><c: value="${genre.name}" /></li>
</c:forEach>

<form action="/genres" method="POST">
    Name:
    <input name="name"/>
    <br><br>
    <input type="Add" value="Add" />
</form>

</body>
</html>
