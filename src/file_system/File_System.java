
package file_system;

import java.util.ArrayList;
import java.util.Scanner;


public class File_System {

    
    public static void main(String[] args) {
        ArrayList<Estructura> rutaActual;
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
                    case "fle": ;
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
