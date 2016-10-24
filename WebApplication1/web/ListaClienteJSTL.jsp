<%-- 
    Document   : ClienteJSTL
    Created on : 19/10/2016, 22:47:40
    Author     : Shelmo
--%>

<%@page import="dao.DAO_Generalizado"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Clientes</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="scripts/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container-fluid center-block">
            <div class="jumbotron">
                <h1 align="center">Cliente</h1>
            </div>

            <form class="form-horizontal" name="categoria" action="ListaClienteJSTL.jsp" method="POST">
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
                            <a class="btn btn-success" href="ClienteJSTL.jsp">Novo Cliente</a>
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
                            <c:if test="${param.idCliente == null}">
                                <h3>O registro do cliente ${param.nomeIncluido} foi adicionado!</h3>
                            </c:if>
                            <c:if test="${param.idCliente != null}">
                                <h4>O registro do cliente ${param.nomeIncluido} foi alterado!</h4>
                            </c:if>
                        </c:if>
                        <c:if test="${param.cliExcNome != null}">
                            <h3>O registro do cliente ${param.cliExcNome} foi excluido!</h3>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="row"><br><br>
                <div class="col-md-offset-1">
                    <table class="table-bordered table-responsive table-striped">
                        <thead>
                            <tr align="center">
                                <th width = "175">Cliente</th>
                                <th width = "100">CPF</th>
                                <th width = "100">Cidade</th>
                                <th width = "100">Bairro</th>
                                <th width = "100">Rua</th>
                                <th width = "5">Número</th>
                                <th width = "100">Complemento</th>
                                <th width = "50">CEP</th>
                                <th width = "75">Fone</th>
                                <th width = "75">Celular</th>
                                <th width = "175">E-mail</th>
                                <th width = "75">Data de Nascimento</th>
                                <th width = "50">Alterar</th>
                                <th width = "50">Excluir</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${param.txtFiltro == null}">
                                <c:forEach var="c" items="<%=DAO_Generalizado.getList("from Cliente")%>">
                                    <tr>
                                        <td>${c.nomeCliente}</td>
                                        <td>${c.cpfCliente}</td>
                                        <td>${c.cidadeCliente}</td>
                                        <td>${c.bairroCliente}</td>
                                        <td>${c.ruaCliente}</td>
                                        <td>${c.numeroCliente}</td>
                                        <td>${c.complementoCliente}</td>
                                        <td>${c.cepCliente}</td>
                                        <td>${c.foneCliente}</td>
                                        <td>${c.celularCliente}</td>
                                        <td>${c.emailCliente}</td>
                                        <td><fmt:formatDate value="${c.dataNascimentoCliente}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                        <td>
                                            <form name="frm_alterar" action="AlterarClienteServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${c.idCliente}">
                                                <input type="hidden" name="nome" value="${c.nomeCliente}">
                                                <input type="hidden" name="cpf" value="${c.cpfCliente}">
                                                <input type="hidden" name="cidade" value="${c.cidadeCliente}">
                                                <input type="hidden" name="bairro" value="${c.bairroCliente}">
                                                <input type="hidden" name="rua" value="${c.ruaCliente}">
                                                <input type="hidden" name="numero" value="${c.numeroCliente}">
                                                <input type="hidden" name="complemento" value="${c.complementoCliente}">
                                                <input type="hidden" name="cep" value="${c.cepCliente}">
                                                <input type="hidden" name="fone" value="${c.foneCliente}">
                                                <input type="hidden" name="celular" value="${c.celularCliente}">
                                                <input type="hidden" name="email" value="${c.emailCliente}">
                                                <input type="hidden" name="dataNasc" value="${c.dataNascimentoCliente}">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirClienteServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${c.idCliente}">
                                                <input type="hidden" name="nome" value="${c.nomeCliente}">
                                                <input class="btn btn-primary" type="submit" value="Excluir" name="bt_excluir"/>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                            <c:if test="${param.txtFiltro != null}">
                                <c:forEach var="c" items="<%=DAO_Generalizado.getList(criteria.CriteriaCliente.listaClientes(request.getParameter("txtFiltro")))%>">
                                    <tr>
                                        <td>${c.nomeCliente}</td>
                                        <td>${c.cpfCliente}</td>
                                        <td>${c.cidadeCliente}</td>
                                        <td>${c.bairroCliente}</td>
                                        <td>${c.ruaCliente}</td>
                                        <td>${c.numeroCliente}</td>
                                        <td>${c.complementoCliente}</td>
                                        <td>${c.cepCliente}</td>
                                        <td>${c.foneCliente}</td>
                                        <td>${c.celularCliente}</td>
                                        <td>${c.emailCliente}</td>
                                        <td><fmt:formatDate value="${c.dataNascimentoCliente}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                        <td>
                                            <form name="frm_alterar" action="AlterarClienteServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${c.idCliente}">
                                                <input type="hidden" name="nome" value="${c.nomeCliente}">
                                                <input type="hidden" name="cpf" value="${c.cpfCliente}">
                                                <input type="hidden" name="cidade" value="${c.cidadeCliente}">
                                                <input type="hidden" name="bairro" value="${c.bairroCliente}">
                                                <input type="hidden" name="rua" value="${c.ruaCliente}">
                                                <input type="hidden" name="numero" value="${c.numeroCliente}">
                                                <input type="hidden" name="complemento" value="${c.complementoCliente}">
                                                <input type="hidden" name="cep" value="${c.cepCliente}">
                                                <input type="hidden" name="fone" value="${c.foneCliente}">
                                                <input type="hidden" name="celular" value="${c.celularCliente}">
                                                <input type="hidden" name="email" value="${c.emailCliente}">
                                                <input type="hidden" name="dataNasc" value="${c.dataNascimentoCliente}">
                                                <input class="btn btn-primary" type="submit" value="Alterar" name="bt_alterar"/>
                                            </form>
                                        </td>
                                        <td>
                                            <form name="frm_excluir" action="ExcluirClienteServlet" method="POST">
                                                <input type="hidden" name="codigo" value="${c.idCliente}">
                                                <input type="hidden" name="nome" value="${c.nomeCliente}">
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
