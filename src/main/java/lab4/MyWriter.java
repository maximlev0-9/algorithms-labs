package lab4;

import java.io.File;
import java.io.FileWriter;

public class MyWriter {
    public void writeToFile(int minNumberOfSplits) {
        try (FileWriter fileWriter = new FileWriter(new File("src/main/java/lab4/test_files/fantz.out"))) {
            fileWriter.write(""+minNumberOfSplits);
            fileWriter.flush();
        } catch (Exception ignored) {
        }
    }
}
