
package edu.ejercicios;

import edu.vehiculos.Deportivo;
import edu.vehiculos.Furgoneta;
import edu.vehiculos.Turismo;
import edu.vehiculos.Vehiculo;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ej9 {

    public static void main(String[] args) {
       
        /*
        Realiza una modificación sobre el programa del ejercicio 7
        para que divida la única lista de objetos Vehiculo en tres
        listas específicas de objetos Turismo, Deportivo y Furgoneta.
        Una vez generadas las tres listas, guarda en tres ficheros
        CSV (*.csv) los vehículos correspondientes a cada lista,
        separando cada campo usando el carácter delimitador punto y
        coma (;). Abre los ficheros CSV usando un programa de hoja de cálculo,
        indicando que la separación de campos se realiza usando ;, y comprueba
        que cada campo se encuentra en una columna diferente.
        */
        
        ArrayList<Vehiculo> lista = new ArrayList<>();
        ArrayList<Turismo> turismos = new ArrayList<>();
        ArrayList<Deportivo> deportivos = new ArrayList<>();
        ArrayList<Furgoneta> furgonetas = new ArrayList<>();
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
                
                linea = linea.replaceAll(",", ".");
                
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

        
        for (Vehiculo v : lista) {
            if(v instanceof Turismo){
                turismos.add((Turismo) v);
            } else if (v instanceof Deportivo){
                deportivos.add((Deportivo) v);
            } else if (v instanceof Furgoneta){
                furgonetas.add((Furgoneta) v);
            }
        }
        
        escribirCSVTurismo(turismos, "turismos.csv");
        escribirCSVDeportivo(deportivos, "deportivos.csv");
        escribirCSVFurgoneta(furgonetas, "furgoneta.csv");
        
    }
    
    public static void escribirCSVTurismo(ArrayList<Turismo> lista, String ruta){
        
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = ruta;

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < lista.size(); i++) {
                if(i < lista.size()-1){
                    flujo.write(lista.get(i).toString() + ";");
                } else{
                    flujo.write(lista.get(i).toString());
                }
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void escribirCSVDeportivo(ArrayList<Deportivo> lista, String ruta){
        
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = ruta;

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < lista.size(); i++) {
                if(i < lista.size()-1){
                    flujo.write(lista.toString());
                } else{
                    flujo.write(lista.toString() + ";");
                }
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void escribirCSVFurgoneta(ArrayList<Furgoneta> lista, String ruta){
        
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = ruta;

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (int i = 0; i < lista.size(); i++) {
                if(i < lista.size()-1){
                    flujo.write(lista.toString());
                } else{
                    flujo.write(lista.toString() + ";");
                }
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
