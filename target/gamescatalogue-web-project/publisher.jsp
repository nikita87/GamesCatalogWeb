<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 18.04.2020
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <title>Publisher</title>
</head>

<body>
    <%--<c:forEach var="publisher" items="${publisher}">
        <li><c: value="${publisher.name}"/></li>
    </c:forEach>--%>

    <form action="publishers" method="POST">
        Name:
        <input name="name"/>
        <br><br>
        Country:
        <input name="country"/>
        <br><br>

        <input type="Add" value="Add">
    </form>
</body>
</html>
