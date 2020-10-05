package StreamsFilesAndDirectoriesLab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException {
        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Mimi", "Gosho");
        String path = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesLab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\ser.txt";

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(names);

        objectOutputStream.close();
    }
}
