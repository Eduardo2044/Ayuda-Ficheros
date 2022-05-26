
package ayuda.ficheros;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;

public class LecturaEscrituraJSON {
    
    public static void main(String[] args) throws JAXBException, IOException {
        
        ArrayList<POJO> lista = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            lista.add(new POJO());
        }
        
        escrituraJson("jsonprueba1", lista);
        
        EscrituraGenerica.escribirJSON("jsonprueba2", lista);
        
        LecturaJSON("jsonprueba1");
        
        List<POJO> lisp = LecturaGenerica.leerArchivoJSON1("jsonprueba2", POJO.class); 
        
        System.out.println("------ Lista 2 ------");
        lisp.forEach(System.out::println);
        
    }
    
    //MÉTODO PARA CREAR UN JSON A PARTIR DE UNA LISTA DE CUALQUIER TIPO DE OBJETO
    public static <T> void escrituraJson(String idFichero, ArrayList<T> lista) throws JAXBException, IOException {
        ObjectMapper mapeador = new ObjectMapper();

        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(idFichero), lista);
    }
    
    public static void escrituraJSONej1(ArrayList lista, String ruta) {
        //Creamos un objeto mapeador para poder configurar el archivo JSON
        //y para llevar a cabo la creación del mismo
        ObjectMapper mapeador = new ObjectMapper();

        //Utilizamos el método configure para que la estructura del JSON
        //este bien tabulada al guardar los objetos de la lista que le pasamos
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            //llamamos al método writeValue que se le pasa como parametros
            //un constructor new File con el idFichero que pasamos anteriormente
            //y la lista de donde sacará los objetos en cuestión
            System.out.println("------------------generando 1");
            mapeador.writeValue(new File(ruta), lista);
            System.out.println("Archivo JSON creado correctamente");
        } catch (IOException ex) {
                System.out.println("Error");
        }
    }
    
    //MÉTODO PARA LEER UN JSON DE CUALQUIER TIPO DE OBJETO
    public static <T> void LecturaJSON (String idFichero) throws IOException {
        ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());

        ArrayList<T> lista = mapeador.readValue(new File(idFichero),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, POJO.class)); // En "POJO" iría el objeto que queramos leer

        System.out.println("---- Lista ----");
        for (T pojo : lista) {
            System.out.println(pojo);
        }
    }
    
}
