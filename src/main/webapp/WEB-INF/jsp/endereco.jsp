<%@ page import="br.com.ATUber.ATUber.model.domain.Endereco" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Endereco endereco = (Endereco)request.getAttribute("meuEndereco"); %>
<div class="form-row">
    <div class="form-group col-md-2">
        <label>Cep:</label>
        <%if(endereco != null){%>
            <input type="text" class="form-control" value="<%=endereco.getCep()%>" placeholder="Entre com o seu cep" name="cep">
        <%}else{%>
             <input type="text" class="form-control" value="" placeholder="Entre com o seu cep" name="cep">
        <%}%>
    </div>
    <div class="form-group col-md-5">
        <label>Logradouro:</label>
        <%if(endereco != null){%>
        <input type="text" class="form-control" value="$<%=endereco.getLogradouro()%>" placeholder="Entre com o seu logradouro" name="logradouro">
        <%}else{%>
        <input type="text" class="form-control" value="" placeholder="Entre com o seu logradouro" name="logradouro">
        <%}%>

    </div>
    <div class="form-group col-md-5">
        <label>Complemento:</label>
        <%if(endereco != null){%>
        <input type="text" class="form-control" value="$<%=endereco.getComplemento()%>" placeholder="Entre com o seu complemento" name="complemento">
        <%}else{%>
        <input type="text" class="form-control" value="" placeholder="Entre com o seu complemento" name="complemento">
        <%}%>

    </div>
</div>

<div class="form-row">
    <div class="form-group col-md-4">
        <label>Bairro:</label>
        <%if(endereco != null){%>
        <input type="text" class="form-control" value="<%=endereco.getBairro()%>" placeholder="Entre com o seu bairro" name="bairro">
        <%}else{%>
        <input type="text" class="form-control" value="" placeholder="Entre com o seu bairro" name="bairro">
        <%}%>

    </div>
    <div class="form-group col-md-6">
        <label>Localidade:</label>
        <%if(endereco != null){%>
        <input type="text" class="form-control" value="<%=endereco.getLocalidade()%>" placeholder="Entre com a sua localidade" name="localidade">
        <%}else{%>
        <input type="text" class="form-control" value="" placeholder="Entre com a sua localidade" name="localidade">
        <%}%>

    </div>
    <div class="form-group col-md-2">
        <label>Unidade da Federação:</label>
        <%if(endereco != null){%>
        <input type="text" class="form-control" value="<%=endereco.getUf()%>" placeholder="Entre com a sua unidade da federação" name="uf">
        <%}else{%>
        <input type="text" class="form-control" value="" placeholder="Entre com a sua unidade da federação" name="uf">
        <%}%>

    </div>
</div>