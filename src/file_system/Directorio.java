
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
    
}