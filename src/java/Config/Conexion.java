/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

/**
 *
 * @author chris
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    
        
    private final String usuario= "root";
    private final String password="";
    private final String host="localhost";
    private final String nombre_db="bd";
    
    private Connection con=null;
    
    public Connection getcon(){
        getConexionMySQL();
        return con;
    }
    
    public void setcon(Connection con ){
        this.con = con;
    }
    //Metodo que devuleve la conexxion 
    public Connection getConexionMySQL (){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String servidor="jdbc:mysql://"+host+"/"+nombre_db;
            con=DriverManager.getConnection(servidor, usuario, password);
            return con;
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
            return con;
        }
        
    }
    
    public void cerrarBDA() throws SQLException{
        this.con.close();
    }

}
