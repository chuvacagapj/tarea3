/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema15 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int mayor, menor, entrada;
        int par = 0;
        int impar = 0;
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
            System.out.println(i);
            cont++;
            if (i%2 == 0) {
                par += 1;
            }else{
                impar += i;
            }
        }
        
        System.out.println(String.format("son %d numeros", cont));
        System.out.println(String.format("son %d pares", par));
        System.out.println(String.format("la suma de impares es %d", impar));
    }
}
