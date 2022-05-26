
package edu.vehiculos;

public class Pruebas {

    public static void main(String[] args) {
        
        //Vico 1979
        
        Vehiculo miVehiculo = new Vehiculo(343245, "4050 ABJ", "VW", "GTI", "Blanco",100.0);
        Turismo miTurismo = new Turismo(5, true, 345674, "4060 TUR", "Skoda", "Fabia","Blanco",90.0);
        Deportivo miDeportivo = new Deportivo(2000, 78654, "4070 DEP","Ford", "Mustang", "Rojo",150.0);
        Furgoneta miFurgoneta = new Furgoneta(1200,8,4333, "4080 FUR", "Fiat", "Ducato", "Azul", 80.0);
        
        System.out.println("\n\n--------Vehículo-------- " + miVehiculo.toString());
        System.out.println("\n\n--------Turismo-------- " + miTurismo.toString());
        System.out.println("\n\n--------Deportivo-------- " + miDeportivo.toString());
        System.out.println("\n\n--------Furgoneta-------- " +miFurgoneta.toString());
        
        System.out.println("\n\nTurismo: " + miTurismo.getMatricula() + " " + miTurismo.getMarca() + " " +miTurismo.getModelo());

        
        
    }
    
}
