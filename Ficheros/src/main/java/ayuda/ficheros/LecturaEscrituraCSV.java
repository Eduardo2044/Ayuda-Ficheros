
package ayuda.ficheros;

import edu.vehiculos.Deportivo;
import edu.vehiculos.Furgoneta;
import edu.vehiculos.Turismo;
import edu.vehiculos.Vehiculo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class LecturaEscrituraCSV {
    
    public static void main(String[] args) {
        
        ArrayList<POJO> lista = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            lista.add(new POJO());
            lista.get(i).setCese(LocalDate.now());
            lista.get(i).setTomaDePosesion(LocalDate.now());
        }
        
        EscrituraGenerica.escribirCsv("PruebaCSV1", lista);
        
        //Hay que modificar el metodo para cada objeto y uso
        //GUARDA LISTA DE OBJETOS
        List<POJO> lisp = LecturaGenerica.leerCsv("PruebaCSV1", ";");
        System.out.println("------ Lista CSV ------");
        lisp.forEach(System.out::println);
        
        //SOLO IMPRIME
        imprimirFicheroLeido("PruebaCSV1", ";");
        
        System.out.println("Sin ordenar");
        HashMap<String, String> mapa = LecturaGenerica.leerCsvMap("mapPrueba", ";");
        mapa.forEach((k,v) -> System.out.println(k + ": " + v));
        
        System.out.println("Ordenado");
        TreeMap<String, String> mapaOrdenado = LecturaGenerica.leerCsvMapOrdenado("mapPrueba", ";");
        mapaOrdenado.forEach((k,v) -> System.out.println(k + ": " + v));
        
    }
    
    public static void imprimirFicheroLeido(String ruta, String separador){ // Ej ruta = "Ejemplo.csv"
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + ruta);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(ruta), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(separador);
                for (String string : tokens) {
                    System.out.print(string + "\t");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void escribirFichero(String ruta){ // Ej escritura matriz GENERICO
        
        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
                
            //SUELE IR UN BUCLE QUE ENGLOBA DESDE AQUÍ ******
                /*
                    LÓGICA DE ESCRITURA DEL ARCHIVO
                    SEGÚN EL EJERCICIO
                */

                // Metodo newLine() añade salto de línea después de cada fila
                // DESPUÉS DE LA LECTURA DE CADA ELEMENTO PARA AÑADIR UN SALTO DE LÍNEA
                flujo.newLine();
            //HASTA AQUÍ ******
            
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + ruta + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void escribirFicheroEj(String ruta){ // Ej escritura matriz NO GENERICO
        String tmp;
        // Array a escribir
        int matrizNumeros[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        
        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(ruta))) {
            for (int i = 0; i < matrizNumeros.length; i++) {
                for (int j = 0; j < matrizNumeros[i].length; j++) {
                    // Obtengo en un String el elemento int de la matriz
                    tmp = String.valueOf(matrizNumeros[i][j]);
                    // Si es el último de la fila no pone la coma
                    if (j == matrizNumeros[i].length - 1) {
                        // Usamos metodo write() para escribir en el buffer
                        flujo.write(tmp);
                    }else{
                        flujo.write(tmp + ",");
                    }
                }
                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + ruta + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void escrituraVehiculosEj(String idFichero, ArrayList lista) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        //idfichero
        ArrayList<Vehiculo> listaAEscribir = lista;

        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            //Cabecero
            flujo.write("TipoVehiculo:Matricula:Marca:Modelo:Color:Precio:Bastidor:Disponible");
            flujo.newLine();
            for (Vehiculo vehiculo : listaAEscribir) {
                if (vehiculo instanceof Furgoneta) {
                    // Usamos metodo write() para escribir en el buffer
                    flujo.write("0 - :" + ((Furgoneta) vehiculo).toString());
                } else if (vehiculo instanceof Deportivo) {
                    flujo.write("1 - :" + ((Deportivo) vehiculo).toString());
                } else {
                    flujo.write("2 - :" + ((Turismo) vehiculo).toString());
                }
                // Metodo newLine() añade línea en blanco
                flujo.newLine();
            }
            // Usamos metodo write() para escribir en el buffer
            // Metodo newLine() añade línea en blanco
            // Metodo flush() guarda cambios en disco 
            flujo.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static ArrayList<Vehiculo> leerFicheroVehiculosEj(String fichero) {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();

        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero CSV: " + fichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(fichero), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            //Omitimos la primera linea
            datosFichero.nextLine();

            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un Stringç
                linea = datosFichero.nextLine();
                //remplazamos todas las comillas que haya en las lineas que se lean
                linea = linea.replace("\"", "");
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(":");
                for (String string : tokens) {
                    if (tokens[0].contains("0")) {
                        Furgoneta furgo = new Furgoneta();
                        furgo.setBastidor(Long.parseLong(tokens[1]));
                        furgo.setMatricula(tokens[2]);
                        furgo.setMarca(tokens[3]);
                        furgo.setModelo(tokens[4]);
                        furgo.setColor(tokens[5]);
                        furgo.setTarifa(Double.parseDouble(tokens[6]));
                        furgo.setCarga(Integer.parseInt(tokens[8]));
                        furgo.setVolumen(Integer.parseInt(tokens[9]));
                        listaVehiculos.add(furgo);
                        break;
                    } else if (tokens[0].contains("1")) {
                        Deportivo depor = new Deportivo();
                        depor.setBastidor(Long.parseLong(tokens[1]));
                        depor.setMatricula(tokens[2]);
                        depor.setMarca(tokens[3]);
                        depor.setModelo(tokens[4]);
                        depor.setColor(tokens[5]);
                        depor.setTarifa(Double.parseDouble(tokens[6]));
                        depor.setCilindrada(Integer.parseInt(tokens[8]));
                        listaVehiculos.add(depor);
                        break;
                    } else {
                        Turismo turis = new Turismo();
                        turis.setBastidor(Long.parseLong(tokens[1]));
                        turis.setMatricula(tokens[2]);
                        turis.setMarca(tokens[3]);
                        turis.setModelo(tokens[4]);
                        turis.setColor(tokens[5]);
                        turis.setTarifa(Double.parseDouble(tokens[6]));
                        turis.setPuertas(Integer.parseInt(tokens[8]));
                        turis.setMarchaAutomatica(Boolean.parseBoolean(tokens[9]));
                        listaVehiculos.add(turis);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return listaVehiculos;
    }
    
    public static ArrayList<POJO> leerFicheroPOJOEj(String ruta){
        //Variables
        ArrayList<POJO> lista = new ArrayList<>();
        int totalLineas = 0;
        int totalProfesores = 0;    
        
        //Formato Fecha
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        
        System.out.println("Leyendo el fichero: " + ruta);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(ruta), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                totalLineas++;
                linea = linea.replaceAll("\"", "");
                if (totalLineas > 1) {
                    totalProfesores++;
                    POJO p = new POJO(); //Creamos el objeto que introduciremos en la lista
                    // Se guarda en el array de String cada elemento de la
                    // línea en función del carácter separador de campos del fichero CSV
                    tokens = linea.split(",");
                    //Damos valores al objeto con los datos recogidos
                    p.setApellidos(tokens[0]);
                    p.setNombre(tokens[1]);
                    p.setDni(tokens[2]);
                    p.setPuesto(tokens[3]);
                    p.setTomaDePosesion(LocalDate.parse((tokens[4]), formato));
                    //Usamos la barra invertida (que es el caracter de escape de java)
                    //para poder usar las comillas dobles sin que estas hagan su función normal
                    if (!(tokens[5].equals(""))) {
                        p.setCese(LocalDate.parse((tokens[5]), formato));
                    }
                    if (!(tokens[6].equals(""))) {
                        p.setTelefono(Integer.parseInt((tokens[6])));
                    }
                    p.setEvaluador(Boolean.getBoolean((tokens[7])));
                    p.setCoordinador(Boolean.getBoolean((tokens[8])));
                    
                    lista.add(p);
                }
            }
            System.out.println("Los profesores son los siguientes: ");
            for (POJO pojo : lista) {
                System.out.println(pojo.toString());
            }
            System.out.println("Y el total de empleados es: " + totalProfesores);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return lista;
    }
    
}
