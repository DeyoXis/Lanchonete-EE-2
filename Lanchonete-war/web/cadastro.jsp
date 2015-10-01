<%-- 
    Document   : cadastro
    Created on : 27/08/2015, 14:31:14
    Author     : info206
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link href="css/Style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
<jsp:include page="Footer.jsp"/>
<h1>Cadastro</h1>
<br />
 <form action="Cadastrar" method="POST">  
  
            <table>  
                 
                <tr>
                    <td>Nome:</td>  
                    <td><input type="text" size="30" name="nome"></td>                     
                </tr>  
                
                <tr>  
                    <td> Senha:</td>  
                    <td><input type="text" size="30" name="senha"></td>   
                </tr>  
                
                <tr>  
                    <td>Telefone:</td>  
                    <td><input type="text" size="30" name="telefone"></td>  
                </tr>  
                 
                <tr>  
                    <td>Endereço:</td>  
                    <td><input type="text" size="30" name="endereco"></td>  
                </tr>  
                
                <tr>  
                    <td><input type="reset" value="Limpar dados"> </td>  
                    <td><input type="submit" value="Enviar dados"></td>  
                    </tr>  
                  
                      </table>
 </form>
