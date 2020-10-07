package lab1.model;

public class Insect {
    private String name;
    private double velocityInMeters;
    private int weightInGrams;

    public Insect(String name, double velocityInMeters, int weightInGrams) {
        this.name = name;
        this.velocityInMeters = velocityInMeters;
        this.weightInGrams = weightInGrams;
    }

//    @Override
//    public String toString() {
//        return "Insect{" +
//                "name='" + name + '\'' +
//                ", velocityInMeters=" + velocityInMeters +
//                ", weightInGrams=" + weightInGrams +
//                '}';
//
//   }

    @Override
    public String toString() {
        return name + "," + velocityInMeters + "," + weightInGrams;

    }

        public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVelocityInMeters() {
        return velocityInMeters;
    }

    public void setVelocityInMeters(double velocityInMeters) {
        this.velocityInMeters = velocityInMeters;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }
}
