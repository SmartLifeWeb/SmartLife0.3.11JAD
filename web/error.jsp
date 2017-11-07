<%-- 
    Document   : error
    Created on : 7/11/2017, 07:54:11 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <script>
        <%
                HttpSession sesion = request.getSession();
                String Usuario = (String) sesion.getAttribute("idUsuario");

                if (Usuario != null) {
                    request.getRequestDispatcher("cascaron.jsp").forward(request, response);
                } else {
                    
                    
                }
                

            %>
    </script>
    <body>
        <h2>No se puede</h2>
    </body>
</html>
