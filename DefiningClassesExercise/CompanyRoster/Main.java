package DefiningClassesExercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Department> departmentsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String departmentName = input[3];

            Department department = null;
            boolean departmentExist = false;
            if (departmentsList.isEmpty()) {
                department = new Department(departmentName);
                departmentsList.add(department);
            } else {
                for (Department currentDepartment : departmentsList) {
                    if (currentDepartment.getDepartmentName().equals(departmentName)) {
                        departmentExist = true;
                        department = currentDepartment;
                        break;
                    }
                }
                if (!departmentExist) {
                    department = new Department(departmentName);
                    departmentsList.add(department);
                }
            }

            Employee employee = null;
            if (input.length == 4) {
                employee = new Employee(name, salary, position, department);
            } else if (input.length == 5) {
                try {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            } else if (input.length == 6) {
                int age = Integer.parseInt(input[5]);
                String email = input[4];
                employee = new Employee(name, salary, position, department, email, age);
            }

            for (int j = 0; j < departmentsList.size(); j++) {

                if (employee.getDepartment().getDepartmentName().equals(departmentsList.get(j).getDepartmentName())) {
                    List<Employee> employees = departmentsList.get(j).getEmployees();
                    employees.add(employee);
                    departmentsList.get(j).setEmployees(employees);
                    break;
                }
            }
        }
        double highestSalary = 0;
        Department highestPaid = null;
        for (Department department : departmentsList) {
            double avgSalary = department.getEmployees().stream()
                    .mapToDouble(Employee::getSalary)
                    .average().orElse(0);
            if (avgSalary > highestSalary) {
                highestSalary = avgSalary;
                highestPaid = department;
            }
        }

        System.out.println(String.format("Highest Average Salary: %s", highestPaid.getDepartmentName()));
        highestPaid.getEmployees().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> {
                    System.out.println(String.format("%s %.2f %s %d", employee.getName(), employee.getSalary(),
                            employee.getEmail(), employee.getAge()));
                });
    }


}
