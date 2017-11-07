/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Diego
 */
public class cBD {

    private final String url,user, contra, driver;
    private Statement sta;
    private CallableStatement call;
    private Connection con;
    private ResultSet rs;

    public cBD() {
        this.driver ="com.mysql.jdbc.Driver";
        this.url="jdbc:mysql://localhost/smartdatabase";
        this.user="root";
        this.contra="n0m3l0";
    }
    
    public Connection conectar() throws Exception{
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url, user,contra);
        return con;
    }
    public String Registrar( Connection conec,String usuario,String avt,String rol, String nombre, String apaterno, String amaterno, String tel,String email, String pass, String likes) throws Exception{
        String exist ="";
        String username="";
        call = conec.prepareCall("{call registrarusuario(?,?,?,?,?,?,?,?,?,?)}");
        call.setString(1, usuario);
        call.setString(2, avt);
        call.setString(3, rol);
        call.setString(4, nombre);
        call.setString(5, apaterno);
        call.setString(6, amaterno);
        call.setString(7, tel);
        call.setString(8, email);
        call.setString(9, pass);
        call.setString(10, likes);
        try{
            rs= call.executeQuery();
            while(rs.next()){
                username= rs.getString("Error");
            }
        }catch(SQLException e){
            //NOTHING
        }
        if(username.equals("Este nombre de usuario ya existe")){
            exist = "si";
        }
        else{
            exist= "no";
        }
        return exist;
    }
    
    public ResultSet buscar(Statement sta,String usuario) throws Exception{
        rs = sta.executeQuery("SELECT idUsuario,contraseña,Nombre FROM usuario WHERE idUsuario ='" + usuario + "'");
        return rs;
        
    }

}
