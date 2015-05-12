/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema14 {

    public static void main(String[] args) throws IOException {
        int entrada, mayor, menor;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introdusca el 1 valor:");
        entrada = Integer.parseInt(input.readLine());
        mayor = entrada;
        menor = entrada;

        for (int i = 1; i < 5; i++) {
            System.out.println(String.format("Introdusca el %d valor:", i));
            entrada = Integer.parseInt(input.readLine());
            
            if (entrada > mayor) {
                mayor = entrada;
            }
            if(entrada < menor){
                menor = entrada;
            }
            
        }
        
        System.out.println(String.format("El mayor numero es %d", mayor));
        System.out.println(String.format("El menor numero es %d", menor));
    }
}
