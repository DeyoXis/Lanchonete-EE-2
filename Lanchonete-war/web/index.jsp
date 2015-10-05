<%-- 
    Document   : index
    Created on : 02/10/2015, 16:30:54
    Author     : info206
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Header.jsp"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link href="css/Style.css" rel="stylesheet" type="text/css">
    </head>
    <body>


    <div id="amarelo" align="center">
        <img src="Imagem/amarelo3.png" width="90%">
    </div>


    <div id="Venha" align="center">
        <font face="Segoe Print" size="8">Cadastro</font>
    </div>  

    <div id="branco3" align="center">
    <img src="Imagem/Branco3.png" width="90%">
    </div>

    <br />  
    <br />  
    <br />  
    <br />
        <form action="cadastrar" method="POST">  
  
     
            <div id="cadastro">  
                 
                
                    Nome:  
                    <input type="text" size="30" name="nomeclientes"><br /><br />                
                 
                
                  
                    Senha:
                    <input type="text" size="30" name="senhaclientes"><br /><br />  
                  
                
               
                    Telefone:  
                    <input type="text" size="30" name="telefone"><br /><br />   
                  
                 
                  
                    Endereço:  
                    <input type="text" size="30" name="endereco"><br /><br />  
                  
                
                  
                    <input type="reset" value="Limpar dados"> </td>  
                    <input type="submit" value="Enviar dados"></td>  
                     
                  
            </div>
 </form>
    
            
            <div id="botaologin"><a href="logincliente.jsp">
                <font size="3px">LOGIN</font></p>
            </a></div>
    
    
    
<jsp:include page="Footer.jsp"/>