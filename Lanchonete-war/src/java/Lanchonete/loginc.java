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
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "loginc", urlPatterns = {"/loginc"})
public class loginc extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String connectionURL = "jdbc:mysql://127.0.0.1/lanchonete";
        String User = "root";
        String Pass = "123456";
        
        
        String nomeclientes = request.getParameter("nomeclientes");    
        String senhaclientes = request.getParameter("senhaclientes");
        
        
        Connection connection = null;
        ResultSet rs = null;       
        Class.forName("com.mysql.jdbc.Driver");
        
        try {
            
             connection = DriverManager.getConnection(connectionURL, User, Pass);
            PreparedStatement stmt = connection.prepareStatement("select * from clientes where nomeclientes=? and senhaclientes=?");
            
          
            stmt.setString(1, nomeclientes);
            stmt.setString(2, senhaclientes);
            rs = stmt.executeQuery();
            
                        
             if (rs.next()) {
                 
                  out.print("Seja Be Vindo");
                
                 RequestDispatcher dispatcher = request.getRequestDispatcher ("Pedidos.jsp");  
    dispatcher.forward(request, response); 
                
            } else {
                
                out.print("Acesso Negado, nome e senha não conferem");
                
            }
           
        } finally {            
            out.close();
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
            Logger.getLogger(loginc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(loginc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(loginc.class.getName()).log(Level.SEVERE, null, ex);
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
