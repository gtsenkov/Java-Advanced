package DefiningClassesLab.BankAccount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];

            if (command.equals("Create")) {
                BankAccount currentBankAccount = new BankAccount();
                bankAccountMap.put(currentBankAccount.getID(), currentBankAccount);
            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccountMap.containsKey(id)) {
                    BankAccount currentBankAccount = bankAccountMap.get(id);
                    currentBankAccount.deposit(Double.parseDouble(tokens[2]));
                } else {
                    System.out.println("Account does not exist");
                }
            } else if (command.equals("SetInterest")) {
                double newInterest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(newInterest);
            } else {
                int id = Integer.parseInt(tokens[1]);
                if (bankAccountMap.containsKey(id)) {
                    BankAccount currentBankAccount = bankAccountMap.get(id);
                    System.out.println(String.format("%.2f", currentBankAccount.getInterestRate(Integer.parseInt(tokens[2]))));
                } else {
                    System.out.println("Account does not exist");
                }
            }
            input = scan.nextLine();
        }
    }
}
