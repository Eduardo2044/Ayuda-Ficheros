
package edu.vehiculos;

import java.util.Random;
import java.util.stream.Stream;

public class Vehiculo {
    
    //Random
    Random random = new Random();
    
    //Arrays opciones
    private static String[] arrMarca = {"Alfa Romeo", "Aston Martin", "Audi", "BMW", "Chevrolet", "Citroen", "Ford", "Honda", "Lexus", "Mazda", "Mercedes-Benz", "Nissan", "Subaru", "Toyota", "Volkswagen", "Volvo"};
    private static String[] arrModelo = {"Giulia", "Accord", "Vantage", "A6", "Q8", "Impreza", "S60", "C4"};
    private static String[] arrColor = {"Rojo", "Blanco", "Verde", "Azul", "Gris", "Amarillo", "Negro", "Naranja"};
    private static String[] arrLetras = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    
    //Atributos
    private long bastidor;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double tarifa;
    
    public Vehiculo(){
        this.bastidor = random.nextInt(900000000)+100000000;
        this.matricula = random.nextInt(8999)+1000 + arrLetras[random.nextInt(arrMarca.length)] + arrLetras[random.nextInt(arrMarca.length)] + arrLetras[random.nextInt(arrMarca.length)];
        this.marca = arrMarca[random.nextInt(arrMarca.length)];
        this.modelo = arrModelo[random.nextInt(arrModelo.length)];
        this.color = arrColor[random.nextInt(arrColor.length)];
        this.tarifa = random.nextInt(350)+random.nextDouble();
    }

    public Vehiculo(long bastidor, String matricula, String marca, String modelo, String color, double tarifa) {
        this.bastidor = bastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tarifa = tarifa;
    }

    public long getBastidor() {
        return bastidor;
    }

    public void setBastidor(long bastidor) {
        this.bastidor = bastidor;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return bastidor + ":" + matricula + ":" + marca + ":" + modelo + ":" + color + ":" + String.format("%.2f", tarifa);
    }

    public Stream<Vehiculo> isDisponible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
