/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lanchonete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael Pereira
 */
@WebServlet(name = "consultar", urlPatterns = {"/consultar"})
public class consultar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Class.forName("com.mysql.jdbc.Driver");   

        String connectionURL = "jdbc:mysql://127.0.0.1/lanchonete";
        String User = "root";
        String Pass = "123456"; 
        
        
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        
        try {
            
            connection = DriverManager.getConnection(connectionURL, User, Pass);
            statement = connection.createStatement();
            
            
            rs = statement.executeQuery("SELECT * FROM clientes");
            
            out.println("<table border='2'>");
            
                out.println("<tr>");
            
                out.println("<td COLSPAN=5 ALIGN=MIDDLE BGCOLOR=#FF6347><b>Tabela de Pedido</b></td>");
                
                out.println("</tr>");
                
                out.println("<tr>");
                
                out.println("<td ALIGN=MIDDLE WIDTH=150 BGCOLOR=#FF6347><b>Nome</b></td>");
                
                out.println("<td ALIGN=MIDDLE WIDTH=150 BGCOLOR=#FF6347><b>Telefone</b></td>");
                
                out.println("<td ALIGN=MIDDLE WIDTH=150 BGCOLOR=#FF6347><b>Endereço</b></td>");
                
                out.println("<td ALIGN=MIDDLE WIDTH=150 BGCOLOR=#FF6347><b>Pedido</b></td>");
            
                out.println("</tr>");
                
            while (rs.next()) {
                out.println("<tr>");
                
                out.println("<td ALIGN=MIDDLE>" + rs.getString ("nomeclientes") + "</td>");
                
                out.println("<td ALIGN=MIDDLE>" + rs.getString ("telefone") + "</td>");
                
                out.println("<td ALIGN=MIDDLE>" + rs.getString ("endereco") + "</td>");
                
                out.println("<td ALIGN=MIDDLE>" + rs.getString ("pedido") + "</td>");
                
                
            }
            
            out.println("</table>");
            
            rs.close();
            
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
