package edu.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ej1 {

    public static final int TAMANIO = 4;

    public static void main(String[] args) {

        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "matriz.txt";

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            String linea = "";

            for (int i = 1; i < TAMANIO + 1; i++) {
                linea = "";
                for (int j = 1; j < TAMANIO + 1; j++) {
                    linea += i + "" + 0 + "" + j + "\t";
                }
                // Usamos metodo write() para escribir en el buffer
                flujo.write(linea);
                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + idFichero + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
