
package ayuda.ficheros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    public static void main(String[] args) {
        
        /*
            Ejemplos y explicaciones:
            https://santandergto.com/programacion-en-java-stream-para-dummies/
        */
        
        /****ELEMENTOS Y OPERACIONES****/
        /*
            1.-Filter: Para filtrar por algún campo y poder seguir usando metodos de stream (devulve stream)
            2.-Count: Número de elementos del stream (ej. saber cuantos elementos tenemos después de hacer filter)
            3.-Collect: Convierte el stream en un List, que es equivalente a un ArrayList, podemos realizar las mismas acciones con el
            4.-Map: Podemos hacer que aparezca solo un campo de todos los datos del objeto. Esto juntos con Collect los permite crear listas de un solo dato de un objeto. (ej. metodo listaLetraNIF)
            5.-Distinct: Hace que los elementos solo aparezcan 1 vez (ej. tenemos lista de coches y queremos saber solo las marcas, hacemos map con el campo marcas, luego distinct y un collect, esto nos dará una lista de String con las marcas 1 sola vez)
            6.-Sorted: Para ordenar los resultados (ej. método listaFechas)
            7.-anyMatch: Devuelve Boolean se usa con lamda (ej. método buscarPorNombre)
        */
        
    }
    
    public static boolean buscarPorNombre(ArrayList<POJO> lista, String nombre) {
//        int aux = 0;
//        for (int i = 0; i < lista.size(); i++) {
//            if (lista.get(i).getNombre().trim().equals(nombre)) {
//                aux = lista.indexOf(lista.get(i));
//            }
//        }
//        return aux;

        boolean porNombre = lista.stream()
                .anyMatch(v->v.getNombre().trim().equalsIgnoreCase(nombre));
        
        return porNombre;

    }

    public static long cantEmpleadosDepto(ArrayList<POJO> lista, String depto) {
//        int aux = 0;
//        for (int i = 0; i < lista.size(); i++) {
//            if ((lista.get(i).getPuesto().equals(depto)) && (lista.get(i).isCoordinador())) {
//                aux++;
//            }
//        }
//        return aux;
    
        long cantidadEmpleados = lista.stream().
                filter(v->v.getPuesto().equalsIgnoreCase(depto))
                .filter(v -> v.isCoordinador())
                .count();
        
        return cantidadEmpleados;
        
    }

    public static List<String> listaLetraNIF(ArrayList<POJO> lista, CharSequence letra) {
        
//        Collections.sort(lista, new Comparator<POJO>() {
//            public int compare(POJO obj1, POJO obj2) {
//                return obj1.getApellidos().compareTo(obj2.getApellidos());
//            }
//        });
//        
//        ArrayList<String> resultado = new ArrayList<>();
//        for (int i = 0; i < lista.size(); i++) {
//            if (lista.get(i).getDni().contains(letra)) {
//                resultado.add(lista.get(i).getApellidos());
//            }
//        }
//
//        return resultado;

        List<String> contieneLetra = lista.stream()
                .filter(v -> v.getDni().contains(letra))
                .map(v -> v.getApellidos())
                .collect(Collectors.toList());
        
        return contieneLetra;

    }
    
    public static List<String> listaFechas(ArrayList<POJO> lista, LocalDate fecha) {   
        
//        ArrayList<String> resultado = new ArrayList<>();
//        for (int i = 0; i < lista.size(); i++) {
//            if (lista.get(i).getTomaDePosesion().equals(fecha)) {
//                resultado.add(lista.get(i).getDni());
//            }
//        }
//
//        Collections.reverse(resultado);
//        
//        return resultado;

        List<String> posesionEnFecha = lista.stream()
                .filter(v -> v.getTomaDePosesion().equals(fecha))
                .map(v -> v.getDni())
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        return posesionEnFecha;
        
    }
    
}
