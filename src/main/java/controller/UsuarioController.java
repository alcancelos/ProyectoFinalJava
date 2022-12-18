/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Models.Usuario;
import database.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author alcan
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/usuario/*"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String action = request.getPathInfo();
           
           UsuarioDAO udao = new UsuarioDAO();
           HttpSession session = request.getSession();
           Usuario actualUser;
           String logon;
           String password;
           
           switch(action){
               
               case "/loginUser":
                   logon=request.getParameter("usuario");
                   password=request.getParameter("password");
                   //verifica si existe el usuario y pass
                   boolean existeUsuario = udao.login(logon, password);
                   if (existeUsuario) {
                       actualUser=udao.getUserByLogon(logon);
                       session.setAttribute("isLogin", existeUsuario);
                       session.setAttribute("actualUsername", logon);
                       session.setAttribute("error", false);
                       session.setAttribute("nombre",actualUser.getNombre()+" "+actualUser.getApellido() );
                       response.sendRedirect("/ProyectoFinal/index.jsp");
                       
                   }else{
                       session.setAttribute("isLogin", existeUsuario);
                       session.setAttribute("error", true);
                       response.sendRedirect("/ProyectoFinal/views/loginPage.jsp");
                   }
                   
                   break;
               case "/logout":
                   session.setAttribute("isLogin", false);
                   session.setAttribute("actualUsername", "");
                   response.sendRedirect("/ProyectoFinal/index.jsp");
                   break;
           }
           
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
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
