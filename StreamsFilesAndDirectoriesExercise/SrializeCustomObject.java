package StreamsFilesAndDirectoriesExercise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class SrializeCustomObject {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        String path = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\object.ser";


        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path)
        )) {
            Course course = new Course("Java Advanced", 146);
            objectOutputStream.writeObject(numbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Course implements Serializable {
        private String name;

        private Integer students;

        public Course(String name, Integer students) {
            this.name = name;
            this.students = students;
        }
    }
}
