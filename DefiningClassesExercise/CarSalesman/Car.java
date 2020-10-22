package DefiningClassesExercise.CarSalesman;

public class Car {
    private String carModel;
    private Engine Engine;
    private int weight;
    private String color;

    public String getCarModel() {
        return carModel;
    }

    public Engine getEngine() {
        return Engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Car(String carModel, Engine engineModel) {
        this.carModel = carModel;
        Engine = engineModel;
    }

    public Car(String carModel, Engine engineModel, int weight) {
        this(carModel, engineModel);
        this.weight = weight;
    }

    public Car(String carModel, Engine engineModel, String color) {
        this(carModel, engineModel);
        this.color = color;
    }

    public Car(String carModel, Engine engineModel, int weight, String color) {
        this(carModel, engineModel);
        this.weight = weight;
        this.color = color;
    }

}
