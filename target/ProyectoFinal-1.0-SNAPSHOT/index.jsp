<%-- 
    Document   : index
    Created on : 7 dic. 2022, 16:35:22
    Author     : alcan
--%>



<%@include file="/views/partials/header.jsp" %>
<main>
  <div class="intro">
                <br />
                <h4>CONTADORES PÚBLICOS Y ABOGADOS</h4>
                <p><strong>Tablón de Novedades</strong></p>
                <br />
            </div>
            <div class="Bienvenidos">
                 <% if((boolean)session.getAttribute("isLogin") == false){%>
                <div class="TextoBienvenidos">
                    <h3>Bienvenido al tablón de novedades</h3>
                    <p>Solo los usuarios registrados pueden realizar alta baja
                        y modificación de las novedades en la base de datos.
                        Caso contrario solo se pueden ver las novedades.</p>
                </div><%}else{%>
                <div class="TextoBienvenidos">
                    <h3>Bienvenido al tablón de novedades</h3>
                    <p>Usted ingresó sesión como <strong><%= session.getAttribute("nombre")%> </strong></p>
                    <p>Ya puede acceder al CRUD de novedades</p>
                </div>
                
                
                <%}%>
                <div class="ImagenBienvenidos"><img class="ImagenTarjeta" src="./images/boton2.jpg" alt="OP" /></div>
            </div>  
  
</main>
<%@include file="/views/partials/footer.jsp" %>