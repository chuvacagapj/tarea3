/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema17 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int mayor, menor, entrada;
        int suma = 0;
        int cont = 0;
        
        System.out.println("Introdusca el 1 valor:");
        entrada = Integer.parseInt(input.readLine());
        mayor = entrada;
        menor = entrada;
        
        System.out.println("Introdusca el 2 valor");
        entrada = Integer.parseInt(input.readLine());
        
        if (entrada > mayor) {
            mayor = entrada;
        }else{
            menor = entrada;
        }
        
        for (int i = menor; i <= mayor; i++) {
            if (i%2 == 0) {
               System.out.println(i);
               cont++;
            }
        }
        
        System.out.println(String.format("son %d numeros", cont));
        System.out.println(String.format("la suma es %d", suma));
    }
}
