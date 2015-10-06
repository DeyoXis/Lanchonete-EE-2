/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lanchonete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author info206
 */
@WebServlet(name = "cadastrar", urlPatterns = {"/cadastrar"})
public class cadastrar extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String connectionURL = "jdbc:mysql://127.0.0.1/lanchonete";
        String User = "root";
        String Pass = "123456";    
        
        
        String nomeclientes = request.getParameter("nomeclientes");    
        String senhaclientes = request.getParameter("senhaclientes");    
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String pedido = request.getParameter("pedido");
        
        Connection connection = null;
        Statement statement = null;
       
        
        Class.forName("com.mysql.jdbc.Driver");   
        
        try {
            
            connection = DriverManager.getConnection(connectionURL, User, Pass);
            statement = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO clientes VALUES(?,?,?,?,?,?)");
            
            stmt.setInt(1, 0);  
            stmt.setString(2, nomeclientes);       
            stmt.setString(3, senhaclientes); 
            stmt.setString(4, telefone);     
            stmt.setString(5, endereco); 
            stmt.setString(6, pedido);
            stmt.executeUpdate();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher ("sucesso.jsp");  
    dispatcher.forward(request, response); 
    
        }  catch (SQLException e) {
            out.println("Erro no Sql" + e.getMessage());

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
            Logger.getLogger(cadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
            Logger.getLogger(cadastrar.class.getName()).log(Level.SEVERE, null, ex);
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
