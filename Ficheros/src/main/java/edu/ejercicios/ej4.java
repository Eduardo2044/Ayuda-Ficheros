package edu.ejercicios;

import edu.vehiculos.Deportivo;
import edu.vehiculos.Furgoneta;
import edu.vehiculos.Turismo;
import edu.vehiculos.Vehiculo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ej4 {

    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.addAll(generarTurismos(10));
        vehiculos.addAll(generarDeportivos(10));
        vehiculos.addAll(generarFurgonetas(10));

        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "vehiculos.txt";

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {

            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo instanceof Turismo) {
                    // Usamos metodo write() para escribir en el buffer
                    flujo.write("0 - " + ((Turismo) vehiculo).toString());
                    // Metodo newLine() añade salto de línea después de cada fila
                    flujo.newLine();
                } else if (vehiculo instanceof Deportivo) {
                    // Usamos metodo write() para escribir en el buffer
                    flujo.write("1 - " + ((Deportivo) vehiculo).toString());
                    // Metodo newLine() añade salto de línea después de cada fila
                    flujo.newLine();
                } else if (vehiculo instanceof Furgoneta){
                    // Usamos metodo write() para escribir en el buffer
                    flujo.write("2 - " + ((Furgoneta) vehiculo).toString());
                    // Metodo newLine() añade salto de línea después de cada fila
                    flujo.newLine();
                }
            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static ArrayList<Vehiculo> generarTurismos(int numVehiculos) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        for (int i = 0; i < numVehiculos; i++) {
            vehiculos.add(new Turismo());
        }
        return vehiculos;
    }

    public static ArrayList<Vehiculo> generarDeportivos(int numVehiculos) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        for (int i = 0; i < numVehiculos; i++) {
            vehiculos.add(new Deportivo());
        }
        return vehiculos;
    }

    public static ArrayList<Vehiculo> generarFurgonetas(int numVehiculos) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        for (int i = 0; i < numVehiculos; i++) {
            vehiculos.add(new Furgoneta());
        }
        return vehiculos;
    }

}
