
package Models;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Novedad {
    private int id_novedad;
    private java.sql.Date fecha;
    private String titulo;
    private String contenido;

    public Novedad() {
    }

    public Novedad(int id_novedad) {
        this.id_novedad = id_novedad;
    }

    public Novedad(java.sql.Date fecha, String titulo, String contenido) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    
    public Novedad(int id_novedad, java.sql.Date fecha, String titulo, String contenido) {
        this.id_novedad = id_novedad;
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public Novedad(String titulo, String contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }
    
    

    public int getId_novedad() {
        return id_novedad;
    }

    public void setId_novedad(int id_novedad) {
        this.id_novedad = id_novedad;
    }

    public String getFecha() {
      LocalDate ld = this.fecha.toLocalDate();
     DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String formattedDate = ld.format(myFormatObj);
     return formattedDate;
    }
    
    public java.sql.Date GetLocalDate(){
        return this.fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Novedad{");
        sb.append("id_novedad=").append(id_novedad);
        sb.append(", fecha=").append(fecha);
        sb.append(", titulo=").append(titulo);
        sb.append(", contenido=").append(contenido);
        sb.append('}');
        return sb.toString();
    }
    
}
