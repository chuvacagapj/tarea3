/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema5;

/**
 * //TODO javadoc
 * @author jesus
 */
public class Problema5 {
    public static void main(String[] args) {
        int cont = 0;
        for (int i = 1; i <= 100; i+= 2) {
            cont++;
            System.out.println(i);
        }
        System.out.println(String.format("hay %d impares", cont));
    }
}
