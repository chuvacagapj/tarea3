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
    
    public static void factorial(int n){
        int resultado = 1;
        if (n < 0) {
            throw new Error(String.format("El valor %d no es valido", n));
        }
        
        for (int i = 1; i == n; i++) {
            resultado *= i;
        }
        
        System.out.println(String.format("%d! = %d", n, resultado));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean bandera = true;
        char entrada;
        int n;
        
        System.out.println("Introduzca un valor");
        n = Integer.parseInt(input.readLine());
        
        while (bandera) {
            System.out.println("Elija una de las siguientes opciones\n" +
                    "\t1) saber si el numero es primo\n"+
                    "\t2) Calcular el factorial del numero\n"+
                    "\t3) Calcular la tabla de multiplicar\n" +
                    "\nCualquier otra opcion para salir");
            entrada = input.readLine().charAt(0);
            
            switch (entrada) {
                case '1':
                    primo(n);
                    break;
                case '2':
                    factorial(n);
                    break;
                case '3':
                    multiplicacion(n);
                    break;
                default:
                    bandera = false;
            }
        }
    }
}
