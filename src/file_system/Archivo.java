
package file_system;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Esteban
 */
public class Archivo extends Estructura{

    
    
    private final int ID;
    private final String tipo;
    private String contenido;
    private int tamaño;
    private Date fecha_creacion;
    private Date fecha_Ultima_Modificacion;
    
    public Archivo(String nombre, int ID, String tipo,  String contenido, Date fecha_creacion) {
        super.nombre = nombre;
        this.ID = ID;
        this.tipo = tipo;
        this.contenido = contenido;
        this.tamaño = contenido.length();
        this.fecha_creacion = fecha_creacion;
        this.fecha_Ultima_Modificacion = fecha_creacion;
    }

//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
    
    public int getID() {
        return ID;
    }


    public String getTipo() {
        return tipo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_Ultima_Modificacion() {
        return fecha_Ultima_Modificacion;
    }

    public void setFecha_Ultima_Modificacion(Date fecha_Ultima_Modificacion) {
        this.fecha_Ultima_Modificacion = fecha_Ultima_Modificacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
    
    
}
