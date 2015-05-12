/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema20 {
    
    public static  int factorial(int n){
        if(n== 0){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    
    public static void main(String[] args) throws IOException {
         BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
         int entrada;
         long salida;
         
         System.out.println("Introduce un valor");
         entrada = Integer.parseInt(input.readLine());
         
         salida = factorial(entrada);
         System.out.println(String.format("El factorial es %d", salida));
    }
}
