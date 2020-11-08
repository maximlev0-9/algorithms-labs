package lab2;

import java.io.File;
import java.io.FileWriter;

public class MyWriter {
    public void writeToFile(int maxNumberOfHamsters) {
        try (FileWriter fileWriter = new FileWriter(new File("src/main/java/lab2/hamstr.out"))) {
            fileWriter.write("" + maxNumberOfHamsters);
            fileWriter.flush();
        } catch (Exception ignored) {
        }
    }
}
