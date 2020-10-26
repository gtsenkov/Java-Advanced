package DefiningClassesExercise.RawData;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Car> carsMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Engine currentEngine = new Engine(engineSpeed, enginePower);
            Cargo currentCargo = new Cargo(cargoWeight, cargoType);
            Tires currentTires = new Tires(tire1Pressure, tire1Age, tire2Pressure, tire2Age,
                    tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car currentCar = new Car(model, currentEngine, currentCargo, currentTires);
            carsMap.put(model, currentCar);
        }

        String command = scan.nextLine();

        if (command.equals("fragile")) {
            carsMap.entrySet().forEach(car ->{
                if (car.getValue().getCargo().getCargoType().equals("fragile") &&
                        (car.getValue().getTires().getTire1Pressure() < 1 ||
                        car.getValue().getTires().getTire2Pressure() < 1 ||
                        car.getValue().getTires().getTire3Pressure() < 1 ||
                        car.getValue().getTires().getTire4Pressure() < 1)) {
                    System.out.println(car.getKey());
                }
            });
        } else if (command.equals("flamable")) {
            carsMap.entrySet().forEach(car ->{
                if (car.getValue().getCargo().getCargoType().equals("flamable") &&
                car.getValue().getEngine().getEnginePower() > 250) {
                    System.out.println(car.getKey());
                }
            });
        }

    }
}
