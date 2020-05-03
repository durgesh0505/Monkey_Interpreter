package parser;
import tokenizer.Token;
import tokenizer.Tokenizer;
import java.io.FileNotFoundException;

public class MasterParser {
    Tokenizer tokenizer;
    VariableParser variableParser;
    SemiColonParser semiColonParser;
    PrintParser printParser;
    OpenCurlyBrackes openCurlyBrackes;
    CloseCurlyBraces closeCurlyBraces;
    FunctionParser functionParser;
    FunctionCall functionCall;

    public MasterParser(){
        tokenizer = new Tokenizer();
        variableParser = new VariableParser();
        closeCurlyBraces = new CloseCurlyBraces();
        semiColonParser = new SemiColonParser();
        printParser = new PrintParser();
        openCurlyBrackes = new OpenCurlyBrackes();
        functionParser = new FunctionParser();
        functionCall = new FunctionCall();
    }

    public void acceptToken(Token firstToken) throws FileNotFoundException {
        Token token = firstToken;
        String type;

        for(int i = 0; i < 11; i++){
            type = token.getType();
            switch (type){
                case ("variable") :
                    variableParser.parse(token.getTokens());
                    break;
                case ("return") :
                    returnParser.parse(token.getTokens());
                    break;
                case "semi":
                    semiColonParser.parse(token.getTokens());
                    break;
                case "print":
                    printParser.parse(token.getTokens());
                    break;
                case "openCurlyBraces":
                    openCurlyBrackes.parse(token.getTokens());
                    break;
                case "closeCurlyBraces":
                    CloseCurlyBraces.parse(token.getTokens());
                    break;
                case "function":
                    functionParser.parse(token.getTokens());
                    break;
                case "functionCall":
                    functionCall.parse(token.getTokens());
                    break;
                case "default":
                    defaultParser.parse(token.getTokens());
                    break;
                default:
                    defaultParser.parse(token.getTokens());
                    break;
            }
            token = token.getNextToken();
        }


    }


}

