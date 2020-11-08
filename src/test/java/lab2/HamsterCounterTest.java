package lab2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HamsterCounterTest {

    private Scanner scanner;

    @BeforeEach
    public void initializeScanner(){
        try {
            scanner = new Scanner(new File("src/main/java/lab2/hamstr.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testWithExample1() {
        testMethod("src/main/java/lab2/hamstr.in", "3");
    }

    @Test
    void testWithExample2() {
        testMethod("src/main/java/lab2/hamstr2.in", "2");
    }

    @Test
    void testWithExample3() {
        testMethod("src/main/java/lab2/hamstr3.in", "1");
    }

    private void testMethod(String pathToFile, String expected) {
        HamsterCounter hamsterCounter = new HamsterCounter();
        hamsterCounter.countMaxPossibleHamsters(pathToFile);
        assertEquals(expected, scanner.nextLine());
    }

}
