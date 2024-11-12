package ru.alfa;

public class DebitCard extends BankCard {
    protected double debitAccount;

    public void setDebitAccount(double amount) {
        this.debitAccount = amount;
    }

    @Override
    public double getBalance() {
        return debitAccount;
    }

    @Override
    public boolean pay(double amount) {
        if (!canPay(amount)) {
            return false;
        }
        debitAccount -= amount;
        return true;
    }

    @Override
    public boolean fill(double amount) {
        if (amount < 0) {
            return false;
        }
        debitAccount += amount;
        return true;
    }

    @Override
    public String info() {
        return "Balance: " + debitAccount;
    }
}
