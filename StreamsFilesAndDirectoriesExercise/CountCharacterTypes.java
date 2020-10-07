package StreamsFilesAndDirectoriesExercise;

import java.io.*;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output1.txt";
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputPath));
            PrintWriter out = new PrintWriter(new FileWriter(outputPath));
            int oneByte = 0;
            int vowels = 0;
            int punctuation = 0;
            int consonants = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte == (int) 'a' || oneByte == (int) 'e'
                || oneByte == (int) 'i' || oneByte == (int) 'o'
                || oneByte == (int) 'u') {
                    System.out.print((char)oneByte);
                    vowels++;
                } else if (oneByte == (int) '!' || oneByte == (int) ','
                || oneByte == (int) '.' || oneByte == (int) '?') {
                    System.out.print((char)oneByte);
                    punctuation++;
                }else if (oneByte == 10) {
                   // System.out.print(" newLine ");
                } else if (oneByte == 32) {
                   // System.out.print(" space ");
                } else if (oneByte == 13) {
                    //System.out.print(" carriageReturn ");
                } else {
                    System.out.print((char) oneByte);
                    consonants++;
                }
            }
            out.write("Vowels: ");
            out.write(String.valueOf(vowels));
            out.write('\n');
            out.write("Consonants: ");
            out.write(String.valueOf(consonants));
            out.write('\n');
            out.write("Punctuation: ");
            out.write(String.valueOf(punctuation));
            out.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
