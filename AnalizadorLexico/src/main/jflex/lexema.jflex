import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import mx.uach.compiladores.a.analizadorlexico.Token;
%%
%public
%class Lexema
%standalone
%cup
%line
%{
    private List<Token> tokens = new ArrayList<>();
%}
%{
    public List<String> analizar (String archivo){
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

    public Token token(Integer linea, int tk, String lex){
        return new Token(linea, tk, lex)
    }
%}
finLinea  = \r|\n|\r\n
entrada   = [^\r\n] 
especial  = [^a-zA-Z0-9_]
entero    = [+-][0-9]+
pto_fijo  = [+-]([0-9]*"."[0-9]+ |  [0-9]+"."[0-9]*) | [0-9]*"."[0-9]+ |  [0-9]+"."[0-9]*
pto_flot  = ({entero} | {pto_fijo})[Ee]{entero}
argumento = 
cadena    = \"\"
argumentos= {argumento} (","{argumento})*
lista     = "["{argumentos}"]" 
predicado = {atomo}"("{argumentos}")"

atomo = [a-z][a-zA-Z0-9_]* | \'{entrada}+\' | {especial}+
%%