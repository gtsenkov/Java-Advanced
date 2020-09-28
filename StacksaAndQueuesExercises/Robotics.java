package StacksaAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] robots = scan.nextLine().split(";");
        Map<String, Integer> robotData = new LinkedHashMap<>();
        for (String robot : robots) {
            String[] robotSpec = robot.split("-");
            String robotName = robotSpec[0];
            int robotProcessingTime = Integer.parseInt(robotSpec[1]);
            robotData.putIfAbsent(robotName, robotProcessingTime);
        }
        String[] time = scan.nextLine().split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        int timeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> products = new ArrayDeque<>();
        String details = scan.nextLine();
        while (!details.equals("End")) {
            products.offer(details);
            details = scan.nextLine();
        }
        int[] workingTime = new int[robots.length];
        while (!products.isEmpty()) {
            String currentProduct = products.poll();
            timeInSeconds++;
            boolean isAssigned = false;
            for (int i = 0; i < robots.length; i++) {
                if (workingTime[i] > 0) {
                    workingTime[i]--;
                }
            }
            for (int i = 0; i < robots.length; i++) {
                if (workingTime[i] == 0) {
                    int robotSequentNumber = 0;
                    for (Map.Entry<String, Integer> entry : robotData.entrySet()) {
                        if (robotSequentNumber == i) {
                            workingTime[i] = entry.getValue();
                            int logHours = timeInSeconds / 3600 % 24;
                            int logMinutes = timeInSeconds % 3600 / 60;
                            int logSeconds = timeInSeconds % 60;
                            System.out.printf("%s - %s [%02d:%02d:%02d]%n", entry.getKey(), currentProduct, logHours, logMinutes, logSeconds);
                            isAssigned = true;
                            break;
                        }
                        robotSequentNumber++;
                    }
                  break;
                }
            }
            if (!isAssigned) {
                products.offer(currentProduct);
            }
        }
    }
}
