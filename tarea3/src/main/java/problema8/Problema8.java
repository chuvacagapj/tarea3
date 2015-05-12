/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * //TODO javadoc
 * @author jesus
 */
public class Problema8 {
    public static void main(String[] args) throws IOException {
        String entrada;        
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        
        entrada = input.readLine().trim();
        
        while (!entrada.isEmpty()) {
            if (!("n".equals(entrada.toLowerCase()) ||
                    "s".equals(entrada.toLowerCase()) )) {
                throw new Error(String.format("'%s' no soporada", entrada));
            }
            entrada = input.readLine().trim();
        }
    }
}
