/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema32 {
    
    public static void multiplicacion(int entrada) {

        for (int i = 0; i <= 10; i++) {
            System.out.println(String.format("  %d * %2d = %d", entrada, i, entrada*i));
        }
    }
    
    public static void primo(int entrada) {
        boolean bandera = true;
        
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
    
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    }
}
