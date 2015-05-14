/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema45;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import problema43.Empleado;

/**
 *
 * @author jesus
 */
public class Prolema45 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Empleado> lista = new ArrayList();
        File archivo = new File("DATOS.DAT");
        Empleado dni = new Empleado();
        FileWriter escritor = null;
        FileReader lector;
        String entrada = "";
        int caracter;

        if (archivo.exists()) {
            lector = new FileReader(archivo);
            caracter = lector.read();

            while (caracter != -1) {
                entrada += (char) caracter;
                caracter = lector.read();
            }
            lector.close();
            lector = null;

            lista.addAll(Arrays.asList(Empleado.generador(entrada)));

            System.out.println("Introdusca el DNI del empleado a modificar");
            dni.setDni(input.readLine());

            if (lista.contains(dni)) {
                dni = lista.get(lista.indexOf(dni));
                lista.remove(dni);
                
                System.out.println("Deje en blanco, los atributos que no cabiara");
                System.out.println(String.format("EL nombre es %s", 
                        dni.getNombre()));
                entrada = input.readLine().trim();
                if (!entrada.isEmpty()) {
                    dni.setNombre(entrada);
                }
                System.out.println(String.format("EL apellidos son %s", 
                        dni.getApellidos()));
                entrada = input.readLine().trim();
                if (!entrada.isEmpty()) {
                    dni.setApellidos(entrada);
                }
                System.out.println(String.format("EL direccion es %s", 
                        dni.getDireccion()));
                entrada = input.readLine().trim();
                if (!entrada.isEmpty()) {
                    dni.setDireccion(entrada);
                }
                System.out.println(String.format("EL provincia es %s", 
                        dni.getProvincia()));
                entrada = input.readLine().trim();
                if (!entrada.isEmpty()) {
                    dni.setProvincia(entrada);
                }
                
                lista.add(dni);
                
                try {
                    escritor = new FileWriter(archivo);
                    for (Empleado lista1 : lista) {
                        escritor.write(lista1.toString());
                    }
                    System.out.println("Operacionrealizada con exito");
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                } finally {
                    try {
                        escritor.close();
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }
                }
            } else {
                System.out.println("Lo sentimos, no existe registro de tal persona");
            }

        } else {
            System.out.println("Lo sentimos, no se pueden modificar empleados porque no hay ninguno");
        }
    }
}
