/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jflex.test;

import mx.uach.compiladores.a.analizadorlexico.Token;
import org.junit.Test;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import jflex.Lexer;
import static org.junit.Assert.*;

/**
 *
 * @author jesus
 */
public class LexerTest {
    
    public LexerTest() {
    }
    
    

    @Test
    public void pruebaEntero()throws IOException{
        String ruta = "src/test/java/pruebas/pruebaEntero.chuy";
        FileReader archivo = new FileReader(ruta);
        List<Token> tokens = null;
        Token[] esperado = 
            {   new Token(1, Token.ENTERO,     "0" ),
                new Token(1, Token.PUNTO_COMA, ";" ),
                new Token(2, Token.ENTERO,     "20"),
                new Token(2, Token.PUNTO_COMA, ";"),
                new Token(3, Token.ENTERO,     "-0"),
                new Token(3, Token.PUNTO_COMA, ";"),
                new Token(4, Token.ENTERO,     "-14"),
                new Token(4, Token.PUNTO_COMA, ";"),
                new Token(5, Token.ENTERO,     "+0"),
                new Token(5, Token.PUNTO_COMA, ";"),
                new Token(6, Token.ENTERO,     "+17"),
                new Token(6, Token.PUNTO_COMA, ";")};
        
        Lexer lex = new Lexer(archivo);
        while(!lex.getzzAtEOF()){
                lex.yylex();
        }
        
        tokens = lex.analizar();
        assertArrayEquals(esperado, tokens.toArray(new Token[tokens.toArray().length]));
    }
    
    @Test(expected = Error.class)
    public void pruebaEnteroFalla()throws IOException{
        String ruta = "src/test/java/pruebas/pruebaEnteroFalla.chuy";
        FileReader archivo = new FileReader(ruta);
        List<Token> tokens = null;
        
        Lexer lex = new Lexer(archivo);
        while(!lex.getzzAtEOF()){
                lex.yylex();
        }
        
        tokens = lex.analizar();
    }
    
    @Test
    public void pruebaCadena()throws IOException{
         String ruta = "src/test/java/pruebas/pruebaCadena.chuy";
        FileReader archivo = new FileReader(ruta);
        List<Token> tokens = null;
        Token[] esperado = 
            {   new Token(1, Token.ENTERO,     "0"       ),
                new Token(1, Token.CADENA,     "\"hola\""),
                new Token(1, Token.PUNTO_COMA, ";"       ),
                new Token(2, Token.CADENA,     "\"20\""  ),
                new Token(2, Token.PUNTO_COMA, ";"       ),
                new Token(3, Token.CADENA,     "\"-\""   ),
                new Token(3, Token.CADENA,     "\"0\""       ),
                new Token(3, Token.PUNTO_COMA, ";"       ),
                new Token(4, Token.ENTERO,     "-14"     ),
                new Token(4, Token.PUNTO_COMA, ";"       ),
                new Token(5, Token.ENTERO,     "+0"      ),
                new Token(5, Token.PUNTO_COMA, ";"       ),
                new Token(6, Token.ENTERO,     "+17"     ),
                new Token(6, Token.PUNTO_COMA, ";"       ),
                new Token(7, Token.CADENA,     "\"¡Bienvenidos al Estado Grande!\"")};
        
        Lexer lex = new Lexer(archivo);
        while(!lex.getzzAtEOF()){
                lex.yylex();
        }
        
        tokens = lex.analizar();
        
        for (Token esperado1 :tokens) {
            System.out.println(esperado1);
        }
        assertArrayEquals(esperado, tokens.toArray(new Token[tokens.toArray().length]));
    }
    
    @Test(expected = Error.class)
    public void pruebaCadenaFalla()throws IOException{
        String ruta = "src/test/java/pruebas/pruebaCadenaFalla.chuy";
        FileReader archivo = new FileReader(ruta);
        List<Token> tokens = null;
        
        Lexer lex = new Lexer(archivo);
        while(!lex.getzzAtEOF()){
                lex.yylex();
        }
        
        tokens = lex.analizar();
    }
    
    @Test
    public void pruebaAtomo1()throws IOException{
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaAtomo1Falla()throws IOException{
        //TODO
    }
    
    @Test
    public void pruebaAtomo2()throws IOException{
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaAtomo2Falla()throws IOException{
        //TODO
    }
    
    @Test
    public void pruebaAtomo3()throws IOException{
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaAtomo3Falla()throws IOException{
        //TODO
    }
    
    @Test
    public void pruebaPtoFijo()throws IOException{
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaPtoFijoFalla()throws IOException{
        //TODO
    }
    
    @Test
    public void pruebaPtoFlot()throws IOException{
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaPtoFlotFalla()throws IOException{
        //TODO
    }
    
    @Test
    public void pruebaVariable()throws IOException{
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaVariableFalla()throws IOException{
        //TODO
    }
    
    @Test
    public void pruebaPredicado()throws IOException{
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaPredicadoFalla()throws IOException{
        //TODO
    }
    
    @Test
    public void pruebaLista()throws IOException{
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaListaFalla()throws IOException{
        //TODO
    }
}
