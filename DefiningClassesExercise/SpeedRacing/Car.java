package DefiningClassesExercise.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelConsumptionPerKm;
    private double canTravel;
    private double traveledKm;

    public Car(String model, int fuelAmount, double fuelConsumptionPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
        this.traveledKm = 0;
        setCanTravel();
    }

    public void setCanTravel() {
        this.canTravel = getFuelAmount() / getFuelConsumptionPerKm();
    }

    public void setTraveledKm(double traveledKm) {
        this.traveledKm = traveledKm;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelAmount() {
        return this.fuelAmount;
    }

    public double getFuelConsumptionPerKm() {
        return this.fuelConsumptionPerKm;
    }

    public double getTraveledKm() {
        return this.traveledKm;
    }

    public double getCanTravel() {
        return this.canTravel;
    }

    public void drive(int distanceToTravel) {
        if (distanceToTravel <= getCanTravel()) {
            double fuelConsumed = distanceToTravel * getFuelConsumptionPerKm();
            setFuelAmount(getFuelAmount() - fuelConsumed);
            double traveledKmUpdate = getTraveledKm() + distanceToTravel;
            setTraveledKm(traveledKmUpdate);
            setCanTravel();

        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }


}
