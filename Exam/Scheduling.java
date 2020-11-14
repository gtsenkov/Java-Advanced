package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> stackTasks = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stackTasks::push);

        ArrayDeque<Integer> queueThreads = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));




        int taskToBeKilled = Integer.parseInt(scan.nextLine());
        boolean isFound = false;
        int killingThread = 0;


        while (!isFound && !queueThreads.isEmpty() && !stackTasks.isEmpty()) {
           int currentThread = queueThreads.peek();
           int currentTask = stackTasks.peek();

            if (currentThread >= currentTask) {
                if (currentTask == taskToBeKilled) {
                    killingThread = currentThread;
                    break;
                }
                queueThreads.poll();
                stackTasks.pop();
            } else if (currentTask == taskToBeKilled) {
                killingThread = currentThread;
                stackTasks.pop();
                break;
            } else {
                queueThreads.poll();
            }
        }

        System.out.println(String.format("Thread with value %d killed task %d"
                                            , killingThread, taskToBeKilled));

        for (Integer queueThread : queueThreads) {
            System.out.print(queueThread + " ");
        }
    }
}
