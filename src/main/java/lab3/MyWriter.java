package lab3;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class MyWriter {
    public void writeToFile(List<String> output) {
        try (FileWriter fileWriter = new FileWriter(new File("src/main/java/lab3/govern.out"))) {
            for (String answer :
                    output) {
                fileWriter.write(answer + "\n");
            }
            fileWriter.flush();
        } catch (Exception ignored) {
        }
    }
}

