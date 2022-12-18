<%-- 
    Document   : login
    Created on : 7 dic. 2022, 20:38:40
    Author     : alcan
--%>

<%@include file="/views/partials/header.jsp" %>
<main>
    <% if((boolean)session.getAttribute("error") == true){%>
    <div class="nota-error">
        <p> Usuario o clave incorrecto</p>
    </div><%}%>
    <div class="nota">
        <p>Utilizar las siguientes credenciales:</p>
        <div>Usuario: admin</div>
        <div>Contraseña: admin</div>
        <p> o....</p>
        <div>Usuario: user</div>
        <div>Contraseña: user</div>
        <p>(O poner cualquier cosa para ver pagina de error)</p>
    </div>
    <div class="CajaLogin">
    <div class="login">
        <h3>Ingrese el nombre de usuario y Contraseña</h3>
        <form method="POST" action="/ProyectoFinal/usuario/loginUser">
            <div class="campo">
                <label for="name">Usuario: </label>
                <input type="text" id="name" name="usuario" value="" placeholder="Usuario" required="required"
                    autofocus />
            </div>
            <div class="campo">
                <label for="pass">Password:</label>
                <input type="password" id="pass" name="password" value="" placeholder="Contraseña"
                    required="required" />
            </div>

            <div class="boton">
                <input type="submit" value="enviar" class="btn-enviar" />
            </div>
        </form>
    </div>
</div>

</main>
<%@include file="/views/partials/footer.jsp" %>
