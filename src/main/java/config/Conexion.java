
package config;
import java.sql.*;
import Models.*;
import java.util.*; 

public class Conexion {
    
    
     // Conexion a la BBDD
        String server = "localhost";
        String puerto = "3306";
        String bbdd = "tpfinal";
        String url = "jdbc:mysql://" + server + ":" + puerto + "/";
        String usuario = "root";
        String password = "1234";
        
        private static final String URL = "jdbc:mysql://localhost:3306/tpfinal";
        private static final String USER = "root";
        private static final String PASS = "1234";
        
        public static Connection getConexion() throws SQLException, ClassNotFoundException{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USER,PASS);           
        }
        
        public static void cerrar(ResultSet rs) throws SQLException{
            rs.close();
        }
        
        public static void cerrar(PreparedStatement ps) throws SQLException{
            ps.close();
        }
        
         public static void cerrar(Connection conn) throws SQLException{
            conn.close();
        }
          
}
