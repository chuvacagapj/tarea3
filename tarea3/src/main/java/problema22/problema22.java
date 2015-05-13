/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class problema22 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String frase;
        
        System.out.println("Introdusca una frace");
        frase = input.readLine();
        
        for (int i = 0; i < 5; i++) {
            frase = String.format("    %s", frase);
            System.out.println(frase);
        }
    }
}
