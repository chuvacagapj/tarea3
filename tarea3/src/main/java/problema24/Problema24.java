/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema24 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int entrada;
        boolean bandera = true;
        
        System.out.println("Introdusca un numero");
        entrada = Integer.parseInt(input.readLine());
        
        for (int i = 2; i <= (int)Math.ceil(Math.sqrt(entrada)); i++) {
            if (entrada%i == 0) {
                bandera = false;
                break;
            }
        }
        
        if (bandera) {
            System.out.println(String.format("El numero %d es primo", entrada));
        }else{
            System.out.println(String.format("El numero %d no es primo", entrada));
        }
    }
}
