
<%@page import="Models.Novedad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
            <%
                boolean isLogin;
                boolean error;
                String nombre;
                
                if(session.isNew()){
                session.setAttribute("isLogin", false);
                session.setAttribute("error",false);
                session.setAttribute("novedadBorrada",0);
                session.setAttribute("nov",null);
                }
                isLogin=(boolean)session.getAttribute("isLogin");  
                error=(boolean)session.getAttribute("error");
                if(isLogin==true){
                nombre=(String)session.getAttribute("nombre");
                }
            %>
        <nav>
            <div class="dropdown">
                <button class="dropbtn"><i class="fas fa-bars"></i></button>
                <div class="dropdown-content">
                
                    <a href="/ProyectoFinal/index.jsp" style="display: initial">Home</a>
                    <a href="/ProyectoFinal/usuario/logout" style="display: <%= !isLogin?"none":"initial"%>" >Logout</a>
                    <a href="/ProyectoFinal/views/loginPage.jsp" style="display: <%= isLogin?"none":"initial"%>">Login</a>
                    <a href="/ProyectoFinal/Novedad/obtenerNovedades"style="display: initial">Novedades</a>

                  

                </div>
              
            </div>
        </nav>