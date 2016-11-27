<%-- 
    Document   : ClienteJSTL
    Created on : 19/10/2016, 23:28:32
    Author     : Shelmo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Cliente</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="scripts/FuncoesControleCadastro.js"></script>
    </head>
    <body>
        <form class="form-horizontal" name="cliente" action="ClienteServlet" method="POST">

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
                    <h3 align="center">Cliente</h3><br>
                </div>

                <%-- Dados pessoais --%>
                <div class="row">
                    <div class="col-md-offset-3">
                        <div class="form-group">
                            <%-- Nome --%>
                            <div class="col-md-4">
                                <label class="label label-primary">Nome</label>
                                <c:if test="${param.nome != null}">
                                    <input class="form-control" type="text" name="txtNome" value="${param.nome}" placeholder="Cliente..." required maxLength="255"/>
                                </c:if>
                                <c:if test="${param.nome == null}">
                                    <input class="form-control" type="text" name="txtNome" value="" placeholder="Cliente..." required maxLength="255"/>
                                </c:if>
                            </div>
                            <%-- CPF --%>
                            <div class="col-md-2">
                                <label class="label label-primary">CPF</label>
                                <c:if test="${param.cpf != null}">
                                    <input class="form-control" type="text" name="txtCPF" value="${param.cpf}" placeholder="XXX.XXX.XXX-XX" title="XXX.XXX.XXX-XX" onkeypress="mascara(this, cpf)" pattern="^\d{3}.\d{3}.\d{3}-\d{2}$" required maxLength="14"/>
                                </c:if>
                                <c:if test="${param.cpf == null}">
                                    <input class="form-control" type="text" name="txtCPF" value="" placeholder="XXX.XXX.XXX-XX" title="XXX.XXX.XXX-XX" onkeypress="mascara(this, cpf)" pattern="^\d{3}.\d{3}.\d{3}-\d{2}$" required maxLength="14"/>
                                </c:if>
                            </div>
                            <%-- Data de Nascimento --%>
                            <div class="col-md-2">
                                <div class="col-md-11">
                                    <label class="label label-primary">Data de Nascimento</label>
                                    <c:if test="${param.dataNasc != null}">
                                        <input class="form-control" type="text" name="txtDataNasc" value="${param.dataNasc}" placeholder="XX/XX/XXXX" title="XX/XX/XXXX" onkeypress="mascara(this, data)" pattern="^\d{2}/\d{2}/\d{4}$" required maxLength="10"/>
                                    </c:if>
                                    <c:if test="${param.dataNasc == null}">
                                        <input class="form-control" type="text" name="txtDataNasc" value="" placeholder="XX/XX/XXXX" title="XX/XX/XXXX" onkeypress="mascara(this, data)" pattern="^\d{2}/\d{2}/\d{4}$" required maxLength="10"/>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <%-- Endereço --%>
                <div class="row">
                    <div class="col-md-offset-2">
                        <div class="form-group">
                            <%-- Cidade --%>
                            <div class="col-md-3">
                                <label class="label label-primary">Cidade</label>
                                <c:if test="${param.cidade != null}">
                                    <input class="form-control" type="text" name="txtCidade" value="${param.cidade}" placeholder="Cidade..." maxLength="255"/>
                                </c:if>
                                <c:if test="${param.cidade == null}">
                                    <input class="form-control" type="text" name="txtCidade" value="" placeholder="Cidade..." maxLength="255"/>
                                </c:if>
                            </div>

                            <%-- Bairro --%>
                            <div class="col-md-3">
                                <label class="label label-primary">Bairro</label>
                                <c:if test="${param.bairro != null}">
                                    <input class="form-control" type="text" name="txtBairro" value="${param.bairro}" placeholder="Bairro..." maxLength="255"/>
                                </c:if>
                                <c:if test="${param.bairro == null}">
                                    <input class="form-control" type="text" name="txtBairro" value="" placeholder="Bairro..." maxLength="255"/>
                                </c:if>
                            </div>

                            <%-- Rua --%>
                            <div class="col-md-3">
                                <label class="label label-primary">Rua</label>
                                <c:if test="${param.rua != null}">
                                    <input class="form-control" type="text" name="txtRua" value="${param.rua}" placeholder="Rua..." maxLength="255"/>
                                </c:if>
                                <c:if test="${param.rua == null}">
                                    <input class="form-control" type="text" name="txtRua" value="" placeholder="Rua..." maxLength="255"/>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-offset-2">
                        <div class="form-group">
                            <%-- Número --%>
                            <div class="col-md-2">
                                <label class="label label-primary">Número</label>
                                <c:if test="${param.numero != null}">
                                    <input class="form-control" type="text" name="txtNumero" value="${param.numero}" placeholder="S/N" onkeypress="mascara(this, soNumeros)" maxlength="6"/>
                                </c:if>
                                <c:if test="${param.numero == null}">
                                    <input class="form-control" type="text" name="txtNumero" value="" placeholder="S/N" onkeypress="mascara(this, soNumeros)" maxlength="6"/>
                                </c:if>
                            </div>

                            <%-- Complemento --%>
                            <div class="col-md-5">
                                <label class="label label-primary">Complemento</label>
                                <c:if test="${param.complemento != null}">
                                    <input class="form-control" type="text" name="txtComplemento" value="${param.complemento}" placeholder="Complemento..." maxLength="255"/>
                                </c:if>
                                <c:if test="${param.complemento == null}">
                                    <input class="form-control" type="text" name="txtComplemento" value="" placeholder="Complemento..." maxLength="255"/>
                                </c:if>
                            </div>

                            <%-- CEP --%>
                            <div class="col-md-2">
                                <label class="label label-primary">CEP</label>
                                <c:if test="${param.cep != null}">
                                    <input class="form-control" type="text" name="txtCEP" value="${param.cep}" placeholder="XX.XXX-XXXX" title="XX.XXX-XXXX" pattern="^\d{2}.\d{3}-\d{3}$" onkeypress="mascara(this, cep)" maxLength="10"/>
                                </c:if>
                                <c:if test="${param.cep == null}">
                                    <input class="form-control" type="text" name="txtCEP" value="" placeholder="XX.XXX-XXX" title="XX.XXX-XXXX" pattern="^\d{2}.\d{3}-\d{3}$" onkeypress="mascara(this, cep)" maxLength="10"/>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

                <%-- Contato --%>
                <div class="row">
                    <div class="col-md-offset-2">
                        <div class="form-group">
                            <%-- Telefone --%>
                            <div class="col-md-2">
                                <label class="label label-primary">Telefone</label>
                                <c:if test="${param.fone != null}">
                                    <input class="form-control" type="text" name="txtFone" value="${param.fone}" placeholder="(XX) XXXX-XXXX" pattern="^(+\d{2}) \d{4}-\d{4}$" onkeypress="mascara(this, telefone)" maxLength="14"/>
                                </c:if>
                                <c:if test="${param.fone == null}">
                                    <input class="form-control" type="text" name="txtFone" value="" placeholder="(XX) XXXX-XXXX" pattern="^(+\d{2}) \d{4}-\d{4}$" onkeypress="mascara(this, telefone)" maxLength="14"/>
                                </c:if>
                            </div>

                            <%-- Celular --%>
                            <div class="col-md-2">
                                <label class="label label-primary">Celular</label>
                                <c:if test="${param.celular != null}">
                                    <input class="form-control" type="text" name="txtCelular" value="${param.celular}" placeholder="(XX) XXXX-XXXX" pattern="^(+\d{2}) \d{4}-\d{4}$" onkeypress="mascara(this, telefone)" maxLength="14"/>
                                </c:if>
                                <c:if test="${param.celular == null}">
                                    <input class="form-control" type="text" name="txtCelular" value="" placeholder="(XX) XXXX-XXXX" pattern="^(+\d{2}) \d{4}-\d{4}$" onkeypress="mascara(this, telefone)" maxLength="14"/>
                                </c:if>
                            </div>

                            <%-- E-mail --%>
                            <div class="col-md-5">
                                <label class="label label-primary">E-mail</label>
                                <c:if test="${param.email != null}">
                                    <input class="form-control" type="email" name="txtEmail" value="${param.email}" placeholder="exemple@exemple@.com" maxLength="255"/>
                                </c:if>
                                <c:if test="${param.email == null}">
                                    <input class="form-control" type="email" name="txtEmail" value="" placeholder="exemple@exemple@.com" maxLength="255"/>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

                <%-- Botões --%>
                <div class="row">
                    <div class="form-group">
                        <div align="center">
                            <br>
                            <input class="btn btn-primary" type="submit" value="Enviar" name="btEnviar" />
                            <input class="btn btn-default" type="reset" value="Limpar" name="btLimpar" />
                            <div class="row">
                                <br><a class="btn btn-info" href="ListaClienteJSTL.jsp">Voltar</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
