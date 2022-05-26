/*
Implementa un programa que guarde exactamente 75 líneas de
texto en un fichero, cuyo nombre se deja a tu elección.
En cada línea se irán generando letras aleatorias (entre la ‘a’ y la ‘Z’)
y se irán separando por punto y coma (;) hasta que la letra que se vaya
a escribir sea ‘g’ o ‘G’. En este caso, se escribe y se saltará a la
línea siguiente. Posibles ejemplos de líneas generadas:
 
	a;C;T;B;D;s;u;i;w;g
	Q;w;e;r;t;y;S;H;J;K;G
	…

*/
package edu.ejercicios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ej3 {

    public static void main(String[] args) {
        
        //Random
        Random random = new Random();
        
        //Variables del programa
        String texto;
        final int MINUS_MAX = 122;
        final int MINUS_MIN = 97;
        final int MAYUS_MAX = 90;
        final int MAYUS_MIN = 65;
        
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "aleatorio.txt";
        
        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            //auxiliar del while
            int i = 0;
            while(i < 75){
                //Letra mayuscula aleatoria
                char mayus = (char) (random.nextInt(MAYUS_MAX-MAYUS_MIN+1)+MAYUS_MIN);
                //Letra minuscula aleatoria
                char minus = (char) (random.nextInt(MINUS_MAX-MINUS_MIN+1)+MINUS_MIN);
                
                if (random.nextBoolean()) {
                    // Usamos metodo write() para escribir en el buffer
                    flujo.write(mayus + ";");
                    if (mayus == 'G') {
                        // Metodo newLine() añade salto de línea después de cada fila
                        flujo.newLine();
                        i++;
                    }
                } else {
                    flujo.write(minus + ";");
                    if (minus == 'g') {
                        // Metodo newLine() añade salto de línea después de cada fila
                        flujo.newLine();
                        i++;
                    }
                }
            }
            
//            for (int i = 0; i < 75; i++) {
//                //Letra mayuscula aleatoria
//                char mayus = (char) (random.nextInt(MAYUS_MAX-MAYUS_MIN+1)+MAYUS_MIN);
//                //Letra minuscula aleatoria
//                char minus = (char) (random.nextInt(MINUS_MAX-MINUS_MIN+1)+MINUS_MIN);
//                
//                if (random.nextBoolean()) {
//                    // Usamos metodo write() para escribir en el buffer
//                    flujo.write(mayus + ";");
//                    if (mayus == 'G') {
//                        // Metodo newLine() añade salto de línea después de cada fila
//                        flujo.newLine();
//                    }
//                } else {
//                    flujo.write(minus + ";");
//                    if (minus == 'g') {
//                        // Metodo newLine() añade salto de línea después de cada fila
//                        flujo.newLine();
//                    }
//                }
//                
//            }
            
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            
            System.out.println("Fichero " + idFichero + " creado correctamente.");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
