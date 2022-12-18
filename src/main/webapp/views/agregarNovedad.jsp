<%@page import="Models.Novedad"%>
<%@page import="database.NovedadDao"%>
<%@include file="/views/partials/header.jsp" %>

<main>
    <div class="CajaLogin">
    <div class="login">
        <h3>Nueva Novedad</h3>
        <form method="post" action="/ProyectoFinal/Novedad/agregarNovedad">
            <div class="campo">
                <label for="name">Titulo </label>
                <input type="text" id="name" name="titulo" value="" placeholder="Título" required="required"
                    autofocus />
            </div>
            <div class="campo">
                <label for="date">Fecha </label>
                <input type="date" id="date" name="fecha" value="" 
                    required="required" />
            </div>
            
            <label >Contenido </label>
            </p>
            <div class="campo">
               
                <textarea type="text" id="contenido" name="contenido" value="" rows="45" cols="35" required="required"></textarea>
            </div>

            <div class="boton">
                <input type="submit" value="guardar" class="btn-enviar" name="enviar"/>
            </div>
        </form>
    </div>
</div>
  
    
</main>
<%@include file="/views/partials/footer.jsp" %>

