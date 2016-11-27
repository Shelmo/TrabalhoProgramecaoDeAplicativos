<%-- 
    Document   : index
    Created on : 20/10/2016, 15:57:29
    Author     : Shelmo
--%>

<%@page import="dao.DAO_Generalizado"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzaria</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="scripts/FuncoesControleCadastro.js"></script>
        <script type="text/javascript" src="scripts/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid">

            <div class="jumbotron">
                <div class="row">
                    <h1 align="center">Pizzaria</h1>
                    <h3 align="center">Programação para Web</h3>
                </div>
                <br>
                <div class="btn-group btn-group-justified">
                    <a href="index.jsp" class="btn btn-primary">Pedido</a>
                    <a href="ListaCategoriaJSTL.jsp" class="btn btn-primary">Categoria</a>
                    <a href="ListaProdutoJSTL.jsp" class="btn btn-primary">Produto</a>
                    <a href="ListaClienteJSTL.jsp" class="btn btn-primary">Cliente</a>
                    <a href="#" class="btn btn-primary" onClick="alert('Engenharia de Computação\n\nDisciplina: Programação para Web\n\nAcadêmico: Shelmo Lucas Baches\n')">Sobre</a>
                </div>
            </div>
            
            <div class="row">
                <h3 align="center">Pedidos</h3><br>
            </div>


            <form class="form-horizontal" name="pedido" action="index.jsp" method="POST">
                <div class="row">
                    <div class="col-md-offset-1 col-md-4">
                        <div class="input-group">
                            <input type="text" id="txtFiltro" name="txtFiltro" class="form-control " placeholder="Filtrar por..." onkeyup="maxCaractereFiltro(this.value, 255)"/>
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                        Filtrar <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="submit" value="Cliente" name="btFiltroCliente" class="btn btn-primary btn-group-justified"/></li>
                                    <li><input type="submit" value="Mesa" name="btFiltroMesa" class="btn btn-primary btn-group-justified"/></li>
                                    <li><input type="submit" value="Data" name="btFiltroData" class="btn btn-primary btn-group-justified" onclick="procurarData(document.getElementById('txtFiltro').value)"/></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-offset-5 col-md-2">
                        <div class="form-group">
                            <a class="btn btn-success" href="PedidoJSTL.jsp">Novo Pedido</a>
                        </div>
                    </div>
                </div>
            </form>

            <div class="row">
                <div class="col-md-offset-1 col-md-4">
                    <div class="form-group">
                        <c:if test="${param.txtFiltro != null && param.txtFiltro.length() > 0}">
                            <h4>Filtro: ${param.txtFiltro}</h4>
                        </c:if>
                        <c:if test="${param.nomeIncluido != null}">
                            <c:if test="${param.idPedido == null}">
                                <h3>Um pedido foi adicionado ao cliente ${param.nomeIncluido}!</h3>
                            </c:if>
                            <c:if test="${param.idPedido != null}">
                                <h3>O pedido foi do cliente ${param.nomeIncluido} foi alterado!</h3>
                            </c:if>
                        </c:if>
                        <c:if test="${param.pedExcNome != null}">
                            <h3>O pedido do cliente ${param.pedExcNome} foi excluido!</h3>
                        </c:if>
                    </div>
                </div>
            </div>

            <div class="row"><br><br>
                <div class="container">
                <div class="col-md-offset-1">
                    <table class="table table-bordered table-responsive table-striped">
                        <thead>
                            <tr align="center">
                                <th width = "275">Cliente</th>
                                <th width = "100">Data</th>
                                <th width = "50">Mesa</th>
                                <th width = "50">Pedidos</th>
                                <th width = "50">Alterar</th>
                                <th width = "50">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${param.txtFiltro == null}">
<!--                            Pegar todo os pedidos abertos    -->
                                <c:forEach var="p" items="<%=DAO_Generalizado.getList("from Pedido where situacao = 'A'")%>">
                                    <tr class="warning">
                                        <td>${p.cliente}</td>
                                        <td><fmt:formatDate value="${p.dataCadastro}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                        <td>${p.mesa}</td>
                                        <td>
                                            <form name="frm_addItensPedido" action="ItensPedidoJSTL.jsp" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input type="hidden" name="mesa" value="${p.mesa}">
                                                <input class="btn btn-primary" type="submit" value="Pedido" name="bt_addItens"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_alterar" action="PedidoJSTL.jsp" method="POST">
                                                <input type="hidden" name="cod" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input type="hidden" name="cliente" value="${p.cliente.getIdCliente()}">
                                                <input type="hidden" name="mesa" value="${p.mesa}">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirPedidoServlet" method="POST" onsubmit="return confirm('Excluir esse Pedido?')">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                                    <c:forEach var="p" items="<%=DAO_Generalizado.getList("from Pedido where situacao = 'F'")%>">
                                    <tr class="info">
                                        <td>${p.cliente}</td>
                                        <td><fmt:formatDate value="${p.dataCadastro}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                        <td>${p.mesa}</td>
                                        <td>
                                            <form name="frm_addItensPedido" action="ItensPedidoJSTL.jsp" method="POST">
                                                <input class="btn btn-primary" type="submit" value="Pedido" name="bt_addItens" disabled="disabled"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_alterar" action="PedidoJSTL.jsp" method="POST">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar" disabled="disabled"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirPedidoServlet" method="POST" onsubmit="return confirm('Excluir esse Pedido?')">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${param.txtFiltro != null && param.btFiltroCliente != null}">
                                <c:forEach var="p" items="<%=DAO_Generalizado.getList(criteria.CriteriaPedidos.listarPedidos(request.getParameter("txtFiltro"), criteria.CriteriaPedidos.FILTRO_CLIENTE))%>">
                                    <tr class="warning">
                                        <td>${p.cliente}</td>
                                        <td><fmt:formatDate value="${p.dataCadastro}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                        <td>${p.mesa}</td>
                                        <td>
                                            <form name="frm_addItensPedido" action="ItensPedidoJSTL.jsp" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input type="hidden" name="mesa" value="${p.mesa}">
                                                <input class="btn btn-primary" type="submit" value="Pedido" name="bt_addItens"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_alterar" action="PedidoJSTL.jsp" method="POST">
                                                <input type="hidden" name="cod" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input type="hidden" name="cliente" value="${p.cliente.getIdCliente()}">
                                                <input type="hidden" name="mesa" value="${p.mesa}">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirPedidoServlet" method="POST" onsubmit="return confirm('Excluir esse Pedido?')">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${param.txtFiltro != null && param.btFiltroMesa != null}">
                                <c:forEach var="p" items="<%=DAO_Generalizado.getList(criteria.CriteriaPedidos.listarPedidos(request.getParameter("txtFiltro"), criteria.CriteriaPedidos.FILTRO_MESA))%>">
                                    <tr class="warning">
                                        <td>${p.cliente}</td>
                                        <td><fmt:formatDate value="${p.dataCadastro}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                        <td>${p.mesa}</td>
                                        <td>
                                            <form name="frm_addItensPedido" action="ItensPedidoJSTL.jsp" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input type="hidden" name="mesa" value="${p.mesa}">
                                                <input class="btn btn-primary" type="submit" value="Pedido" name="bt_addItens"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_alterar" action="PedidoJSTL.jsp" method="POST">
                                                <input type="hidden" name="cod" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input type="hidden" name="cliente" value="${p.cliente.getIdCliente()}">
                                                <input type="hidden" name="mesa" value="${p.mesa}">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirPedidoServlet" method="POST" onsubmit="return confirm('Excluir esse Pedido?')">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${param.txtFiltro != null && param.btFiltroData != null}">
                                <c:forEach var="p" items="<%=DAO_Generalizado.getList(criteria.CriteriaPedidos.listarPedidos(request.getParameter("txtFiltro"), criteria.CriteriaPedidos.FILTRO_DATA))%>">
                                    <tr class="warning">
                                        <td>${p.cliente}</td>
                                        <td><fmt:formatDate value="${p.dataCadastro}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                        <td>${p.mesa}</td>
                                        <td>
                                            <form name="frm_addItensPedido" action="ItensPedidoJSTL.jsp" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input type="hidden" name="mesa" value="${p.mesa}">
                                                <input class="btn btn-primary" type="submit" value="Pedido" name="bt_addItens"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_alterar" action="PedidoJSTL.jsp" method="POST">
                                                <input type="hidden" name="cod" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input type="hidden" name="cliente" value="${p.cliente.getIdCliente()}">
                                                <input type="hidden" name="mesa" value="${p.mesa}">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirPedidoServlet" method="POST" onsubmit="return confirm('Excluir esse Pedido?')">
                                                <input type="hidden" name="codigo" value="${p.idPedido}">
                                                <input type="hidden" name="nome" value="${p.cliente}">
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>
                </div>
                </div>
            </div>
        </div>
    </body>
</html>
