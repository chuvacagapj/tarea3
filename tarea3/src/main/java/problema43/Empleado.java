/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema43;

import java.util.Objects;

/**
 *
 * @author jesus
 */
public class Empleado {
    
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String provincia;

    public Empleado() {
    }

    public Empleado(String entrada) {
        String[] valores = entrada.split(":");
        
        try{
            
            this.dni       = valores[0];
            this.nombre    = valores[1];
            this.apellidos = valores[2];
            this.direccion = valores[3];
            this.provincia = valores[4];
            
        }catch (ArrayIndexOutOfBoundsException ex) {
            throw new Error("Archivo corrupto");
        }catch (Exception ex) {
            throw ex;
        }
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s:%s:%s\n", this.dni, this.nombre, 
                this.apellidos, this.direccion, this.provincia);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }
    
    
    public static Empleado[] generador(String entrada){
        String[] cadenas = entrada.split("\n");
        Empleado[] emp = new Empleado[cadenas.length];
        
        for (int i = 0; i < cadenas.length; i++) {
            emp[i] = new Empleado(cadenas[i]);
        }
        
        return emp;
    }
    
}
