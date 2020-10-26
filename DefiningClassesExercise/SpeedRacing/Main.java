package DefiningClassesExercise.SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String model = input[0];
            int fuelAmount = Integer.parseInt(input[1]);
            double fuelConsumptionPerKm = Double.parseDouble(input[2]);
            Car car = new Car(model, fuelAmount, fuelConsumptionPerKm);
            cars.put(model, car);
        }

        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String action = tokens[0];
            String model = tokens[1];
            int distanceToTravel = Integer.parseInt(tokens[2]);

            if (action.equals("Drive")) {
                cars.get(model).drive(distanceToTravel);
            }
            input = scan.nextLine();
        }

        cars.forEach((s, car) -> System.out.printf("%s %.2f %.0f%n", s, car.getFuelAmount(), car.getTraveledKm()));
    }
}
