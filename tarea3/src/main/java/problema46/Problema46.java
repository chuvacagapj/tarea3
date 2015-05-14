/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema46;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import problema43.Empleado;

/**
 *
 * @author jesus
 */
public class Problema46 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Empleado> lista = new ArrayList();
        ArrayList<Empleado> repor = new ArrayList();
        File archivo = new File("DATOS.DAT");
        Empleado i, e = new Empleado();
        String entrada = "";
        FileReader lector;
        int caracter;
        
        if (archivo.exists()) {
            lector = new FileReader(archivo);
            caracter = lector.read();
            
            while (caracter != -1) {
                entrada += (char)caracter;
                caracter = lector.read();
            }
            
            lista.addAll(Arrays.asList(Empleado.generador(entrada)));
            
            System.out.println("Introdusca la provincia");
            e.setProvincia(input.readLine());
            
            if (lista.indexOf(e) == -1) {
                System.out.println("no existe ningun empleado de esa provincia");
            }
            
            while (lista.indexOf(e) != -1) {
                i = lista.get(lista.indexOf(e));
                System.out.println(i);
                lista.remove(i);
            }
            
            
        }else{
            System.out.println("No existen Empleados para realizar el reporte");
        }
    }
}
