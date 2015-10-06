<%-- 
    Document   : sucesso
    Created on : 06/10/2015, 16:07:19
    Author     : info206
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Header.jsp"/>
<%
            
            String connectionURL = "jdbc:mysql://127.0.0.1/lanchonete";
            String User = "root";
            String Pass = "123456"; 
        
        
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;
            
        %>
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
            <font face="Segoe Print" size="8">Seu pedido foi feito com sucesso!</font>
        </div>  

        <div id="branco3" align="center">
            <img src="Imagem/Branco3.png" width="90%">
        </div>
        
        <div id="consulta2">
            
        <%
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            connection = DriverManager.getConnection(connectionURL, User, Pass);
            statement = connection.createStatement();
            
            
            rs = statement.executeQuery("SELECT * FROM clientes");
            
            out.println("<table border='2'>");
            
                out.println("<tr>");
            
                out.println("<td COLSPAN=5 ALIGN=MIDDLE BGCOLOR=#FF6347><b>Tabela de Pedido</b></td>");
                
                out.println("</tr>");
                
                out.println("<tr>");
                
                out.println("<td ALIGN=MIDDLE WIDTH=150 BGCOLOR=#FF6347><b>Nome</b></td>");
                                                
                out.println("<td ALIGN=MIDDLE WIDTH=150 BGCOLOR=#FF6347><b>Pedido</b></td>");
            
                out.println("</tr>");
                
            while (rs.next()) {
                out.println("<tr>");
                
                out.println("<td ALIGN=MIDDLE>" + rs.getString ("nomeclientes") + "</td>");
                                               
                out.println("<td ALIGN=MIDDLE>" + rs.getString ("pedido") + "</td>");
                
                
            }
            
            out.println("</table>");
            
            rs.close();
        
        
        %>
        
        </div>
        
        
  <jsp:include page="Footer.jsp"/>