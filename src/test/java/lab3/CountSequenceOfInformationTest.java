package lab3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountSequenceOfInformationTest {
    private Scanner scanner;

    @BeforeEach
    public void initializeScanner() {
        try {
            scanner = new Scanner(new File("src/main/java/lab3/govern.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testExample1() {
        CountSequenceOfInformation counter = new CountSequenceOfInformation();
        counter.execute("src/main/java/lab3/govern.in");

        List<String> expected = new ArrayList<>();
        expected.add("foreignpassport");
        expected.add("visa");
        for (String expectedLine : expected) {
            assertEquals(expectedLine, scanner.nextLine());
        }
    }

    @Test
    void testExample2() {
        CountSequenceOfInformation counter = new CountSequenceOfInformation();
        counter.execute("src/main/java/lab3/govern2.in");

        List<String> expected = new ArrayList<>();

        expected.add("birthcertificate");
        expected.add("nationalpassport");
        expected.add("militarycertificate");
        expected.add("creditcard");
        expected.add("bankstatement");
        expected.add("hotel");
        expected.add("foreignpassport");
        expected.add("visa");
        for (String expectedLine : expected) {
            assertEquals(expectedLine, scanner.nextLine());
        }
    }
}
