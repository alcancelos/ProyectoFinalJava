<%-- 
    Document   : novedades
    Created on : 7 dic. 2022, 21:07:52
    Author     : alcan
--%>

<%@page import="database.NovedadDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Models.Novedad"%>
<%@page import="config.Conexion"%>
<%@page import="java.sql.*"%>
<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@include file="/views/partials/header.jsp" %>

<main>
    <div class="Novedades">
         <% if((boolean)session.getAttribute("isLogin") == false){%>
         <div class="CajaLogin"><div class="login">
                 <h3>Inicie sesión para poder agregar, borrar y editar las novedades</h3>
             </div>
         </div>
         <%}%>
         <% if((int)session.getAttribute("novedadBorrada") == 1){%>
         <div class="CajaLogin"><div class="login">
                 <h3>Novedad borrada con éxito.</h3>
             </div>
         </div>
         <% session.setAttribute("novedadBorrada",0); %>
         <%}%>
         
         <!-- comment -->
        <!--  Muestra el boton solo si está logueado-->
        <% if((boolean)session.getAttribute("isLogin")){%>
        <div class="boton">
            <a href="/ProyectoFinal/views/agregarNovedad.jsp" class="btnBlue"><i class="fa fa-plus"></i> Nueva Novedad </a>
        </div><%} 
        %>
    <%
    List<Novedad> novedades = (List<Novedad>)session.getAttribute("novedades");
    %>
        <% for(Novedad novedad: novedades) { %>
        <div class="Novedad">
            <h3><%= novedad.getTitulo() %></h3>
             <!-- Solo muestra la botonera si está logueado-->
             <% if((boolean)session.getAttribute("isLogin")){%>
            <div class="botonera">
            <div class="boton">
                <a href="/ProyectoFinal/Novedad/verNovedad?id=<%= novedad.getId_novedad() %>" class="btnGreen"><i class="fas fa-pencil-alt"></i></a>
            </div>
            <div class="boton">
                
                <a href="/ProyectoFinal/Novedad/eliminarNovedad?id=<%= novedad.getId_novedad() %>" class="btnRed"><i class="fa fa-trash"></i></a>
            </div>
            </div><%}%>
            <h4>
                <%=novedad.getFecha()
                    
                %>
             </h4>      
            <p><%= novedad.getContenido() %></p>
        </div>
       <% } %>
        
       
    </div>
  
</main>
<%@include file="/views/partials/footer.jsp" %>
