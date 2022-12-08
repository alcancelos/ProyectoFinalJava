
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <nav>
            <div class="dropdown">
                <button class="dropbtn"><i class="fas fa-bars"></i></button>
                <div class="dropdown-content">
                <% if((boolean)session.getAttribute("isLogin") == true){%>
                    <a href="/ProyectoFinal/index.jsp">Home</a>
                    <a href="/ProyectoFinal/index.jsp">Logout</a>
                    <a href="/ProyectoFinal/views/novedades.jsp">Novedades</a>

                    <% } else { %>
                    <a href="/ProyectoFinal/index.jsp">Home</a>
                    <a href="/ProyectoFinal/views/login.jsp">Login</a>
                    <a href="/ProyectoFinal/views/novedades.jsp">Novedades</a>
                    <% } %>

                </div>
              
            </div>
        </nav>