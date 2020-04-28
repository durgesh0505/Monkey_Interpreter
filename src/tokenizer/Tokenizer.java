package tokenizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tokenizer
{

    Token firstToken;
    Token previousToken;

    public Tokenizer()
    {
        firstToken = null;
        previousToken = null;
    }

    public Token getFirstToken() {
        return firstToken;
    }

    public List<String> readFileLineByLine()
    {
        List<String> fileData = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader("input.txt")))
        {
            String sCurrentLine;
            while ((sCurrentLine = fileReader.readLine()) != null)
            {
                fileData.add(sCurrentLine.trim());
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return fileData;
    }

    public List<String> convertLineToTokenSentence(String line)
    {

        String[] array = line.split("(?=;)|(?<=;)|(?=[{])|(?<=[{])|(?=})|(?<=})");

        for (String element : array)
        {
//                System.out.println(element);
        }

        return Arrays.asList(array);

    }

    public List<String> assembleTokenSentences(List<String> monkeyLines)
    {
        List<String> tokenList = new ArrayList<>();
        monkeyLines.stream().forEach(monkeyLine ->
        {
            tokenList.addAll(convertLineToTokenSentence(monkeyLine));
        });

        return tokenList;
    }


    public String[] convertTokenSentenceToTokenWords(String monkeyLine){
        // space | ( | ) | " | , | > | < | = | + if next to a letter or int | - if next to a letter or int
        String[] tokens1 = monkeyLine.split("\\s+");
        List<String> tokenString = new ArrayList<>();
        for (String token: tokens1)
        {
            String[] array = token.split("(?=[(])|(?<=[(])|(?=[)])|(?<=[)])|" +
                    "(?=,)|(?<=,)|(?=>)|(?<=>)|(?=<)|(?<=<)|(?=[=])|(?<=[=])|(?<=[a-z0-9])(?=[+])|(?<=[+])(?=[a-z0-9])|" +
                    "(?<=[a-z0-9])(?=-)|(?<=-)(?=[a-z0-9])|(?=[*])|(?<=[*])|(?=[;])|(?<=[;])|" +
                    "(?<=[a-z0-9A-Z])(?=[/])|(?<=[/])(?=[a-z0-9A-Z])");



            tokenString.addAll(Arrays.asList(array));
        }


        return tokenString.stream().toArray(String[]::new);
    }

    public void buildTokenLinkedList()
    {
        List<String> tokenList = assembleTokenSentences(readFileLineByLine());
        int iterator = 0;

        for(String tokenListItem: tokenList)
        {
            String[] tokenWords = convertTokenSentenceToTokenWords(tokenListItem);
            Token token = new Token();
            token.setTokens(tokenWords);
            token.setType(labelTokenType(tokenWords));
            if(previousToken != null)
            {
                previousToken.setNextToken(token);
                previousToken = token;
            }
            if(iterator == 0){
                firstToken = token;
                previousToken = token;
                iterator++;
            }
        }
    }
    public String labelTokenType(String[] tokens)
    {
        List<String> list = Arrays.asList(tokens);

        if(list.contains("let") && list.contains("fn")){
            return "function";
        }
        if(list.contains("let"))
        {
            return "variable";
        }
        if(list.contains("};"))
        {
            return "closeMethod";
        }

        if(list.contains("{"))
        {
            return "openCurlyBraces";
        }
        if(list.contains(";"))
        {
            return "semi";
        }
        if(list.contains("+") || list.contains("-") || list.contains("/") || list.contains("*"))
        {
            return "return";
        }
        if(list.contains("}"))
        {
            return "closeCurlyBraces";
        }
        if(list.contains("(") && list.contains(")") && !list.contains("fn") && !list.contains("let"))
        {
            return "functionCall";
        }
        if(list.contains("(") && list.contains(")"))
        {
            return "default";
        }
        return null;
    }

    public static void main(String[] args) {

    }

}
