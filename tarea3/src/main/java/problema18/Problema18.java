/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema18 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String frase;
        char letra;
        int cont = 0;
        
        System.out.println("Introdusca la frase:");
        frase =input.readLine();
        
        System.out.println("Introdusca la letra");
        letra = input.readLine().charAt(0);
        
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == letra) {
                cont++;
            }
        }
        
        System.out.println(String.format("la letra %s se repite %d veces", letra, cont));
    }
}
