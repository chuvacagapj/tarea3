/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema9 {
    
    public static void main(String[] args) throws IOException {
        int entrada;        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Introdusca un numero cualquiera:");
        entrada = Integer.parseInt(input.readLine());
        
        if (entrada < 0) {
            System.out.println(String.format("El numero %d es negativo", entrada));
        }else if (entrada > 0) {
            System.out.println(String.format("El numero %d es positivo", entrada));
        }else{
            System.out.println("El 0 es especial por que no es ni positivo ni negativo");
        }
    }
}
