package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WriteToFile {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        List<Character> symbolsToRemove = new ArrayList<>();
        Collections.addAll(symbolsToRemove, '.', ',', '!', '?');
        try {
            InputStream in = new FileInputStream(inputPath);
            OutputStream out = new FileOutputStream(outputPath);
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (!symbolsToRemove.contains((char) oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
