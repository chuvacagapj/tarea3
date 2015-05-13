/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema31 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int x, y;
        char entrada;
        boolean bandera = true;
        
        System.out.println("Introdusca el valor en x");
        x = Integer.parseInt(input.readLine());
        System.out.println("Introdusca el valor en y");
        y = Integer.parseInt(input.readLine());
        
        while (bandera) {
            System.out.println("Elija una de las siguientes opciones\n" +
                    "\t1) x + y\n\t2) x - y\n\t3) x * y\n\t4) x / y\n" +
                    "\nCualquier otra opcion para salir");
            entrada = input.readLine().charAt(0);
            
            switch (entrada) {
                case '1':
                    System.out.println(String.format("x + y = %s\n", x + y));
                    break;
                case '2':
                    System.out.println(String.format("x - y = %s\n", x - y));
                    break;
                case '3':
                    System.out.println(String.format("x * y = %s\n", x * y));
                    break;
                case '4':
                    System.out.println(String.format("x / y = %s\n", x / y));
                    break;
                default:
                    bandera = false;
            }
        }
        
    }
}
