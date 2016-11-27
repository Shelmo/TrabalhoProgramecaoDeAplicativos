<%-- 
    Document   : PedidoJSTL
    Created on : 20/10/2016, 20:40:12
    Author     : Shelmo
--%>

<%@page import="dao.DAO_Generalizado"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Pedido</title>
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <form class="form-horizontal" name="cliente" action="PedidoServlet" method="POST">

            <c:if test="${param.cod != null}">
                <input type="hidden" name="txtCod" value="${param.cod}"/>
                <input type="hidden" name="nome" value="${param.nome}"/>
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
                    <h3 align="center">Pedido</h3><br>
                </div>

                <div class="row">
                    <div class="col-md-offset-4">
                        <div class="form-group">
                            <div class="col-md-3">
                                <label for="cbx_cliente" class="label label-primary">Cliente</label>
                                <select class="form-control" name="cbx_cliente">
                                    <c:forEach var="c" items="<%=DAO_Generalizado.getList("from Cliente")%>">
                                        <c:if test="${param.cliente == null}">
                                            <option value="${c.idCliente}">${c.nomeCliente}</option>
                                        </c:if>
                                        <c:if test="${param.cliente != null && Integer.parseInt(param.cliente) != c.idCliente}">
                                            <option value="${c.idCliente}">${c.nomeCliente}</option>
                                        </c:if>    
                                        <c:if test="${param.cliente != null && Integer.parseInt(param.cliente) == c.idCliente}">
                                            <option selected value="${c.idCliente}">${c.nomeCliente}</option>
                                        </c:if>  
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-md-3">
                                <label for="txtMesa" class="label label-primary">Mesa</label>
                                <c:if test="${param.mesa != null}">
                                    <input class="form-control" type="text" name="txtMesa" value="${param.mesa}" required maxLength="100"/>
                                </c:if>
                                <c:if test="${param.mesa == null}">
                                    <input class="form-control" type="text" name="txtMesa" value="" placeholder="Mesa..." required maxLength="100"/>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <div align="center">
                            <br>
                            <input class="btn btn-primary btn-md" type="submit" value="Enviar" name="btEnviar" />
                            <input class="btn btn-default btn-md" type="reset" value="Limpar" name="btLimpar" />
                            <div class="row">
                                <br><a class="btn btn-info" href="index.jsp">Voltar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
