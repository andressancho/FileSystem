
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

    public ArrayList<Estructura> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Estructura> lista) {
        this.lista = lista;
    }
    
    
    
}
