/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Models.Novedad;
import database.NovedadDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "NovedadController", urlPatterns = {"/Novedad/*"})
public class NovedadController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String action = request.getPathInfo();
            HttpSession session = request.getSession();
            NovedadDao novedadDao = new NovedadDao();
            int idNovedad;
            int registro;
            Novedad nov;
            List<Novedad> novedades;
            
            switch (action) {
                case "/agregarNovedad":                   
                        String str = request.getParameter("fecha");
                        java.sql.Date fecha = java.sql.Date.valueOf(str);
                        Novedad novedad = new Novedad(
                                fecha,
                                request.getParameter("titulo"),
                                request.getParameter("contenido"));

                        novedadDao.Insertar(novedad);
                        novedades = novedadDao.ObtenerNovedades();
                         session.setAttribute("novedades", novedades);
                        response.sendRedirect("/ProyectoFinal/views/novedades.jsp");
                        break;
                case "/eliminarNovedad":                  
                    idNovedad =Integer.parseInt(request.getParameter("id"));
                    nov = new Novedad(idNovedad);
                    registro = novedadDao.Eliminar(nov);
                    session.setAttribute("novedadBorrada", registro);
                    novedades = novedadDao.ObtenerNovedades();
                    session.setAttribute("novedades", novedades);
                    response.sendRedirect("/ProyectoFinal/views/novedades.jsp");
                    break;
                case "/obtenerNovedades":                  
                    novedades = novedadDao.ObtenerNovedades();
                    session.setAttribute("novedades", novedades);
                    response.sendRedirect("/ProyectoFinal/views/novedades.jsp");
                    break;
                case "/verNovedad":
                    idNovedad = Integer.parseInt(request.getParameter("id"));
                    nov = novedadDao.ObtenerNovedadById(idNovedad);
                    session.setAttribute("nov", nov);
                    
                    
                    response.sendRedirect("/ProyectoFinal/views/modificarNovedad.jsp");
                    break;
                
                 case "/editarNovedad":                  
                    int idNov = Integer.parseInt(request.getParameter("id"));
                     String strDate = request.getParameter("fecha");
                        java.sql.Date fechaSql = java.sql.Date.valueOf(strDate);
                        Novedad novedadEditar = new Novedad(
                                idNov,
                                fechaSql,
                                request.getParameter("titulo"),
                                request.getParameter("contenido"));
                    registro = novedadDao.Editar(novedadEditar);
                    novedades = novedadDao.ObtenerNovedades();
                    session.setAttribute("novedades", novedades);
                    response.sendRedirect("/ProyectoFinal/views/novedades.jsp");
                    break;
                    
                    
                        
            }
            

            
        }

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
