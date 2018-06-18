/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file_system;

import java.util.ArrayList;

/**
 *
 * @author esteb
 */
public class Disco {
    private String root;
    private int cantidad;
    private int size;
    private int[][] espacios;
    private ArrayList<Estructura> estructuras;

    public Disco(String root, int cantidad, int tamaño) {
        this.root = root;
        this.cantidad = cantidad;
        this.size = tamaño;
        estructuras = new ArrayList();

        this.espacios = new int[cantidad][tamaño];
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }
    

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTamaño() {
        return size;
    }

    public void setTamaño(int tamaño) {
        this.size = tamaño;
    }

    public int[][] getEspacios() {
        return espacios;
    }

    public void setEspacios(int[][] espacios) {
        this.espacios = espacios;
    }  
    
    public void addArchivo(Archivo a){
        this.estructuras.add(a);
    }
    
    public void addDirectorio(Directorio d){
        this.estructuras.add(d);
    }
    
    public boolean inList(String nombre){
        for(Estructura e: estructuras){
            if(e.getNombre().equals(nombre))
                return true;
        }
        return false;
    }
    
    public Estructura getDir(String nombre){
        for(Estructura e: estructuras){
            if(e.getNombre().equals(nombre))
                return e;
        }
        return null;
    }

    public ArrayList<Estructura> getEstructuras() {
        return estructuras;
    }
    
    

  
    
    
}
