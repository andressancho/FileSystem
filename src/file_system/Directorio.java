
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public void addArchivo(Archivo a){
        this.lista.add(a);
    }
    
    public void addDirectorio(Directorio d){
        this.lista.add(d);
    }

    
    public boolean inList(String nombre){
        for(Estructura e: lista){
            if(e.getNombre().equals(nombre))
                return true;
        }
        return false;
    }
    public Estructura getDir(String nombre){
        for(Estructura e: lista){
            if(e.getNombre().equals(nombre))
                return e;
        }
        return null;
    }
    
}
