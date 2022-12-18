<%@page import="Models.Novedad"%>
<%@include file="/views/partials/header.jsp" %>


<main>
    <%
    Novedad nov = (Novedad)session.getAttribute("nov");
    %>
    
    <div class="CajaLogin">
    <div class="login">
        <h3>Modificar Novedad</h3>
        <form method="post" action="/ProyectoFinal/Novedad/editarNovedad">
            <input type="hidden" value="<%= nov.getId_novedad() %>" name="id">
            <div class="campo">
                <label for="name">Titulo </label>
                <input type="text" id="name" name="titulo" value="<%= nov.getTitulo() %>" placeholder="Título" required="required"/>
            </div>
            <div class="campo">
                <label for="date">Fecha </label>
                <input type="date" id="date" name="fecha" value="<%= nov.GetLocalDate()%>" required="required" />
            </div>
            <label>Contenido </label>
            
            <div class="campo">

                <textarea type="text" id="contenido" name="contenido" rows="50" cols="40" required="required"><%= nov.getContenido() %> </textarea>
            </div>

            <div class="boton">
                <input type="submit" value="modificar" class="btn-enviar" />
            </div>
        </form>
    </div>
</div>
  
</main>
<%@include file="/views/partials/footer.jsp" %>