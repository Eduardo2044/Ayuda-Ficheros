/*
Implementa un programa que vaya escribiendo líneas de texto
en un archivo. El archivo se llamará “teclado.txt” y se creará
en la raíz del proyecto. El programa irá solicitando líneas de
texto al usuario (cada línea termina con un salto de línea , ‘\n’)
y las irá escribiendo en el fichero. Cuando en una nueva línea el
usuario introduzca el texto “EOF”, el programa terminará y esa
línea no se escribirá en el fichero. Controla las posibles excepciones
que pudieran ocurrir.
*/
package edu.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ej2 {
    
    public static void main(String[] args) {
        
        //Scanner
        Scanner teclado = new Scanner(System.in);
        
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "teclado.txt";
        
        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            String texto;
            do {                
                System.out.println("Introduzca las frases que desee guardar (EOF para terminar): ");
                texto = teclado.nextLine();
                
                if (!texto.equalsIgnoreCase("EOF")) {
                    // Usamos metodo write() para escribir en el buffer
                    flujo.write(texto);
                    // Metodo newLine() añade salto de línea después de cada fila
                    flujo.newLine();
                }
                
            } while (!texto.equalsIgnoreCase("EOF"));
            
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            
            System.out.println("Fichero " + idFichero + " creado correctamente.");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
                
    }
    
}
