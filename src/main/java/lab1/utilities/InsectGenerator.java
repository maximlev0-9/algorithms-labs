package lab1.utilities;

import lab1.model.Insect;

import java.util.Random;
import java.util.stream.Stream;

public class InsectGenerator {
    private static Random r = new Random();

    private InsectGenerator() {
    }

    private static final String[] names = {"fly", "mosquito", "spider", "tarantula"};

    public static Insect[] createRandomInsects(int number) {
        Insect[] insects = new Insect[number];

        String name;
        double velocity;
        int weight;
        for (int i = 0; i < number; i++) {
            name = names[r.nextInt(4)];
            velocity = r.nextDouble();
            weight = r.nextInt(100);
            insects[i] = new Insect(name, velocity, weight);
        }
        return insects;

    }

    public static void main(String[] args) {
        Stream.of(createRandomInsects(6)).forEach(System.out::println);
    }
}
