package StreamsFilesAndDirectoriesExercise;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String file2 = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String file3 = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputThird.txt";

        try (FileWriter fileWriter = new FileWriter(new File(file3))) {
            List<String> fileOne = Files.readAllLines(Path.of(file1));
            List<String> fileTwo = Files.readAllLines(Path.of(file2));

            for (String word : fileOne) {
                fileWriter.write(word + "\n");
                fileWriter.flush();
            }
            for (String word : fileTwo) {
                fileWriter.write(word + "\n");
                fileWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
