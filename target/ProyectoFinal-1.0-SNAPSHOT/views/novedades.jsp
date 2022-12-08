<%-- 
    Document   : novedades
    Created on : 7 dic. 2022, 21:07:52
    Author     : alcan
--%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@include file="/views/partials/header.jsp" %>

<main>
    <div class="Novedades">
         <% if((boolean)session.getAttribute("isLogin") == true){%>
         <div class="CajaLogin"><div class="login">
                 <h3>Inicie sesión para poder agregar, borrar y editar las novedades</h3>
             </div>
         </div>
         <%}%>
         
         <!-- comment -->
        <!--  Muestra el boton solo si está logueado-->
        <% if((boolean)session.getAttribute("isLogin") == false){%>
        <div class="boton">
            <a href="/admin/novedades/agregar" class="btnBlue"><i class="fa fa-plus"></i> Nueva Novedad </a>
        </div><%} 
        %>
    
        <% for(int i = 0; i < 2; i+=1) { %>
        <div class="Novedad">
            <h3>Titulo</h3>
             <!-- Solo muestra la botonera si está logueado-->
             <% if((boolean)session.getAttribute("isLogin") == false){%>
            <div class="botonera">
            <div class="boton">
                <a href="/admin/novedades/modificar/{{id_novedad}}" class="btnGreen"><i class="fas fa-pencil-alt"></i></a>
            </div>
            <div class="boton">
                <a href="/admin/novedades/eliminar/{{id_novedad}}" class="btnRed"><i class="fa fa-trash"></i></a>
            </div>
            </div><%}%>
            <h4>
                <%
                    LocalDateTime myDateObj = LocalDateTime.now();
                    
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

                    String formattedDate = myDateObj.format(myFormatObj);
                    out.println(formattedDate);
                    
                %>
             </h4>      
            <p>este es el contenido de la novedad</p>
        </div>
       <% } %>
        
       
    </div>
  
</main>
<%@include file="/views/partials/footer.jsp" %>
