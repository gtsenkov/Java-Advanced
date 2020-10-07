package StreamsFilesAndDirectoriesExercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

        File file = new File(path);

        int size = 0;
        for (File currentFile : file.listFiles()) {
            size += currentFile.length();
        }

        System.out.println("Folder size: " + size);
    }
}
