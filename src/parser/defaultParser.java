package parser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class defaultParser {

    public static void parse(String[]tokenWords) throws FileNotFoundException {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("output.py", true));
            PrintStream console = System.out;
            System.setOut(out);

            int pos;

            for (pos = 0; pos <= tokenWords.length - 1; pos++) {

                System.out.print(tokenWords[pos] + " ");
            }
            out.close();
        }
        catch(IOException e1) {
            System.out.println("Error during reading/writing");
        }
    }
}




