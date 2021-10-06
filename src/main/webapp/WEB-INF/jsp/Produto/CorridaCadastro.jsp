<%--
  Created by IntelliJ IDEA.
  User: tauan
  Date: 10/6/2021
  Time: 2:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Inclusão Corrida</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>
<div class="container">
    <form action="/Corrida" method="post">
        <div class="form-group">
            <label for="origem">Origem:</label>
            <input type="text" class="form-control" name="origem" id="origem">
        </div>
        <div class="form-group">
            <label for="destino">Destino:</label>
            <input type="text" class="form-control" name="destino" id="destino">
        </div>
        <div class="form-group">
            <label for="comAnimais">Com Animais?</label>
            <input type="checkbox" class="form-control" name="comAnimais" id="comAnimais">
        </div>
        <div class="form-group">
            <label for="paradaNoCaminho">Parada no Caminho?:</label>
            <input type="checkbox" class="form-control" name="paradaNoCaminho" id="paradaNoCaminho">
        </div>

        <button type="submit" class="btn btn-default">Enviar</button>
    </form>
</div>
</body>
</html>
