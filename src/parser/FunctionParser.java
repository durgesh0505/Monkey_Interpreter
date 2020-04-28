package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FunctionParser {

    public static void parse(String[]tokenWords) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("output.py", true));
            PrintStream console = System.out;
            System.setOut(out);



            int pos;
            System.out.print("def ");

            for (pos = 0; pos <= tokenWords.length-1; pos++) {
                if (tokenWords[pos].equals("let") ||  tokenWords[pos].equals("=") || tokenWords[pos].equals("fn")) {
                    System.out.print("");
                } else {
                    System.out.print(tokenWords[pos]+ " ");
                }
            }
            System.out.print(":\n\t");
            out.close();
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }


}

