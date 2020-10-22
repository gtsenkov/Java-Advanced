package DefiningClassesExercise.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Map<String, Engine> engineMap = new LinkedHashMap<>();
        List<Car> carList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String engineModel = input[0];
            String power = input[1];
            int displacement = 0;
            Engine currentEngine = null;
            if (input.length == 2) {
                currentEngine = new Engine(engineModel, power);
            }
            else if (input.length == 3) {
                try {
                    displacement = Integer.parseInt(input[2]);
                    currentEngine = new Engine(engineModel, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = input[2];
                    currentEngine = new Engine(engineModel, power, efficiency);
                }
            }
            else if (input.length == 4) {
                displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                currentEngine = new Engine(engineModel, power, displacement, efficiency);
            }
            engineMap.put(engineModel, currentEngine);
        }

        int m = Integer.parseInt(scan.nextLine());
        Car car = null;

        for (int i = 0; i < m; i++) {
            String[] input = scan.nextLine().split(" ");
            String carModel = input[0];
            Engine engineModel = engineMap.get(input[1]);
            String color = "";
            int weight = 0;

            if (input.length == 2) {
                car = new Car(carModel, engineModel);
            } else if (input.length == 3) {
                try {
                    weight = Integer.parseInt(input[2]);
                    car = new Car(carModel, engineModel, weight);
                } catch (NumberFormatException e) {
                    color = input[2];
                    car = new Car(carModel, engineModel, color);
                }
            } else {
                weight = Integer.parseInt(input[2]);
                color = input[3];
                car = new Car(carModel, engineModel, weight, color);

            }
            carList.add(car);
        }
        System.out.printf("");
        for (Car currentCar : carList) {
            System.out.println(currentCar.getCarModel() + ":");
            System.out.println(currentCar.getEngine().toString());
            if (currentCar.getWeight() != 0) {
                System.out.println("Weight: " + currentCar.getWeight());
            } else {
                System.out.println("Weight: n/a");
            }
            if (currentCar.getColor() != null) {
                System.out.println("Color: " + currentCar.getColor());
            } else {
                System.out.println("Color: n/a");
            }
        }
    }
}
