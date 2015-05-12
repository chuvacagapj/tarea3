/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema26 {
    
    public static final int TOTAL = 73;
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String frase;
        int p;
        
        System.out.println("Introdusca una frase");
        frase = input.readLine();
        p = (TOTAL - frase.length())/2;
        
        for (int i = 0; i < p; i++) {
            System.out.print(" ");
        }
        System.out.println(frase);
        
        
    }
}
