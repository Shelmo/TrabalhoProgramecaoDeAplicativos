<%-- 
    Document   : CategoriaJSTL
    Created on : 19/09/2016, 20:56:44
    Author     : Shelmo
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro Categoria</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="scripts/FuncoesControleCadastro.js"></script>
    </head>
    <body>
        <form class="form-horizontal" name="categoria" action="CategoriaServlet" method="POST">
            <div class="container-fluid center-block">
                <div class="jumbotron">
                    <h1 align="center">Categoria</h1>
                </div>
                <div class="row">
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-4">
                            <label class="label label-primary">Nome</label>
                            <c:if test="${param.nome != null}">
                                <input class="form-control" type="text" name="txtNome" value="${param.nome}" required maxLength="255"/>
                            </c:if>
                            <c:if test="${param.nome == null}">
                                <input class="form-control" type="text" name="txtNome" value="" placeholder="Categoria..." required maxLength="255"/>
                            </c:if>
                            <c:if test="${param.cod != null}">
                                <input type="hidden" name="txtCod" value="${param.cod}"/>
                            </c:if>
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
                                <br><a class="btn btn-info" href="ListaCategoriaJSTL.jsp">Voltar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
