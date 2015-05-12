/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema27 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int entrada;
        
        System.out.println("Introdusca el numero para la tabla");
        entrada = Integer.parseInt(input.readLine());
        
        for (int i = 0; i <= 10; i++) {
            System.out.println(String.format("  %d * %2d = %d", entrada, i, entrada*i));
        }
    }
}
