/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import Models.Novedad;
import static config.Conexion.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NovedadDao {
    
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs =null;
    private Novedad novedad;
    
    public List<Novedad> ObtenerNovedades(){
        String sql = "SELECT * FROM novedad ORDER BY fecha DESC";
        List<Novedad> novedades = new ArrayList<>();
        
        try {
            this.conn = getConexion();
            this.ps= this.conn.prepareStatement(sql);
            this.rs=this.ps.executeQuery();
            
            while(this.rs.next()){
             int id = this.rs.getInt("id_novedad");
             String titulo = this.rs.getString("titulo");
             String contenido = this.rs.getString("contenido");
             java.sql.Date fecha = this.rs.getDate("fecha");
             
             this.novedad= new Novedad(id,fecha,titulo,contenido);
             novedades.add(this.novedad);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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
        
        return novedades;
        
        
    }
    
    public Novedad ObtenerNovedadById(int id){
        String sql = "SELECT * FROM novedad WHERE id_novedad=?";
        Novedad nov = new Novedad();
         try {
            this.conn = getConexion();
            this.ps= this.conn.prepareStatement(sql);
            this.ps.setInt(1,id);
            this.rs=this.ps.executeQuery();
            
            if(this.rs.next()){
             int idNovedad=this.rs.getInt("id_novedad"); 
             String titulo=this.rs.getString("titulo"); 
            String contenido= this.rs.getString("contenido");
             java.sql.Date fecha = this.rs.getDate("fecha");
             
             nov= new Novedad(idNovedad,fecha,titulo,contenido);
             
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
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
         
         return nov;
        
    }
    
    public int Insertar(Novedad novedad){
         
        LocalDate fecha = novedad.GetLocalDate().toLocalDate();
        String sql = "INSERT INTO novedad (titulo,contenido,fecha) VALUES (?,?,?)";
        int registros=0;
        
        try {
            this.conn = getConexion();
            this.ps= this.conn.prepareStatement(sql);
            
            this.ps.setString(1, novedad.getTitulo());
            this.ps.setString(2,novedad.getContenido());
            this.ps.setString(3,fecha.toString());
            registros=this.ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                cerrar(ps);
                cerrar(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
        
    }
     
    public int Editar(Novedad novedad){
         
        
        String sql = "UPDATE novedad SET titulo=?,fecha=?,contenido=? WHERE id_novedad=?";
        int registros=0;
        LocalDate fecha = novedad.GetLocalDate().toLocalDate();
        try {
            this.conn = getConexion();
            this.ps= this.conn.prepareStatement(sql);
            
            this.ps.setString(1, novedad.getTitulo());
            this.ps.setString(2,fecha.toString());
            this.ps.setString(3,novedad.getContenido());
            this.ps.setInt(4,novedad.getId_novedad());
            registros=this.ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                cerrar(ps);
                cerrar(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
        
    }
    
    public int Eliminar(Novedad novedad){
         
        
        String sql = "DELETE FROM novedad WHERE id_novedad=?";
        int registros=0;
        
        try {
            this.conn = getConexion();
            this.ps= this.conn.prepareStatement(sql);
            
            this.ps.setInt(1, novedad.getId_novedad());
            
            registros=this.ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovedadDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try{
                cerrar(ps);
                cerrar(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
        
        
    }
    
    
}
