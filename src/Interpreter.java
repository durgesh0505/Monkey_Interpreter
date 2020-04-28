import Executer.Executer;
import Executer.TokenParserConnector;
import java.io.*;

public class Interpreter {

    public static void main(String[] args){
        TokenParserConnector connector = new TokenParserConnector();
        try {
            connector.Connection();

        }  catch (Exception e) {
            e.printStackTrace();
        }

        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        Executer executer = new Executer();
        executer.excut();


    }

}


