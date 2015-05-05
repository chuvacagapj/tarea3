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
    public void pruebaEnteroFalla(){
        //TODO
    }
    
    @Test
    public void pruebaCadena(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaCadenaFala(){
        //TODO
    }
    
    @Test
    public void pruebaAtomo1(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaAtomo1Falla(){
        //TODO
    }
    
    @Test
    public void pruebaAtomo2(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaAtomo2Falla(){
        //TODO
    }
    
    @Test
    public void pruebaAtomo3(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaAtomo3Falla(){
        //TODO
    }
    
    @Test
    public void pruebaPtoFijo(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaPtoFijoFalla(){
        //TODO
    }
    
    @Test
    public void pruebaPtoFlot(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaPtoFlotFalla(){
        //TODO
    }
    
    @Test
    public void pruebaVariable(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaVariableFalla(){
        //TODO
    }
    
    @Test
    public void pruebaPredicado(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaPredicadoFalla(){
        //TODO
    }
    
    @Test
    public void pruebaLista(){
        //TODO
    }
    
    @Test//(expected = Error.class)
    public void pruebaListaFalla(){
        //TODO
    }
}
