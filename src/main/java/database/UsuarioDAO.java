/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import Models.Usuario;
import static config.Conexion.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alcan
 */
public class UsuarioDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs =null;
    
     public Usuario getUserByLogon(String logon){
        String sql = "SELECT * FROM usuario WHERE logon=?";
        Usuario usuario = null;
        
        try {
            this.conn = getConexion();
            this.ps= this.conn.prepareStatement(sql);
            this.ps.setString(1, logon);
            this.rs=this.ps.executeQuery();
            
            if(this.rs.next()){
             usuario = new Usuario();
             usuario.setNombre(this.rs.getString("nombre"));
             usuario.setApellido(this.rs.getString("apellido"));
             usuario.setEmail(this.rs.getString("email"));
             usuario.setPassword(this.rs.getString("password"));
             
             
             return usuario;
            }
            
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                cerrar(rs);
                cerrar(ps);
                cerrar(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return usuario;
        
        
    }
     
     public boolean login(String logonInput, String passInput) throws SQLException, ClassNotFoundException{
        String sql = "SELECT logon, password FROM usuario WHERE logon=? AND password=? ";
        this.conn = getConexion();
            this.ps= this.conn.prepareStatement(sql);
            this.ps.setString(1, logonInput);
            this.ps.setString(2, passInput);
            this.rs=this.ps.executeQuery();
            
            return rs.next();     
        
    }
}
