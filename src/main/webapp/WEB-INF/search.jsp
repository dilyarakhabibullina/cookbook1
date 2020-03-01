<%@ page import="ru.itpark.domain.Recipe" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: днс
  Date: 29.02.2020
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%-- Если в сервлете я называю параметры как хочу, то здесь имена чётко --%>
    <%-- request - HttpServletRequest --%>
    <%-- response - HttpServletResponse --%>
    <title><%= request.getAttribute("page-title") %></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<!-- Emmet -->
<!-- tag + Tab -> <tag></tag> -->
<!-- tag.classname + Tab -> <tag class="classname"></tag> -->
<!-- Separation of concerns -->
Почему не получается вывести список из названий рецептов???
<div class="container">
    <% if (request.getAttribute("items") != null) { %>
    <ul class="list-group">
        <% for (Recipe user : (List<Recipe>)request.getAttribute("items")) { %>
        <li class="list-group-item"><%= user.getName() %></li>
        <% } %>
    </ul>
    <% } %>
</div>


</body>
</html>