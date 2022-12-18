/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alejandro.proyectofinal;

import Models.Novedad;
import config.Conexion;
import database.NovedadDao;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author alcan
 */
public class app {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       Conexion.getConexion();
       System.out.println("Conexion exitosa");
       
       NovedadDao novedadDao = new NovedadDao();
       List<Novedad> novedades = novedadDao.ObtenerNovedades();
       for(Novedad novedad: novedades){
           System.out.println(novedad);
       }
       
       Novedad nov = novedadDao.ObtenerNovedadById(3);
        System.out.println(nov.getContenido());
//        insertar REGISTRO
//        ---------------
//       Novedad nov = new Novedad("Prueba","Esto es una prueba");
//       int registro = novedadDao.Insertar(nov);
//       
//        System.out.println("Se insertó "+registro +" registro");
       

//        EDITAR REGISTRO
//        ---------------
//        String str="2022-12-31";  
//        Date date=Date.valueOf(str);//converting string into sql date  
//        Novedad nov = new Novedad(4,date,"Prueba Editada","Esto es una prueba Editada");
//       int registro=novedadDao.Editar(nov);
//       
//       System.out.println("Se editó " + registro +" registro");

//       ELIMINAR REGISTRO
//       -----------------
//         Novedad nov = new Novedad(8);
//         int registro = novedadDao.Eliminar(nov);
//         System.out.println("Se eliminó " + registro +" registro");
         
    }
}
