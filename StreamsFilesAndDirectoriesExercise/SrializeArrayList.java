package StreamsFilesAndDirectoriesExercise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class SrializeArrayList {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        String path = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\list.ser";


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path)
        )) {
           objectOutputStream.writeObject(numbers);
//            for (Integer number : numbers) {
//                objectOutputStream.writeObject(number);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
