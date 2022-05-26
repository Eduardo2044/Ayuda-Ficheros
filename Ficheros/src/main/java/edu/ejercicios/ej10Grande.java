package edu.ejercicios;

import edu.vehiculos.Vehiculo;
import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ej10Grande {

    public static void main(String[] args) {
        
        //Creamos el directorio copias
        crearDirectorio("./copias");
        
        //Copiamos los ficheros turismos, deportivos y furgonetas.csv
        //en la carpeta copias
        copiarFicheros("./turismos.csv", "./copias/turismos.csv");
        copiarFicheros("./deportivos.csv", "./copias/deportivos.csv");
        copiarFicheros("./furgoneta.csv", "./copias/furgoneta.csv");
        
        //Creamos una lista de vehiculos y añadimos los objetos de
        //todos los archivos de la carpeta copias
        
        ArrayList<Vehiculo> vehiculos = leerFicherosCarpeta("./Copias");
        
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }

        List<Vehiculo> lista = vehiculos;
        
//        lista.stream().
//                sorted((v1,v2) -> v1.getBastidor()=v2.getBastidor())
//                .collect(lista.toList())
//                .forEach(System.out::println);
//                //.sorted((v1, v2) -> v1.getBastidor().compareTo(v2.getBastidor()))
//                //.collect(lista.toList())
//                //.forEach(System.out::println);
        
    }

    // Crea un directorio según la ruta especificada
    // Si ya existe o no tiene permisos genera la excepción correspondiente
    // Si hay algún error en la ruta también genera una excepción
    public static void crearDirectorio(String ruta) {
        Path file = Paths.get(ruta);
        try {
            if (!Files.exists(file)) {
                Files.createDirectory(file);
            } else {
                System.out.println("El directorio " + ruta + " ya existe");
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    // Es igual que el método anterior pero crea los directorios intermedios
    // necesarios especificados en la ruta
    // Si el directorio a crear ya existe no hace nada
    public static void crearDirectorios(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectories(directory);
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

    // Este método genera un fichero vacío en la ruta especificada
    public static void crearFichero(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.createFile(file);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (IOException e) {
            System.out.println("Problema creando el archivo " + ruta);
            System.out.println("Probablemente la ruta esté mal escrita.");
        }
    }

    // Este método borra ficheros y directorios de la ruta especificada
    // Si el directorio no está vacío no se borra
    public static void borrarElemento(String ruta) {
        Path file = Paths.get(ruta);
        try {
            Files.delete(file);
        } catch (NoSuchFileException nsfe) {
            System.out.println("No se puede borrar " + ruta + " porque no existe");
        } catch (DirectoryNotEmptyException dnee) {
            System.out.println("No se puede borrar el directorio porque no está vacío");
        } catch (IOException e) {
            System.out.println("Problema borrando el elemento " + ruta);
        }
    }

    // Copiado de ficheros
    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);
        try {
            Files.copy(origen, destino);
        } catch (IOException e) {
            System.out.println("Problema copiando el archivo.");
            System.out.println(e.toString());
        }
    }

    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println(file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }

    // Este método lista directorio especificado en ruta y los subdirectorios
    // Visita toda la jerarquía a partir del directorio "ruta"
    // Usa Api Stream 
    public static void listarTodo(String ruta) {

        try {
            Stream<Path> miStream = Files.walk(Paths.get(ruta));
            miStream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Error listando directorios");
        }
    }
    
    public static ArrayList<Vehiculo> leerFicherosCarpeta(String ruta) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        File f = new File(ruta);
        if (f.exists()) {
            File[] ficheros = f.listFiles();            
            for (File file2 : ficheros) {
                listaVehiculos.addAll(ej7.leerFicheroScanner(file2.getName()));
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
        return listaVehiculos;
    }

}
