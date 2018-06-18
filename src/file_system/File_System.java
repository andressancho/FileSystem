
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
                        //ingreso de datos
                        System.out.println("Ingrese el nombre del archivo:");
                        String nombreA = reader.next();
                        System.out.println("Ingrese la extension del archivo:");
                        String tipo = reader.next();
                        System.out.println("Ingrese el contenido:");
                        String contenido = reader.next();
                        //creación de Archivo
                        Archivo nuevoA = new Archivo(nombreA,idArchivos,tipo,contenido,new Date());
                        
                        
                        int posicion = rutaActual.size();
                        if (posicion == 0)
                            memoria.addArchivo(nuevoA);
                        else
                            rutaActual.get(posicion-1).addArchivo(nuevoA);
                        
                        
                        int tamNuevo = nuevoA.getTamaño();
                        
                        // falta manejo de memoria
                        
                        
                        
                        idArchivos++;
                        System.out.println("Archivo creado");
                        break;
                        
                        
                            
                    case "mkdir":
                        System.out.println("Ingrese el nombre del directorio:");
                        String nombreD = reader.next();
                        posicion = rutaActual.size();
                        Directorio nuevoD = new Directorio(nombreD);
                        if (posicion == 0)
                            memoria.addDirectorio(nuevoD);
                        else
                            rutaActual.get(posicion-1).addDirectorio(nuevoD);
                        
                        System.out.println("Directorio creado");
                        break
                                
                                
                                
                        ;
                        
                        
                        
                    case "chdir":
                        System.out.println("Ingrese el nombre del directorio que quiere abrir:");
                        String nombreQ = reader.next();
                        posicion = rutaActual.size();
                        if (posicion == 0){
                            if(memoria.inList(nombreQ)){
                                Estructura e = memoria.getDir(nombreQ);
                                rutaActual.add((Directorio)e);
                            }
                            else
                                System.out.println("Directorio no exite");
                        }
                        else{
                            if(rutaActual.get(posicion-1).inList(nombreQ)){
                                Estructura e = rutaActual.get(posicion-1).getDir(nombreQ);
                                rutaActual.add((Directorio)e);
                            }
                            else
                                System.out.println("Directorio no exite");
                        }
                        
                            
                        
                        
                        
                        
                        ; 
                    case "ldir": ;
                    case "mfle": ;
                    case "ppt": ;
                    case "view": ; 
                }
            }
        }
        
    }
//    public ArrayList<Integer> EspaciosLibres(Disco disco,int tama){
//        int[][] matriz =disco.getEspacios();
//        
//        while(matriz.)
//        
//        return 
//    }
    
}
