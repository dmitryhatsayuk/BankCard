package ru.alfa;

//карта с бонусной программой в виде накоплений
public class BonusDebitCard extends DebitCard {

    private double savingsAccount;

    //поскольку бонусная программа будет касаться только пополнений, то переопределим метод fill
    @Override
    public boolean fill(double amount) {
        if (amount < 0) {
            return false;
        }
        debitAccount += amount;
        saving(amount);
        return true;
    }

    @Override
    public String info() {
        return "Balance: " + debitAccount + "\nSavings: " + savingsAccount;
    }


    private void saving(double amount) {
        savingsAccount = savingsAccount + amount * 0.00005;
    }


}
