package Executer;

import parser.MasterParser;
import tokenizer.Token;
import tokenizer.Tokenizer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TokenParserConnector {

    public void Connection() throws IOException {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.buildTokenLinkedList();

        Token token = tokenizer.getFirstToken();
        MasterParser masterParser = new MasterParser();

        BufferedWriter outputFile = new BufferedWriter(new FileWriter("output.py"));
        outputFile.close();

        masterParser.acceptToken(token);
    }



}
