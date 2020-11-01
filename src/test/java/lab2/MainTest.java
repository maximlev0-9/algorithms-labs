package lab2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

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
        String pathToFile = "src/main/java/lab2/hamstr.in";
        Main m = new Main();
        m.countMaxPossibleHamsters(pathToFile);
        assertEquals("3", scanner.nextLine());
    }
    @Test
    void testWithExample2() {
        String pathToFile = "src/main/java/lab2/hamstr2.in";
        Main m = new Main();
        m.countMaxPossibleHamsters(pathToFile);
        assertEquals("2", scanner.nextLine());
    }
    @Test
    void testWithExample3() {
        String pathToFile = "src/main/java/lab2/hamstr3.in";
        Main m = new Main();
        m.countMaxPossibleHamsters(pathToFile);
        assertEquals("1", scanner.nextLine());
    }

}
