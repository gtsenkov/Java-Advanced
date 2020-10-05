package StreamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream fileStream = new FileInputStream(path);
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.print(String.format("%s ", Integer.toBinaryString(oneByte)));
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}
