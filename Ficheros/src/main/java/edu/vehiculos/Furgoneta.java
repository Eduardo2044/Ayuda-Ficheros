
package edu.vehiculos;

import java.util.Random;

public class Furgoneta extends Vehiculo{
    
    //Random
    Random random = new Random();
    
    //Además de los atributos de vehículos esta clase tiene:
    private int carga;
    private int volumen;
    
    public Furgoneta() {
        super();
        this.carga = random.nextInt(5800)+200;
        this.volumen = random.nextInt(20)+1;
    }

    public Furgoneta(int carga, int volumen, long bastidor, String matricula, String marca, String modelo, String color, double tarifa) {
        //Llama al constructor de la superclase
        super(bastidor, matricula, marca, modelo, color, tarifa);
        this.carga = carga;
        this.volumen = volumen;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    @Override
    public String toString() {
        //Llama al toString (super.toString) de la super clase (clase padre) para mostrar todos los atributos más los específicos de Turismo
        return super.toString() + ":" + carga + ":" + volumen;
    }
    
    
    
    
}
