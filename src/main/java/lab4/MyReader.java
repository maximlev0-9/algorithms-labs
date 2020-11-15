package lab4;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Getter
public class MyReader {
    public String[] readFrom(String pathToFile) {
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            String input = scanner.nextLine();
            String[] values = input.split(" ");
            return values;
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return new String[]{"","0"};
    }
}

