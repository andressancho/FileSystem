
package file_system;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class File_System {

    
    public static void main(String[] args) {
        int idArchivos = 1;
        ArrayList<Directorio> rutaActual;
        rutaActual = new ArrayList<>();
        Disco memoria;
        System.out.println("File System");
        System.out.println("Use el comando \"crt\"");
        Scanner reader = new Scanner(System.in);
        if ("crt".equals(reader.next().toLowerCase())){
            System.out.println("Indique el tamaño de sector:");
            int tam = reader.nextInt();
            System.out.println("Indique la cantidad de sectores:");
            int cant = reader.nextInt();
            memoria = new Disco("C",cant,tam);
            System.out.println("C:/");
            while(true){
                String comando = reader.next().toLowerCase();
                switch (comando){
                    case "fle":
                        
                        System.out.println("Ingrese el nombre el archivo:");
                        String nombre = reader.next();
                        System.out.println("Ingrese la extension del archivo:");
                        String tipo = reader.next();
                        System.out.println("Ingrese el contenido:");
                        String contenido = reader.next();
                        
                        
                        int posicion = rutaActual.size();
                        Archivo nuevo = new Archivo(nombre,idArchivos,tipo,contenido,new Date());
                        rutaActual.get(posicion-1).addArchivo(nuevo);
                        idArchivos++;
                        nuevo.getTamaño();
                        
                        
                            
                        ;
                    case "mkdir": ;
                    case "chdir": ; 
                    case "ldir": ;
                    case "mfle": ;
                    case "ppt": ;
                    case "view": ; 
                }
            }
        }
        
    }
    
}
