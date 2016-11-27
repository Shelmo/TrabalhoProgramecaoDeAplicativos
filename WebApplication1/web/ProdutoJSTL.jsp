<%-- 
    Document   : ProdutoJSTL
    Created on : 19/09/2016, 21:10:51
    Author     : Shelmo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Categoria"%>
<%@page import="dao.DAO_Generalizado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="scripts/FuncoesControleCadastro.js"></script>
    </head>
    <body>
        <fmt:setLocale value="pt_BR"/>
        <form class="form-horizontal" name="produto" action="ProdutoServlet" method="POST">

            <c:if test="${param.cod != null}">
                <input type="hidden" name="txtCod" value="${param.cod}"/>
            </c:if>

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
                    <h3 align="center">Produto</h3><br>
                </div>

                <div class="row">
                    <div class="col-md-offset-3">
                        <div class="form-group">
                            <div class="col-md-4">
                                <label class="label label-primary">Nome</label>
                                <c:if test="${param.nome != null}">
                                    <input class="form-control" type="text" name="txtNome" value="${param.nome}" placeholder="Produto..." required maxLength="255"/>
                                </c:if>
                                <c:if test="${param.nome == null}">
                                    <input class="form-control" type="text" name="txtNome" value="" placeholder="Produto..." required maxLength="255"/>
                                </c:if>

                            </div>
                            <div class="col-md-3">
                                <label class="label label-primary">Categoria</label>
                                <select class="form-control" name="cbx_categoria">
                                    <c:forEach var="c" items="<%=DAO_Generalizado.getList("from Categoria")%>">
                                        <c:if test="${param.categoria == null}">
                                            <option value="${c.idCategoria}">${c.nomeCategoria}</option>
                                        </c:if>
                                        <c:if test="${param.categoria != null && Integer.parseInt(param.categoria) != c.idCategoria}">
                                            <option value="${c.idCategoria}">${c.nomeCategoria}</option>
                                        </c:if>    
                                        <c:if test="${param.categoria != null && Integer.parseInt(param.categoria) == c.idCategoria}">
                                            <option selected value="${c.idCategoria}">${c.nomeCategoria}</option>
                                        </c:if>  
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-2">
                                <label class="label label-primary">Valor</label>
                                <c:if test="${param.valor != null}">
                                    <input class="form-control" type="text" name="txtValor" value="<fmt:formatNumber value="${param.valor}" type="number" minFractionDigits="2"/>" placeholder="R$" onkeyup="mascara(this, moeda)" required maxLength="14"/>
                                </c:if>
                                <c:if test="${param.valor == null}">
                                    <input class="form-control" type="text" name="txtValor" value="" placeholder="R$" onkeyup="mascara(this, moeda)" required
                                           maxLength="14"/>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-offset-3">
                        <div class="form-group">
                            <div class="col-md-9">
                                <label class="label label-primary">Descrição</label>
                                <c:if test="${param.descricao != null}">
                                    <textarea class="form-control" name="txtDescricao" rows="3" cols="75" placeholder="Descrição..." maxLength="255">${param.descricao}</textarea>
                                </c:if>
                                <c:if test="${param.descricao == null}">
                                    <textarea class="form-control" name="txtDescricao" rows="3" cols="75" placeholder="Descrição..." maxlength="255"></textarea>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <div align="center">
                            <br>
                            <input class="btn btn-primary" type="submit" value="Enviar" name="btEnviar" />
                            <input class="btn btn-default" type="reset" value="Limpar" name="btLimpar" />
                            <div class="row">
                                <br><a class="btn btn-info" href="ListaProdutoJSTL.jsp">Voltar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </form>
    </body>
</html>