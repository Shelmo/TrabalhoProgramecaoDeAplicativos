<%-- 
    Document   : ListaCategoriaJSTL
    Created on : 16/10/2016, 20:06:07
    Author     : Shelmo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.DAO_Generalizado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Categorias</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="scripts/FuncoesControleCadastro.js"></script>
    </head>
    <body>
        <div class="container-fluid center-block">
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
                <h3 align="center">Categorias</h3><br>
            </div>

            <form class="form-horizontal" name="categoria" action="ListaCategoriaJSTL.jsp" method="POST">
                <div class="row">
                    <div class="col-md-offset-1 col-md-4">
                        <div class="input-group">
                            <input type="text" name="txtFiltro" class="form-control" onkeyup="maxCaractere(this, 255)" placeholder="Filtrar por..."/>
                            <div class="input-group-btn">
                                <button type="submit" class="btn btn-primary">Filtrar</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-offset-5 col-md-2">
                        <div class="form-group">
                            <a class="btn btn-success" href="CategoriaJSTL.jsp">Nova Categoria</a>
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
                                <h3>A categoria ${param.nomeIncluido} foi adicionada!</h3>
                            </c:if>
                            <c:if test="${param.idCategoria != null}">
                                <h4>A categoria ${param.nomeIncluido} foi alterada!</h4>
                            </c:if>
                        </c:if>
                        <c:if test="${param.catExcNome != null}">
                            <h3>A categoria ${param.catExcNome} foi excluida!</h3>
                        </c:if>
                    </div>
                </div>
            </div>

            <div class="row"><br><br>
                <div class="col-md-offset-4">
                    <table class="table-bordered table-responsive table-striped">
                        <thead>
                            <tr align="center">
                                <th width = "400">Categoria</th>
                                <th width = "50">Alterar</th>
                                <th width = "50">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${param.txtFiltro == null}">
                                <c:forEach var="c" items="<%=DAO_Generalizado.getList("from Categoria")%>">
                                    <tr>
                                        <td>${c.nomeCategoria}</td>
                                        <td>
                                            <form name="frm_alterar" action="CategoriaJSTL.jsp" method="POST">
                                                <input type="hidden" name="codigo" value="${c.idCategoria}">
                                                <input type="hidden" name="nome" value="${c.nomeCategoria}">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirCategoriaServlet" method="POST" onsubmit="return confirm('Excluir essa Categoria?')">
                                                <input type="hidden" name="codigo" value="${c.idCategoria}">
                                                <input type="hidden" name="nome" value="${c.nomeCategoria}">
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${param.txtFiltro != null}">
                                <c:forEach var="c" items="<%=DAO_Generalizado.getList(criteria.CriteriaCategoria.listarCategorias(request.getParameter("txtFiltro")))%>">
                                    <tr>
                                        <td>${c.nomeCategoria}</td>
                                        <td>
                                            <form name="frm_alterar" action="AlterarCategoriaServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${c.idCategoria}">
                                                <input type="hidden" name="nome" value="${c.nomeCategoria}">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirCategoriaServlet" method="POST" onsubmit="return confirm('Excluir essa Categoria?')">
                                                <input type="hidden" name="codigo" value="${c.idCategoria}">
                                                <input type="hidden" name="nome" value="${c.nomeCategoria}">
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
