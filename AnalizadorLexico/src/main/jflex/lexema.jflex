import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import mx.uach.compiladores.a.analizadorlexico.Token;
%%
%public
%class Lexer
%standalone
%line
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

entrada         = [^\r\n]
espaciosBlancos = [\r\n \t\f]
especial        = [^ \t\f\r\na-zA-Z0-9]
atomo      = [:lowercase:][a-zA-Z0-9_]* |  {especial}+ | \'{entrada}+\'
variable   = [:uppercase:][a-zA-Z0-9_]*
entero     = [+-]("0" | [1-9][0-9]*) | "0" | [1-9][0-9]*
pto_fijo   = {entero}"."[0-9]* | [+-]"."[0-9]+ | "."[0-9]+
pto_flot   = ({entero} | {pto_fijo})[Ee]{entero}
cadena     = \"{entrada}*\"

%%

";"     {System.out.println(token(yyline, ';',  yytext()).toString());}
","
"."
"("
")"
":-"

{atomo}  {System.out.println(token(yyline, Token.ATOMO,  yytext()).toString());}
{entero} {System.out.println(token(yyline, Token.ENTERO, yytext()).toString());}
{cadena} {System.out.println(token(yyline, Token.CADENA, yytext()).toString());}
{variable} {System.out.println(token(yyline, Token.VARIABLE, yytext()).toString());}
{pto_fijo} {System.out.println(token(yyline, Token.PTO_FIJO, yytext()).toString());}
{pto_flot} {System.out.println(token(yyline, Token.PTO_FLOT, yytext()).toString());}


{espaciosBlancos} {/* Ignorar */}
