<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client List</title>
</head>
<body>

<h1>Listes des clients</h1>
<c:forEach items="${clients}" var="client">
    <tr>
    <td id="gameId">${client.idClient}</td>
    <td>${client.nameClient}</td>
    <td>${client.cityClient}</td>
    </tr>
</c:forEach>
</body>
</html>
