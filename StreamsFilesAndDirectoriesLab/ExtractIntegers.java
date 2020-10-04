package StreamsFilesAndDirectoriesLab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        try {
            Scanner scan = new Scanner(new FileInputStream(inputPath));
            PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));
            int oneByte = 0;
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    out.println(scan.nextInt());
                }
                scan.next();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
