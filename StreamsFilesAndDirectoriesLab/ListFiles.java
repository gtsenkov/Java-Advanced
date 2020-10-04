package StreamsFilesAndDirectoriesLab;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File eachFile : files) {
                    if (!eachFile.isDirectory()) {
                        System.out.println(String.format("%s: [%s]", eachFile.getName(), eachFile.length()));
                    }
                }
            }
        }
    }
}
