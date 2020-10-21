package DefiningClassesLab.Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand, String model) {
        this(brand, model, -1);
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }

    public String carInfo() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(),
                this.getModel(), this.getHorsePower());
    }
}


