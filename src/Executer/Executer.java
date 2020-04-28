package Executer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Executer {

 public void excut(){
        String command = "python output.py";


        try {
            Process process = Runtime.getRuntime().exec(command);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.print(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
