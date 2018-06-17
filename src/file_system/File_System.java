
package file_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class File_System {
    
        static ArrayList<Directorio> rutaActual;
        static Disco memoria;
        static int tabs;

    
    public static void main(String[] args) throws IOException {
        
        rutaActual= new ArrayList();
        Directorio folder= new Directorio("nuevo");
        Directorio d=new Directorio("Reque");
        d.getLista().add(new Archivo("examen.py",1,"py",200,"",new Date(),new Date()));
        folder.getLista().add(d);
        folder.getLista().add(new Directorio("Sistemas Operativos"));
        folder.getLista().add(new Directorio("Aseguramiento"));
        folder.getLista().add(new Directorio("Redes"));

        folder.getLista().add(new Archivo("Asignacion 1.py",1,"py",200,"",null,null));
        folder.getLista().add(new Archivo("Asignacion 2.py",1,"py",200,"",null,null));
        folder.getLista().add(new Archivo("Asignacion 3.py",1,"py",200,"hola",null,null));
        

        rutaActual.add(folder);
        
        
        System.out.println("File System");
        System.out.println("Use el comando \"crt\"");
        Scanner reader = new Scanner(System.in);
        BufferedReader reader1;
        if ("crt".equals(reader.next().toLowerCase())){
            System.out.println("Indique el tamaño de sector:");
            int tam = reader.nextInt();
            System.out.println("Indique la cantidad de sectores:");
            int cant = reader.nextInt();
            memoria = new Disco("C",cant,tam);
            memoria.getEstructuras().add(folder);
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
                        reader1 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del archivo:");
                        String nombre_archivo = reader1.readLine();
                        reader = new Scanner(System.in);
                        System.out.println("Ingrese el nuevo contenido:");
                        String contenido = reader1.readLine();
                        modifyFile(nombre_archivo, contenido);

                        break;

                    case "view": 
                        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del archivo:");
                        String nombre_archivo_2 = reader2.readLine();
                        reader = new Scanner(System.in);
                        viewFile(nombre_archivo_2);
                        break;
                    case "rem":
                        BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del archivo:");
                        String nombre_archivo_3 = reader3.readLine();
                        reader = new Scanner(System.in);
                        removeFile(nombre_archivo_3);
                        break;

                    case "ppt":
                        reader1 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del archivo:");
                        String nombre = reader1.readLine();
                        ppt(nombre); 
                    case "tree":
                        tabs=0;
                        tree(memoria.getEstructuras());
                        imprimirRuta();

                }
            }
        }
        
    }
    
    public static void listDir(){
        ArrayList<Estructura> actual;
        
        if (!rutaActual.isEmpty()){
            actual= rutaActual.get(rutaActual.size()-1).getLista();
        }
        else{
            actual= memoria.getEstructuras();
        }
        for(Estructura e: actual){
                System.out.println(e.nombre);
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

    
    public static void viewFile(String nombre){
        String contenido = "No tiene contenido";
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
                        contenido = a.getContenido();
                    }
                }

            }

            if(!existe_archivo){
                System.out.println("No existe un archivo con ese nombre");
            }
            else{
                System.out.println("Contenido del archivo: " + contenido);
            }
            imprimirRuta();
    }
    
    public static void removeFile(String nombre){
        ArrayList<Estructura> actual;
        Estructura temporal = null;
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
                        temporal = e;
                    }
                }
                //es un directorio
                else{
                    if(e.nombre.equals(nombre)){
                        existe_archivo = true;
                        temporal = e;
                    }
                }
            }
            actual.remove(temporal);
            
            if(!existe_archivo){
                System.out.println("No existe un archivo con ese nombre");
            }
            else{
                System.out.println("Archivo eliminado");
            }
            imprimirRuta();
        }

    public static void ppt(String nombre){
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
                    System.out.println("Nombre: " + a.nombre);
                    System.out.println("Extensión: " + a.getTipo());
                    System.out.println("Fecha de creación: " + a.getFecha_creacion().toString());
                    System.out.println("Fecha de modificación: " + a.getFecha_Ultima_Modificacion().toString());
                    System.out.println("Nombre: " + Integer.toString(a.getTamaño()));
                }
            }
           
        }
        
        if(!existe_archivo){
            System.out.println("No existe un archivo con ese nombre");
        }

        imprimirRuta();
    }
    public static void tree(ArrayList<Estructura> estructuras){
        
        
        for(Estructura e:estructuras){
            for(int x=0;x<tabs;x++){
                System.out.print("\t");
            }
            System.out.println(e.nombre);
            if(e instanceof Directorio){
                tabs+=1;
                
                tree(((Directorio) e).getLista());
            }
            
        }
        tabs-=1;
        
       
    }
}
