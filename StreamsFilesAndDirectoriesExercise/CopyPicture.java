package StreamsFilesAndDirectoriesExercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) {
        String picture = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\Google.jpg";
        String copyPicture = "C:\\Users\\Gosho\\IdeaProjects\\JavaAdvanced\\src\\StreamsFilesAndDirectoriesExercise\\copy-picture.jpg";
        try  {
            FileInputStream inputStream = new FileInputStream(new File(picture));
            FileOutputStream outputStream = new FileOutputStream(new File(copyPicture));
            byte[] buffer = new byte[1024];

            int read = 0;
            while ((read = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, read);
            }


        } catch (IOException e) {
                e.printStackTrace();
        }

    }
}
