
package edu.vehiculos;

import java.util.Random;

public class Deportivo extends Vehiculo{
    
    //Random
    Random random = new Random();
    
    //Además de los atributos de vehículos esta clase tiene:
    private int cilindrada;
    
    public Deportivo() {
        super();
        this.cilindrada = random.nextInt(2)+1;
    }

    public Deportivo(int cilindrada, long bastidor, String matricula, String marca, String modelo, String color, double tarifa) {
        //Llama al constructor de la superclase
        super(bastidor, matricula, marca, modelo, color, tarifa);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        //Llama al toString (super.toString) de la super clase (clase padre) para mostrar todos los atributos más los específicos de Turismo
        return super.toString() + ":" + cilindrada;
    }

    
    
    
    
    
    
}
