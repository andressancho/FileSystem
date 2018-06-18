
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
        static String ruta = "C:/";
        static ArrayList<String> rutas = new ArrayList();



    public static void main(String[] args) throws IOException {
        int idArchivos = 1;
        rutaActual= new ArrayList();
        Directorio folder= new Directorio("TEC");
        Directorio d=new Directorio("Reque");
        d.getLista().add(new Archivo("Examen.doc",1,"doc","",new Date()));
        folder.getLista().add(new Directorio("Sistemas Operativos"));
        folder.getLista().add(new Directorio("Aseguramiento"));
        folder.getLista().add(new Directorio("Redes"));

        

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
            memoria.ImprimirMemoria();
            while(true){
                String comando = reader.next().toLowerCase();
                switch (comando){

                    case "fle":
                        //ingreso de datos
                        int posicion = rutaActual.size();
                        BufferedReader readerF = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del archivo:");
                        String nombreA = reader.next();
                        if(posicion == 0){
                            if(memoria.inList(nombreA)){
                                System.out.println("Ya existe un archivo con ese nombre");
                                imprimirRuta();
                                break;
                            }
                        }
                        else{
                            if(rutaActual.get(posicion -1).inList(nombreA)){
                                System.out.println("Ya existe un archivo con ese nombre");
                                imprimirRuta();
                                break;
                            }
                        }
                        
                        System.out.println("Ingrese la extension del archivo:");
                        String tipo = reader.next();
                        System.out.println("Ingrese el contenido:");
                        String contenido = readerF.readLine();
                        //creación de Archivo
                        
                                
                                
                        
                        Archivo nuevoA = new Archivo(nombreA,idArchivos,tipo,contenido,new Date());
                        
                        if(memoria.EspaciosDisponibles(nuevoA.getTamaño())){
                            nuevoA.setEnlaces(memoria.llenarEspacios(nuevoA.getID(), nuevoA.getTamaño()));
                            idArchivos++;
                            if (posicion == 0)
                            memoria.addArchivo(nuevoA);
                            else
                            rutaActual.get(posicion-1).addArchivo(nuevoA);
                            
                            memoria.ImprimirMemoria();
                            System.out.println("Archivo creado");
                        }
                        else{
                            System.out.println("no hay espacio suficiente");
                            
                        }
                     
                        imprimirRuta();
                        break;
                        
                        
                            
                    case "mkdir":
                        reader1 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del directorio:");
           
                        String nombreD = reader1.readLine();
                        posicion = rutaActual.size();
                        Directorio nuevoD = new Directorio(nombreD);
                        if (posicion == 0)
                            memoria.addDirectorio(nuevoD);
                        else
                            rutaActual.get(posicion-1).addDirectorio(nuevoD);
                        
                        System.out.println("Directorio creado");

                        imprimirRuta();
                        break;
                    case "chdir":
                        System.out.println("Ingrese el nombre del directorio que quiere abrir:");
                        String nombreQ = reader.next();
                        posicion = rutaActual.size();
                        if("..".equals(nombreQ)){
                            rutaActual.remove(posicion-1);
                            imprimirRuta();
                            break;
                        }
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
                        imprimirRuta();
                        break; 
                    case "ldir":
                        listDir();
                        break;
                    case "mfle":
                        reader1 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del archivo:");
                        String nombre_archivo = reader1.readLine();
                        reader = new Scanner(System.in);
                        System.out.println("Ingrese el nuevo contenido:");
                        String cont = reader1.readLine();
                        modifyFile(nombre_archivo, cont);
                        memoria.ImprimirMemoria();

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
                        break;
                    case "tree":
                        tabs=0;
                        tree(memoria.getEstructuras());
                        imprimirRuta();
                        break;
                    case "find":
                        ruta = "C:/";
                        rutas = new ArrayList();
                        reader1 = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Ingrese el nombre del archivo o directorio:");
                        String nombre_archivo_4 = reader1.readLine();
                        find(nombre_archivo_4,memoria.getEstructuras()); 
                        for(String s: rutas){
                            System.out.println(s);
                        }
                        imprimirRuta();
                        break;

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
        Archivo a=null;
        for(Estructura e: actual){
            if(e instanceof Archivo){
               if(e.nombre.equals(nombre)){
                    existe_archivo = true;
                    a = (Archivo) e;
                    

                }
            }
           
        }
        
        if(!existe_archivo){
            System.out.println("No existe un archivo con ese nombre");
        }
        else{
            memoria.liberarEspacios(a.getEnlaces());
            if(memoria.EspaciosDisponibles(contenido.length())){
                a.setContenido(contenido);
                a.setFecha_Ultima_Modificacion(new Date());
                a.setEnlaces(memoria.llenarEspacios(a.getID(), contenido.length()));
                System.out.println("Archivo modificado con exito");
                
            }
            else{
                System.out.println("No se encontró espacio");
            }
            
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
            
            
            if(!existe_archivo){
                System.out.println("No existe un archivo con ese nombre");
            }
            else{
                
                actual.remove(temporal);
                
                if(temporal instanceof Archivo){
                    memoria.liberarEspacios(((Archivo) temporal).getEnlaces());
                }
                else{
                    Directorio d= (Directorio)temporal;
                    for(Estructura e: d.getLista()){
                        if(e instanceof Archivo){
                            memoria.liberarEspacios(((Archivo) e).getEnlaces());
                        }
                        else{
                            
                            eliminar((Directorio)e);
                        }
                    }
                }
                
                System.out.println("Archivo eliminado");
            }
            imprimirRuta();
        }
    
    public static void eliminar(Directorio directorio){
        for(Estructura e: directorio.getLista()){
            if(e instanceof Archivo){
                memoria.liberarEspacios(((Archivo) e).getEnlaces());
            }
            else{ 
                Directorio d=(Directorio)e;
                eliminar(d);
            }
        }
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
    
    public static void find(String nombre, ArrayList<Estructura> estructuras){
        for(Estructura e:estructuras){
            String first = nombre.substring(0, 1);
            if(first.equals("*")){
               if(e instanceof Archivo){
                    Archivo a = (Archivo)e;
                    if(nombre.substring(2).equals(a.getTipo())){
                        System.out.println("Archivo:" + a.getNombre());
                        find(a.getNombre(),estructuras);
                    }
                }
            }
            
            if(e.nombre.equals(nombre)){
                rutas.add(ruta);
            }
            if(e instanceof Directorio){
                String temp = ruta;
                ruta += e.nombre + "/";
                find(nombre,((Directorio) e).getLista());
                ruta = temp;
            }
            
        }
      
    }
}
