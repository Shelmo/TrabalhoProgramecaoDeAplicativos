<%-- 
    Document   : FechaentoPedido
    Created on : 27/11/2016, 08:07:52
    Author     : Shelmo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="dao.DAO_Generalizado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fechamento de Pedido</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="scripts/FuncoesControleCadastro.js"></script>
        <script type="text/javascript" src="scripts/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid">
            <form class="form-horizontal" name="fecharPedido" action="FecharPedidoServlet" method="POST">
                <input type="hidden" name="codigo" value="${param.codigo}" />
                <%-- Cabeçalho básico --%>
                <div class="jumbotron">
                    <div class="row">
                        <h1 align="center">Pizzaria</h1>
                        <h3 align="center">Programação para Web</h3>
                    </div>
                    <br/>
                    <div class="btn-group btn-group-justified">
                        <a href="index.jsp" class="btn btn-primary">Pedido</a>
                        <a href="ListaCategoriaJSTL.jsp" class="btn btn-primary">Categoria</a>
                        <a href="ListaProdutoJSTL.jsp" class="btn btn-primary">Produto</a>
                        <a href="ListaClienteJSTL.jsp" class="btn btn-primary">Cliente</a>
                        <a href="#" class="btn btn-primary" onClick="alert('Engenharia de Computação\n\nDisciplina: Programação para Web\n\nAcadêmico: Shelmo Lucas Baches\n')">Sobre</a>
                    </div>
                </div>

                <%-- Título da pagina --%>
                <div class="row">
                    <h3 align="center">Fechamento de Pedidos</h3><br>
                </div>

                <%-- Tabelas de produtos adquiridos --%>
                <div class="row"><br/><br/>
                    <table class="table table-responsive table-striped">
                        <thead>
                            <tr>
                                <th width="200">Produto</th>
                                <th width="200">Categoria</th>
                                <th width="150">Quantidade</th>
                                <th width="150">Valor Unitário</th>
                                <th width="150">Valor Total</th>
                            </tr>
                        </thead>
                        <tbody var="h">
                            <c:set var="h" value="${0}"/>
                            <c:forEach var="i" items="<%=DAO_Generalizado.getList("from ItensPedido where idPedido = " + request.getParameter("codigo"))%>">
                                <tr>
                                    <td>${i.produto}</td>
                                    <td>${i.getProduto().getCategoria()}</td>
                                    <td>${i.quantidade}</td>
                                    <td>
                                        R$ 
                                        <fmt:setLocale value="pt_BR" />
                                        <fmt:formatNumber value="${i.getProduto().getValorProduto()}" type="number" minFractionDigits="2" />
                                    </td>
                                    <td>
                                        R$ 
                                        <fmt:setLocale value="pt_BR" />
                                        <fmt:formatNumber value="${i.getProduto().getValorProduto() * i.quantidade}" type="number" minFractionDigits="2" />
                                    </td>
                                </tr>
                                <c:set var="h" value="${h + i.getProduto().getValorProduto() * i.quantidade}" />
                            </c:forEach>
                            <%-- Parte estática da tabela --%>
                            <tr>
                                <%-- Valor total --%>
                                <td><strong>Total</strong></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <strong>
                                        R$
                                        <fmt:setLocale value="pt_BR" />
                                        <fmt:formatNumber value="${h}" type="number" minFractionDigits="2" />
                                    </strong>
                                </td>
                            </tr>

                            <tr>
                                <%-- Valor total --%>
                                <td><strong>Valor recebido</strong></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <input class="form-control" type="text" name="valorRecebido" value="<fmt:formatNumber value="${h}" type="number" minFractionDigits="2"/>" placeholder="R$" onkeyup="mascaraTroco(this, document.getElementsByName('valorDevolvido'), moeda, ${h})" required maxLenght="14" />
                                </td>
                            </tr>

                            <tr>
                                <%-- Valor devolvido --%>
                                <td><strong>Valor devolvido ao cliente</strong></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <input class="form-control" type="text" name="valorDevolvido" value="<fmt:formatNumber value="0" type="number" minFractionDigits="2"/>" readonly="true"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                                
                <div class="row"><br/><br/>
                    <div align="center">
                        <input class="btn btn-success" type="submit" value="Concluir venda" name="fecharPedido" />
                        <a class="btn btn-info" href="ItensPedidoJSTL.jsp">Voltar</a>
                    </div>
                </div><br/><br/>

            </form>

        </div>
    </body>
</html>
