import Executer.Executer;
import Executer.TokenParserConnector;
import tokenizer.Tokenizer;

import java.io.*;
import java.util.List;

public class Interpreter {

    public static void main(String[] args){
        TokenParserConnector connector = new TokenParserConnector();
        try {
            connector.Connection();

        }  catch (Exception e) {
            e.printStackTrace();
        }

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
//        System.out.println("The monkey code: ");
//        try {
//            connector.readInputFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        System.out.println("Output: ");

        //Call executer to show the output
        Executer executer = new Executer();
        executer.excut();


    }



}


