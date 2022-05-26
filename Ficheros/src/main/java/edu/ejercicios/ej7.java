
package edu.ejercicios;

import edu.vehiculos.Deportivo;
import edu.vehiculos.Furgoneta;
import edu.vehiculos.Turismo;
import edu.vehiculos.Vehiculo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ej7 {

    public static void main(String[] args) {
        
        /* Realiza un programa que lea los datos del ejercicio 4. Para ello 
         creará una lista de objetos de tipo Vehículo. El programa irá 
         almacenando en la lista los objetos leídos desde el archivo de texto 
         “vehículos.txt”. Una vez cargados todos los datos en la lista, ordena 
         los vehículos por Marca y muestra el resultado por consola.*/
        
        ArrayList<Vehiculo> lista = new ArrayList<>();
        String idFichero = "vehiculos.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            // Mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                //Se lee la línea
                linea = datosFichero.nextLine();
                
                //Teniendo en cuenta el separador quitando los 4 primeros caracteres
                tokens = linea.substring(4).split(":"); 
                
               
                
                switch (linea.charAt(0)) {
                    case '0':
                        
                        lista.add(new Turismo(Integer.valueOf(tokens[6]),Boolean.valueOf(tokens[7]),Long.valueOf(tokens[0]), tokens[1],tokens[2],tokens[3],tokens[4],Double.valueOf(tokens[5])));
                        
                        break;
                    case '1':
                        
                        lista.add(new Deportivo(Integer.valueOf(tokens[6]),Long.valueOf(tokens[0]), tokens[1],tokens[2],tokens[3],tokens[4],Double.valueOf(tokens[5])));
                        
                        break;
                    default:
                        
                        lista.add(new Furgoneta(Integer.valueOf(tokens[6]),Integer.valueOf(tokens[7]),Long.valueOf(tokens[0]), tokens[1],tokens[2],tokens[3],tokens[4],Double.valueOf(tokens[5])));
                        
                        break;
                }
                
                

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Comparator<Vehiculo> ordenaPorMarca = (v1, v2) -> v1.getMarca().compareTo(v2.getMarca());
        Collections.sort(lista, ordenaPorMarca);
        
        System.out.println(lista);
        
    }
    
    public static ArrayList<Vehiculo> leerFicheroScanner(String fichero) {
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
                // Guarda la línea completa en un String
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
    
}
