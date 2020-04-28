package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FunctionCall {

    public static void parse(String[]tokenWords) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("output.py", true));
            PrintStream console = System.out;
            System.setOut(out);

            System.out.print("print(");

            int pos;

            for (pos = 0; pos <= tokenWords.length - 1; pos++) {

                System.out.print(tokenWords[pos] + " ");
            }
            System.out.println(")");
            out.close();
        }
        catch(IOException e1) {
            System.out.print("Error during reading/writing");
        }
    }
}

