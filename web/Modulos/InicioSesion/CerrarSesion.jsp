<%-- 
    Document   : CerrarSesion
    Created on : 5/11/2017, 06:34:56 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    HttpSession sesion = request.getSession();
    sesion.removeAttribute("idUsuario");
    sesion.removeAttribute("Nombre");
    sesion.invalidate();
   out.println("<script>location.replace('/SmartLifeWeb/Modulos/InicioSesion/Ingresar.html');</script>");
   
   
%>