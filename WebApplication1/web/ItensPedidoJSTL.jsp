<%-- 
    Document   : ItensPedidoJSTL.jsp
    Created on : 20/10/2016, 21:19:46
    Author     : Shelmo
--%>

<%@page import="dao.DAO_Generalizado"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Produtos ao Pedido</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <div class="container-fluid center-block">
            <form class="form-horizontal" name="produto" action="ItensPedidoServlet" method="POST">

                <input type="hidden" name="codigo" value="${param.codigo}"/>
                <div class="jumbotron">
                    <h1 align="center">Adicionar Produtos ao Pedido</h1>
                </div>

                <div class="row">
                    <div class="col-md-offset-4">
                        <div class="col-md-4">
                            <h3>Cliente: ${param.nome}</h3>
                        </div>
                        <div class="col-md-4">
                            <h3>Mesa: ${param.mesa}</h3>
                        </div>
                    </div>
                </div>

                <div class="row"><br><br>
                    <div class="col-md-offset-3">
                        <div class="col-md-4">
                            <label for="cbx_produto" class="label label-primary">Produto</label>
                            <select class="form-control" name="cbx_produto">
                                <c:forEach var="p" items="<%=DAO_Generalizado.getList("from Produto")%>">
                                    <option value="${p.idProduto}">${p.nomeProduto}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label for="txtQuantidade" class="label label-primary">Quantidade</label>
                            <input class="form-control" type="number" name="txtQuantidade" value="" placeholder="0" required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <div align="center">
                            <br>
                            <input class="btn btn-primary btn-md" type="submit" value="Enviar" name="btEnviar" />
                            <a class="btn btn-info" href="index.jsp">Voltar</a>
                        </div>
                    </div>
                </div>
            </form>

            <div class="row"><br><br>
                <div class="col-md-offset-3">
                    <table class="table-bordered table-responsive table-striped">
                        <thead>
                            <tr align="center">
                                <th width = "205">Produto</th>
                                <th width = "205">Categoria</th>
                                <th width = "100">Quantidade</th>
                                <th width = "100">Valor Unitário</th>
                                <th width = "100">Valor Total</th>
                                <th width = "50">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="i" items="<%=DAO_Generalizado.getList("from ItensPedido where idPedido = " + request.getParameter("codigo"))%>">
                                <tr>
                                    <td>${i.produto}</td>
                                    <td>${i.getProduto().getCategoria()}</td>
                                    <td>${i.quantidade}</td>
                                    <td>
                                        R$ 
                                        <fmt:setLocale value="pt_BR"/>
                                        <fmt:formatNumber value="${i.getProduto().getValorProduto()}" type="number" minFractionDigits="2"/>
                                    </td>
                                    <td>
                                        R$ 
                                        <fmt:setLocale value="pt_BR"/>
                                        <fmt:formatNumber value="${i.getProduto().getValorProduto() * i.quantidade}" type="number" minFractionDigits="2"/>
                                    </td>
                                    <td>
                                        <form name="frm_excluir" action="ExcluirItensPedidoServlet" method="POST">
                                            <input type="hidden" name="codigo" value="${i.idItensPedido}"/>
                                            <input type="hidden" name="codigoPedido" value="${param.codigo}"/>
                                            <input type="hidden" name="cliente" value="${param.nome}"/>
                                            <input type="hidden" name="mesa" value="${param.mesa}"/>
                                            <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
