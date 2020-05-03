package Executer;

import parser.MasterParser;
import tokenizer.Token;
import tokenizer.Tokenizer;

import java.io.*;

import static java.lang.String.valueOf;

public class TokenParserConnector {

    //connect the tokenizer and parser. save the result to the output
    public void Connection() throws IOException {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.buildTokenLinkedList();

        Token token = tokenizer.getFirstToken();
        MasterParser masterParser = new MasterParser();

        BufferedWriter outputFile = new BufferedWriter(new FileWriter("output.py"));
        outputFile.close();

        masterParser.acceptToken(token);
    }

    //Read file line by line and prints out
    public static void readInputFile() throws IOException {
        StringBuilder input = new StringBuilder();
        try (BufferedReader inputFileReader = new BufferedReader(new FileReader("input.txt"))) {
            String sCurrentLine;
            while ((sCurrentLine = inputFileReader.readLine()) != null) {
                input.append(sCurrentLine).append("\n");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(valueOf(input) + "\n");
    }



}
