package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class ALLCAPITALS {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputPath));
            PrintWriter out = new PrintWriter(new FileWriter(outputPath));
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (Character.isLowerCase(oneByte)) {
                    out.write(Character.toUpperCase(oneByte));
                } else {
                    out.write(oneByte);
                }
            }
            out.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
