package StreamsFilesAndDirectoriesExercise;

import java.io.*;
import java.util.Scanner;

public class LineNumbers {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output2.txt";
//        try {
//            BufferedReader in = new BufferedReader(new FileReader(inputPath));
//            PrintWriter out = new PrintWriter(new FileWriter(outputPath));
//            int counter = 1;
//            String line = in.readLine();
//            while (line != null) {
//                out.write((counter) + ". ");
//                out.println(line);
//                counter++;
//                System.out.println(line);
//                line = in.readLine();
//            }
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    }
        try {

            BufferedReader in = new BufferedReader(new FileReader(inputPath));
            PrintWriter out = new PrintWriter(new FileWriter(outputPath));

            String readLine = null;
            int counter = 0;
            while ((readLine = in.readLine()) != null) { //
                System.out.println(readLine);
                counter++;
                out.write((counter) + ". ");
                out.println(readLine);
            }
            in.close();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

