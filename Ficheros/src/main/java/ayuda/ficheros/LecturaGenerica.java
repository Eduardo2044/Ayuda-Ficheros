
package ayuda.ficheros;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class LecturaGenerica {
    
    //Metodo generico para leer cualquier archivo csv, recibe el nombre del archivo y el separador de campos ";",","...
    //Retorna una lista de objetos de cualquier tipo
    //---Asegurarse de modificar la parte de creacion de objetos
    //Ejemplo de uso: List<Persona> listaPersonas = Lectura.leerArchivo("./personas.csv",";");
    public static <T> List<T> leerCsv(String nombre, String separador) {
        List<T> datos = new ArrayList<>();
        
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        try (Scanner datosFichero = new Scanner(new File(nombre))) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                
                    
                    POJO p = new POJO(); //Creamos el objeto que introduciremos en la lista
                    // Se guarda en el array de String cada elemento de la
                    // línea en función del carácter separador de campos del fichero CSV
                    tokens = linea.split(separador);
                    //Damos valores al objeto con los datos recogidos
                    //En caso de campos vacios lo controlariamos con un if ej. if (!(tokens[6].equals(""))) {Hazlo}
                    p.setApellidos(tokens[0]);
                    p.setNombre(tokens[1]);
                    p.setDni(tokens[2]);
                    p.setPuesto(tokens[3]);
                    p.setTomaDePosesion(LocalDate.parse((tokens[4])));
                    p.setCese(LocalDate.parse((tokens[5])));
                    p.setTelefono(Integer.parseInt((tokens[6])));
                    p.setEvaluador(Boolean.getBoolean((tokens[7])));
                    p.setCoordinador(Boolean.getBoolean((tokens[8])));
                    
                    datos.add((T) p);
                
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return datos;
    }

    //Metodo generico para leer cualquier json, recibe el nombre del archivo y la clase del objeto, y devuelve una lista de objetos de cualquier tipo
    //Ejemplo de uso: List<Persona> listaPersonas = Lectura.leerJson("./personas.json",Persona.class);
    //---Asegurar de tener correctamente las dependecias--
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310 --> (por si hay fechas)
    //JSON: como este --> "https://github.com/yisusturtle/JAVA_PROJECTS/blob/main/CRUD_FILES/Tarea7C-JesusNarbona/JFV.json"
    public static <T> List<T> leerArchivoJSON1(String nombre, Class<T> clase) {
        List<T> datos = new ArrayList<>();
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule()); //para poder manejar fechas

        try {
            datos.addAll(mapeador.readValue(new File(nombre),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, clase)));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return datos;
    }

    //Metodo para leer un archivo JSON contruido por solo un objeto, recibe el nombre del archivo y la clase del objeto, y devuelve un objeto de cualquier tipo
    //Ejemplo de uso: Persona persona = Lectura.leerArchivoJSON2("./persona.json",Persona.class);
    //---Asegurar de tener correctamente las dependecias--
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core -->
    //<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-jsr310 --> (por si hay fechas)
    //JSON: como este --> "" //TODO: cambiar por el url json
    public static <T> T leerArchivoJSON2(String nombre, Class<T> clase) {
        T datos = null;
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule()); //para poder manejar fechas

        try {
            datos = mapeador.readValue(new File(nombre),
                    mapeador.getTypeFactory().constructType(clase));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datos;
    }
    
    public static TreeMap<String,String> leerCsvMapOrdenado(String nombre, String separador) {
        TreeMap<String,String> datos = new TreeMap<>();

        try (Scanner sc = new Scanner(new File(nombre),"UTF-8")) {
            //Para saltar 1a iteración
            //sc.nextLine();
            while (sc.hasNextLine()) {
                //Para saltar 1a iteración
                String linea = sc.nextLine();
                linea = linea.replaceAll(" ", "");
                linea = linea.replaceAll("\"", "");

                String[] datosLinea = linea.split(separador);

                datos.put(datosLinea[0],datosLinea[1]);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return datos;
    }
    
    public static HashMap<String,String> leerCsvMap(String nombre, String separador) {
        HashMap<String,String> datos = new HashMap<>();

        try (Scanner sc = new Scanner(new File(nombre),"UTF-8")) {
            //Para saltar 1a iteración
            //sc.nextLine();
            while (sc.hasNextLine()) {
                //Para saltar 1a iteración
                String linea = sc.nextLine();
                linea = linea.replaceAll(" ", "");
                linea = linea.replaceAll("\"", "");

                String[] datosLinea = linea.split(separador);

                datos.put(datosLinea[0],datosLinea[1]);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return datos;
    }
    
}
