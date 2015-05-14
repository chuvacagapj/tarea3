/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema43;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema43 {
    
    public static final File ARCHIVO = new File("DATOS.DAT");
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Empleado e = new Empleado();
        FileWriter escritor = null;
        
        System.out.println("Introdusca el DNI");
        e.setDni(input.readLine());
        System.out.println("Introdusca el nombre");
        e.setNombre(input.readLine());
        System.out.println("Introdusca los apellidos");
        e.setApellidos(input.readLine());
        System.out.println("Introdusca la direccion");
        e.setApellidos(input.readLine());
        System.out.println("Introdusca la provincia");
        e.setProvincia(input.readLine());
        
        if (unico(e)) {
            try{
            escritor = new FileWriter(ARCHIVO, true);
            escritor.write(e.toString());
            }catch (Exception ex) {
                System.out.println(ex.toString());
            }finally{
                try{
                    escritor.close();
                }catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            }
        }else{
            System.out.println("El empleado ya existe, no se guardara");
        }
    }
    
    public static boolean unico (Empleado e) throws FileNotFoundException, IOException{
        Empleado[] actuales = null;
        String entrada = "";
        FileReader r = null;
        int caracter;
        
        if (ARCHIVO.exists()) {
            r = new FileReader(ARCHIVO);
            caracter = r.read();
            
            while (caracter != -1) {
                entrada += (char)caracter;
                caracter = r.read();
            }
            r.close();
            
            actuales = Empleado.generador(entrada);
            for (Empleado actuale : actuales) {
                if (actuale.equals(e)) {
                    return false;
                }
            }
            
        }
        return true;
    }
}
