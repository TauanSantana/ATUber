<%--
  Created by IntelliJ IDEA.
  User: tauan
  Date: 10/6/2021
  Time: 1:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <form action="/cep" class="form-inline" method="post">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="Entre com o seu cep" name="cep">
            <button type="submit" class="btn btn-primary">Buscar</button>
        </div>
    </form>

    <form action="/login/CadastroSolicitante" method="post">

        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" class="form-control" name="nome" id="nome">
        </div>
        <div class="form-group">
            <label for="cpf">CPF:</label>
            <input type="text" class="form-control" name="cpf" id="cpf">
        </div>
        <div class="form-group">
            <label for="email">E-mail</label>
            <input type="email" class="form-control" name="email" id="email">
        </div>
        <div class="form-group">
            <label for="senha">Senha:</label>
            <input type="password" class="form-control" name="senha" id="senha">
        </div>
        <c:import url="/WEB-INF/jsp/endereco.jsp"/>
        <button type="submit" class="btn btn-default">Enviar</button>
    </form>
</div>
</body>
</html>
