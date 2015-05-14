/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema44;

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
public class Problema44 {

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

            System.out.println("Introdusca el DNI del empleado a borrar");
            dni.setDni(input.readLine());

            if (lista.remove(dni)) {
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
            System.out.println("Lo sentimos, no se pueden borrar empleado porque no hay ninguno");
        }
    }
}
