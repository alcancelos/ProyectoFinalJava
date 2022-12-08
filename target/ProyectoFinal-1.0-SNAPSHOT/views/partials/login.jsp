<%-- 
    Document   : login
    Created on : 7 dic. 2022, 16:45:30
    Author     : alcan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <div class="CajaLogin">
    <div class="login">
        <h3>Ingrese el nombre de usuario y Contraseña</h3>
        <form method="post" action="/usuario/loginUser">
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
