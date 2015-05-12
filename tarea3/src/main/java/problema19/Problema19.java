/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author jesus
 */
public class Problema19 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int hora, minuto, segundo;
        
        System.out.println("Introdusca la hora");
        hora = Integer.parseInt(input.readLine());
        System.out.println("Introdusca la minuto");
        minuto = Integer.parseInt(input.readLine());
        System.out.println("Introdusca la segundo");
        segundo = Integer.parseInt(input.readLine());
        
        while (hora < 24) {
            while (minuto < 60) {
                while (segundo < 60) {
                    System.out.println(String.format("%d:%d:%d", hora, minuto, segundo));
                    Thread.sleep(1000);
                    segundo++;
                }
                minuto++;
            }
            segundo++;
        }
    }
}
