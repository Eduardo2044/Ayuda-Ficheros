
package ayuda.ficheros;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class OrdenarPorVariosCriterios {
    
    //CLASE PARA ORDENAR POR VARIOS CRITERIOS
    public static void ordenandoListaDiaHora(ArrayList lista) {
        //Ejemplocon la clase POJO (Clase de ejemplo en este paquete)
        //Ponemos en el comparator el objeto a comparar, le damos un nombre y declaramos el comparator
        Comparator<POJO> ordenPorNombre = (d1, d2) -> d1.getNombre().compareTo(d2.getNombre()); //Comparator de string ej
        Comparator<POJO> ordenPorTlf = (h1, h2) -> Integer.compare(h1.getTelefono(), h2.getTelefono()); //Comparator de int ej
        Collections.sort(lista, ordenPorNombre.thenComparing(ordenPorTlf));
    }
    
}
