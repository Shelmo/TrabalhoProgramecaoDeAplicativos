<%-- 
    Document   : ListaProdutoJSTL
    Created on : 16/10/2016, 11:13:51
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
        <title>Lista de Produtos</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="scripts/FuncoesControleCadastro.js"></script>
        <script type="text/javascript" src="scripts/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid center-block">
            <div class="jumbotron">
                <h1 align="center">Produtos</h1>
            </div>

            <form class="form-horizontal" name="produto" action="ListaProdutoJSTL.jsp" method="POST">
                <div class="row">
                    <div class="col-md-offset-1 col-md-4">
                        <div class="input-group">
                            <input type="text" name="txtFiltro" class="form-control " placeholder="Filtrar por..." onkeyup="maxCaractereFiltro(this.value, 255)"/>
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                        Filtrar <span class="caret"></span></button>
                                <ul class="dropdown-menu">
                                    <li><input type="submit" value="Produto" name="btFiltroProduto" class="btn btn-primary btn-group-justified"/></li>
                                    <li><input type="submit" value="Categoria" name="btFiltroCategoria" class="btn btn-primary btn-group-justified"/></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-offset-5 col-md-2">
                        <div class="form-group">
                            <a class="btn btn-success" href="ProdutoJSTL.jsp">Novo Produto</a>
                            <a class="btn btn-info" href="index.jsp">Voltar</a>
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
                            <c:if test="${param.idCategoria == null}">
                                <h3>O produto ${param.nomeIncluido} foi adicionado!</h3>
                            </c:if>
                            <c:if test="${param.idCategoria != null}">
                                <h4>O produto ${param.nomeIncluido} foi alterado!</h4>
                            </c:if>
                        </c:if>
                        <c:if test="${param.prodExcNome != null}">
                            <h3>O produto ${param.prodExcNome} foi excluido!</h3>
                        </c:if>
                    </div>
                </div>
            </div>

            <div class="row"><br><br>
                <div class="col-md-offset-2">
                    <table class="table-bordered table-responsive table-striped">
                        <thead>
                            <tr align="center">
                                <th width = "200">Produto</th>
                                <th width = "200">Categoria</th>
                                <th width = "100">Valor</th>
                                <th width = "400">Descricao</th>
                                <th width = "50">Alterar</th>
                                <th width = "50">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:if test="${param.txtFiltro == null}">
                                <c:forEach var="p" items="<%=DAO_Generalizado.getList("from Produto")%>">
                                    <tr>
                                        <td>${p.nomeProduto}</td>
                                        <td>${p.categoria}</td>
                                        <td>
                                            R$ 
                                            <fmt:setLocale value="pt_BR"/>
                                            <fmt:formatNumber value="${p.valorProduto}" type="number" minFractionDigits="2"/>
                                        </td>
                                        <td>${p.descricaoProduto}</td>
                                        <td>
                                            <form name="frm_alterar" action="AlterarProdutoServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idProduto}"/>
                                                <input type="hidden" name="nome" value="${p.nomeProduto}"/>
                                                <input type="hidden" name="valor" value="${p.valorProduto}"/>
                                                <input type="hidden" name="descricao" value="${p.descricaoProduto}"/>
                                                <input type="hidden" name="categoria" value="${p.categoria.getIdCategoria()}"/>
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirProdutoServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idProduto}"/>
                                                <input type="hidden" name="nome" value="${p.nomeProduto}"/>
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${param.txtFiltro != null && param.btFiltroProduto != null}">
                                <c:forEach var="p" items="<%=DAO_Generalizado.getList(criteria.CriteriaProduto.listarProdutos(request.getParameter("txtFiltro"), criteria.CriteriaProduto.FILTRO_PRODUTO))%>">
                                    <tr>
                                        <td>${p.nomeProduto}</td>
                                        <td>${p.categoria}</td>
                                        <td>${p.valorProduto}</td>
                                        <td>${p.descricaoProduto}</td>
                                        <td>
                                            <form name="frm_alterar" action="AlterarProdutoServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idProduto}"/>
                                                <input type="hidden" name="nome" value="${p.nomeProduto}"/>
                                                <input type="hidden" name="valor" value="${p.valorProduto}"/>
                                                <input type="hidden" name="descricao" value="${p.descricaoProduto}"/>
                                                <input type="hidden" name="categoria" value="${p.categoria.getIdCategoria()}"/>
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirProdutoServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idProduto}"/>
                                                <input type="hidden" name="nome" value="${p.nomeProduto}"/>
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${param.txtFiltro != null && param.btFiltroCategoria != null}">
                                <c:forEach var="p" items="<%=DAO_Generalizado.getList(criteria.CriteriaProduto.listarProdutos(request.getParameter("txtFiltro"), criteria.CriteriaProduto.FILTRO_CATEGORIA))%>">
                                    <tr>
                                        <td>${p.nomeProduto}</td>
                                        <td>${p.categoria}</td>
                                        <td>${p.valorProduto}</td>
                                        <td>${p.descricaoProduto}</td>
                                        <td>
                                            <form name="frm_alterar" action="AlterarProdutoServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idProduto}"/>
                                                <input type="hidden" name="nome" value="${p.nomeProduto}"/>
                                                <input type="hidden" name="valor" value="${p.valorProduto}"/>
                                                <input type="hidden" name="descricao" value="${p.descricaoProduto}"/>
                                                <input type="hidden" name="categoria" value="${p.categoria.getIdCategoria()}"/>
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirProdutoServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${p.idProduto}"/>
                                                <input type="hidden" name="nome" value="${p.nomeProduto}"/>
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
    </body>
</html>
