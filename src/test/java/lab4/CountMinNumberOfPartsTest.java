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
        CountMinNumberOfParts count = new CountMinNumberOfParts();
        count.evaluate("src/main/java/lab4/test_files/fantz1.in");
        assertEquals(3,Integer.parseInt(scanner.nextLine()));
    }

    @Test
    void testExample2() {
        CountMinNumberOfParts count = new CountMinNumberOfParts();
        count.evaluate("src/main/java/lab4/test_files/fantz2.in");
        assertEquals("1",scanner.nextLine());
    }

    @Test
    void testExample3() {
        CountMinNumberOfParts count = new CountMinNumberOfParts();
        count.evaluate("src/main/java/lab4/test_files/fantz3.in");
        assertEquals("3",scanner.nextLine());
    }

    @Test
    void testExample4() {
        CountMinNumberOfParts count = new CountMinNumberOfParts();
        count.evaluate("src/main/java/lab4/test_files/fantz4.in");
        assertEquals("5",scanner.nextLine());
    }
}
