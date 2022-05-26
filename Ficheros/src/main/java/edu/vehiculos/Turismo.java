
package edu.vehiculos;

import java.util.Random;

public class Turismo extends Vehiculo{
    
    //random
    Random random = new Random();

    //Además de los atributos de vehículos esta clase tiene:
    private int puertas;
    private boolean marchaAutomatica;
    
    public Turismo() {
        super();
        this.puertas = random.nextInt(5)+1;
        this.marchaAutomatica = random.nextBoolean();
    }

    public Turismo(int puertas, boolean marchaAutomatica, long bastidor, String matricula, String marca, String modelo, String color, double tarifa) {
        //Llama al constructor de la superclase
        super(bastidor, matricula, marca, modelo, color, tarifa);
        this.puertas = puertas;
        this.marchaAutomatica = marchaAutomatica;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public boolean isMarchaAutomatica() {
        return marchaAutomatica;
    }

    public void setMarchaAutomatica(boolean marchaAutomatica) {
        this.marchaAutomatica = marchaAutomatica;
    }

    @Override
    public String toString() {
        //Llama al toString (super.toString) de la super clase (clase padre) para mostrar todos los atributos más los específicos de Turismo
        return super.toString() + ":" + puertas + ":" + marchaAutomatica;
    }

    
    
    
}
