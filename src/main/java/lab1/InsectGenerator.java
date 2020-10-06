package lab1;

import java.util.Random;

public class InsectGenerator {

    private InsectGenerator() {
    }

    private static final String[] names = {"fly", "mosquito", "spider", "tarantula"};

    public static Insect[] createRandomInsects(int number) {
        Insect[] insects = new Insect[number];

        Random r = new Random();
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
}
