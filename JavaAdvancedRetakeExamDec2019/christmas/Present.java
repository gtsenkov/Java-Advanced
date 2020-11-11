package JavaAdvancedRetakeExamDec2019.christmas;

public class Present {

    private String name;
    private double weight;
    private String gender;

    public Present(String name, double weight, String gender) {
        this.name = name;
        this.weight = weight;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Present " + getName() + " (" + String.format("%.2f",getWeight()) + ") for a " + getGender();
    }
}
