package DefiningClassesExercise.CarSalesman;

public class Engine {
    private String engineModel;
    private String power;
    private int displacement;
    private String efficiency;

    public Engine(String engineModel, String power) {
        this.engineModel = engineModel;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, String power, int displacement) {
        this(engineModel, power);
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    public Engine(String engineModel, String power, String efficiency) {
        this(engineModel, power);
        this.efficiency = efficiency;
        this.displacement = 0;
    }
    public Engine(String engineModel, String power, int displacement, String efficiency) {
        this(engineModel, power);
        this.efficiency = efficiency;
        this.displacement = displacement;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.engineModel + ":\n");
        stringBuilder.append("Power: " + this.power + "\n");
        if (this.displacement == 0) {
            stringBuilder.append("Displacement: n/a" + "\n");
        } else {
            stringBuilder.append("Displacement: " + this.displacement + "\n");
        }
        stringBuilder.append("Efficiency: " + this.efficiency);
        return stringBuilder.toString();
    }
}
