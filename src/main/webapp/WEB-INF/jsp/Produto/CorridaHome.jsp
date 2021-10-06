<%--
  Created by IntelliJ IDEA.
  User: tauan
  Date: 10/6/2021
  Time: 1:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.ATUber.ATUber.model.domain.Solicitante"%>
<%@ page import="br.com.ATUber.ATUber.model.domain.Corrida" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Corrida Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">

    <form action="/Corrida/Cadastro" method="get">
        <button type="submit" class="btn btn-link">Incluir</button>
    </form>

    <hr>
    <%List<Corrida> listaCorridas = (List<Corrida>) request.getAttribute("lista"); %>
    <%if(listaCorridas != null && listaCorridas.size() > 0){%>
        <h4>Corridas realizadas: <%=listaCorridas.size()%>!</h4>

        <hr>
        <%String mensagem = (String) request.getAttribute("mensagem"); %>
        <%if(mensagem != null){%>
                <div class="alert alert-success">
                    <strong>Sucesso!</strong> ${mensagem}
                </div>
         <%}%>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Origem</th>
                <th>Destino</th>
                <th>Com animais?</th>
                <th>Com paradas?</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <% for(Corrida corrida : listaCorridas){%>
                <tr>
                    <td><%=corrida.getId()%></td>
                    <td><%=corrida.getOrigem()%></td>
                    <td><%=corrida.getDestino()%></td>
                    <td><%=corrida.isComAnimais()%></td>
                    <td><%=corrida.isParadaNoCaminho()%></td>
                    <td><a href="/Corrida/<%=corrida.getId()%>/excluir">Excluir</a></td>
                </tr>
            <%}%>
            </tbody>
        </table>
    <%}%>

    <%if(listaCorridas == null || listaCorridas.size() == 0){%>
    <%String mensagem = (String) request.getAttribute("mensagem"); %>
    <%if(mensagem != null){%>
    <div class="alert alert-success">
        <strong>Sucesso!</strong> ${mensagem}
    </div>
    <%}%>
    <hr>
        <h4>Não há corridas cadastrados!!!</h4>
    <%}%>
</div>
</html>
