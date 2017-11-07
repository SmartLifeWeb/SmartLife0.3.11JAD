/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registro;

import BD.cBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alumno
 */
public class Inicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("user");
        String contraseña = request.getParameter("contra");
        //Variables de conexion
        cBD conexion = new cBD();
        Connection con = null;
        Statement sta = null;
        ResultSet rs = null;
        String user = "", contra = "", nombre = "";
        

        try {
            con = conexion.conectar();
            sta = con.createStatement();
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            if (usuario.equals("") || contraseña.equals("")) {
                out.println("<script> alert('Usuario y/o contraseña incorrectos'); </script>");
                out.println("<script>location.replace('/SmartLifeWeb/Modulos/InicioSesion/Ingresar.html');</script>");
            } else {
                rs = conexion.buscar(sta, usuario);
            }
            while (rs.next()) {
                user = rs.getString("idUsuario");
                contra = rs.getString("contraseña");
                nombre = rs.getString("Nombre");
            }
            if (contraseña.equals(contra) && usuario.equals(user)) {
                HttpSession sesion = request.getSession();
                //sesion.invalidate();
                sesion.setAttribute("idUsuario", user);
                sesion.setAttribute("Nombre", nombre);
                out.println("<script>location.replace('/SmartLifeWeb/cascaron.jsp');</script>");
                
            } else {
                out.println("<script> alert('Usuario y/o contraseña incorrectos'); </script>");
                out.println("<script>location.replace('/SmartLifeWeb/Modulos/InicioSesion/Ingresar.html');</script>");

            }
            con.close();
        } catch (SQLException error) {
            out.print(error.toString());
        } catch (Exception ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
