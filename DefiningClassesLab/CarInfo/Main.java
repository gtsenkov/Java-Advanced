package DefiningClassesLab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        while (n-- > 0) {
            String[] tokens =scan.nextLine().split(" ");
            String brand = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);

            Car car = new Car();

            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            cars.add(car);
        }
        for (Car car : cars) {
            System.out.println(car.carInfo());
        }

    }
}
