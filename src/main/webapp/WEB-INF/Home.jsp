<%--
  Created by IntelliJ IDEA.
  User: Théo
  Date: 19/11/2020
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Jeu</title>
</head>
<body>
    <div class="container mt-4">
        <h1>Jeu</h1>
        <a href="/PokemonWeb_war">Retour</a>

        <form action="HomeServlet" method="post">
            <input name="number" type="number" min="0" max="10">
            <input value="send" type="submit">
        </form>
    </div>
</body>
</html>
