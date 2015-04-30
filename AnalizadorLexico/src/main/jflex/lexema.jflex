import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import mx.uach.compiladores.a.analizadorlexico.Token;
%%
%public
%class Lexer
%standalone
%{
    private List<Token> tokens = new ArrayList<>();
%}
%{
    public List<Token> analizar (String archivo){
        FileReader in = null;
        try{
            in = new FileReader(archivo);
            Lexer lexer = new Lexer(in);
            while(!lexer.zzAtEOF){
                lexer.yylex();
            }
        } catch (Exception ex){
            System.out.println("Error al analizar el archivo");
        } finally {
            try{
                in.close();
            }catch(Exception ex){
                System.out.println("Error al cerrar el archivo");
            }
        }
        return this.tokens;
    }

    public Token token(int linea, int tk, String cadena){
        return new Token(linea, tk, cadena);
    }
%}
%%

";"     {tokens.add(token(yyline, ';', ";" )); System.out.println(yyline);}


