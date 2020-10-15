package SetsAndMapsAdvancedLab;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String command = "";
        String licensePlate = "";
        Set<String> cars = new LinkedHashSet<>();
        while (!input.equals("END")) {
            command = input.substring(0, input.indexOf(","));
            licensePlate = input.substring(input.indexOf(",") + 2);
            if (command.equals("IN")) {
                cars.add(licensePlate);
            } else {
                cars.remove(licensePlate);
            }
            input = scan.nextLine();
        }
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }
}
