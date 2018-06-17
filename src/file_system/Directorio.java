
package file_system;

import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class Directorio extends Estructura {
    private ArrayList<Estructura> lista;

    public Directorio(String nombre) {
        super.nombre = nombre;
        lista = new ArrayList<Estructura>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void addArchivo(Archivo a){
        this.lista.add(a);
    }
    
    
    
}
