package DefiningClassesLab.BankAccount;

import java.text.DecimalFormat;

class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;
    private static int idCounter = 1;

    BankAccount(){
        this.id = idCounter++;
        System.out.println("Account ID" + this.id + " created");
    }

    public int getID() {
        return this.id;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterestRate(int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
        DecimalFormat depositFormat = new DecimalFormat("#");
        String formattedValue = depositFormat.format(amount);

        System.out.println("Deposited " + formattedValue + " to ID" + this.id);
    }

    int getId() {
       return this.id;
    }
}
