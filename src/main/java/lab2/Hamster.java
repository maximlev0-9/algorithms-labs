package lab2;

import lombok.Data;

@Data
public class Hamster {
    private int id;
    private int dailyNorm;
    private int greediness;

    public Hamster(int id, int dailyNorm, int greediness) {
        this.id = id;
        this.dailyNorm = dailyNorm;
        this.greediness = greediness;
    }

    public int getOverallAmountOfFood(int numberOfHamsters){
        return dailyNorm + greediness * (numberOfHamsters-1);
    }
}
