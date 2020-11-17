package lab4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CountMinNumberOfPartsTest {
    private Scanner scanner;

    @BeforeEach
    public void initializeScanner() {
        try {
            scanner = new Scanner(new File("src/main/java/lab4/test_files/fantz.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    void testExample1() {
        testTemplate("src/main/java/lab4/test_files/fantz1.in", "3");
    }

    @Test
    void testExample2() {
        testTemplate("src/main/java/lab4/test_files/fantz2.in", "1");
    }

    @Test
    void testExample3() {
        testTemplate("src/main/java/lab4/test_files/fantz3.in", "3");
    }
    @Test
    void testExample4() {
        testTemplate("src/main/java/lab4/test_files/fantz4.in", "7");
    }

    private void testTemplate(String pathToFile, String expected) {
        CountMinNumberOfParts count = new CountMinNumberOfParts();
        count.evaluate(pathToFile);
        assertEquals(expected, scanner.nextLine());
    }

}
