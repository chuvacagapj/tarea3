/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema10 {
    public static void main(String[] args) throws IOException {
        int entrada;        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Introdusca un numero cualquiera:");
        entrada = Integer.parseInt(input.readLine());
        
        if (entrada % 2 == 0) {
            System.out.println(String.format("El numero %d es par", entrada));
        }else{
            System.out.println(String.format("El numero %d es impar", entrada));
        }
    }
}
