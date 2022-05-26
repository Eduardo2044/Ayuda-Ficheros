
package ayuda.ficheros;

import java.time.LocalDate;
import java.util.Objects;
/*
    CLASE DE APOYO PARA EL EJEMPLO DE LECTURA
    DE FICHEROS A OBJETOS "POJO" DE LA CLASE
    "LecturaEscrituraCSV"
*/
public class POJO {
    
    private String apellidos;
    private String nombre;
    private String dni;
    private String puesto;
    private LocalDate tomaDePosesion;
    private LocalDate cese;
    private int telefono;
    private boolean evaluador;
    private boolean coordinador;

    public POJO() {
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getTomaDePosesion() {
        return tomaDePosesion;
    }

    public void setTomaDePosesion(LocalDate tomaDePosesion) {
        this.tomaDePosesion = tomaDePosesion;
    }

    public LocalDate getCese() {
        return cese;
    }

    public void setCese(LocalDate cese) {
        this.cese = cese;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isEvaluador() {
        return evaluador;
    }

    public void setEvaluador(boolean evaluador) {
        this.evaluador = evaluador;
    }

    public boolean isCoordinador() {
        return coordinador;
    }

    public void setCoordinador(boolean coordinador) {
        this.coordinador = coordinador;
    }

    @Override
    public String toString() {
        return apellidos + ";" + nombre + ";" + dni + ";" + puesto + ";" + tomaDePosesion + ";" + cese + ";" + telefono + ";" + evaluador + ";" + coordinador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.dni);
        hash = 67 * hash + Objects.hashCode(this.puesto);
        hash = 67 * hash + Objects.hashCode(this.tomaDePosesion);
        hash = 67 * hash + Objects.hashCode(this.cese);
        hash = 67 * hash + this.telefono;
        hash = 67 * hash + (this.evaluador ? 1 : 0);
        hash = 67 * hash + (this.coordinador ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final POJO other = (POJO) obj;
        return Objects.equals(this.dni, other.dni);
    }
    
    
    
    
}
