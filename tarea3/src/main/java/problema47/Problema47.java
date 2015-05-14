/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema47;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jesus
 */
public class Problema47 {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File archivo = new File("VENTAS.DAT");
        FileReader lector;
        int caracter;
        
        if (archivo.exists()) {
            lector = new FileReader(archivo);
            caracter = lector.read();
            
            while (caracter != -1) {
                System.out.print((char)caracter);
                caracter = lector.read();
            }
        }
    }
}
