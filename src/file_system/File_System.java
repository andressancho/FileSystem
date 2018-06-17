
package file_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class File_System {
    
        static ArrayList<Directorio> rutaActual;
        static Disco memoria;

    
    public static void main(String[] args) throws IOException {
        
        rutaActual= new ArrayList();
        Directorio folder= new Directorio("nuevo");
        folder.getLista().add(new Directorio("Sistemas Operativos"));
        folder.getLista().add(new Directorio("Aseguramiento"));
        folder.getLista().add(new Directorio("Redes"));
        folder.getLista().add(new Archivo("Asignacion 1.py",1,"codigo",200,"",null,null));
        folder.getLista().add(new Archivo("Asignacion 2.py",1,"codigo",200,"",null,null));
        folder.getLista().add(new Archivo("Asignacion 2.py",1,"codigo",200,"",null,null));
        
        rutaActual.add(folder);
        
        System.out.println("File System");
        System.out.println("Use el comando \"crt\"");
        Scanner reader = new Scanner(System.in);
        if ("crt".equals(reader.next().toLowerCase())){
            System.out.println("Indique el tamaño de sector:");
            int tam = reader.nextInt();
            System.out.println("Indique la cantidad de sectores:");
            int cant = reader.nextInt();
            memoria = new Disco("C",cant,tam);
            imprimirRuta();
            while(true){
                String comando = reader.next().toLowerCase();
                switch (comando){
                    case "fle": ;
                    case "mkdir": ;
                    case "chdir": ; 
                    case "ldir":
                        listDir();
                        break;
                    case "mfle":
                        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del archivo:");
                        String nombre_archivo = reader1.readLine();
                        reader = new Scanner(System.in);
                        System.out.println("Ingrese el nuevo contenido:");
                        String contenido = reader1.readLine();
                        modifyFile(nombre_archivo, contenido);
                    case "ppt": ;
                    case "view": ; 
                }
            }
        }
        
    }
    
    public static void listDir(){
        if (!rutaActual.isEmpty()){
            ArrayList<Estructura> actual= rutaActual.get(rutaActual.size()-1).getLista();
        
            for(Estructura e: actual){
                System.out.println(e.nombre);
            }
        }
        imprimirRuta();
        
    }
    
    public static void imprimirRuta(){
        String ruta= "C:";
        for(Directorio d: rutaActual){
            ruta+="/";
            ruta+=d.nombre;
        }
        ruta+="> ";
        System.out.print(ruta);
    }
    
    public static void modifyFile(String nombre, String contenido){
        ArrayList<Estructura> actual;
        boolean existe_archivo = false;
        
        if(!rutaActual.isEmpty()){
            actual= rutaActual.get(rutaActual.size()-1).getLista();
        }
        else{
            actual= memoria.getEstructuras();
        }
        
        for(Estructura e: actual){
            if(e instanceof Archivo){
               if(e.nombre.equals(nombre)){
                    existe_archivo = true;
                    Archivo a = (Archivo) e;
                    a.setContenido(contenido);
                }
            }
           
        }
        
        if(!existe_archivo){
            System.out.println("No existe un archivo con ese nombre");
        }
        else{
            System.out.println("Archivo modificado con exito");
        }
        imprimirRuta();
    }  
}
