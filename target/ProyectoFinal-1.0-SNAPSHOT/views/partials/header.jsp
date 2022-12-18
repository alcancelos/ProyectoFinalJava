<%-- 
    Document   : header
    Created on : 7 dic. 2022, 16:31:19
    Author     : alcan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>

<head>
    <title>Tablón de novedades</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
   <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
        integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel='stylesheet' href='/ProyectoFinal/css/styles.css' />
</head>

<body>
    <div id="Contenido">
        <header>
            <a href="/ProyectoFinal">
            <img class="Logo" src="/ProyectoFinal/images/LogoBlanco.png" alt="Op"></a>
            <h1>Jurídico Contable</h1>
            
        </header>  
       
       <%@include file="/views/partials/nav.jsp" %>