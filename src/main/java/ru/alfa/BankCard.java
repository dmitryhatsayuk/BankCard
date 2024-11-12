package ru.alfa;

public abstract class BankCard {
    public abstract double getBalance();

    public boolean canPay(double amount) {
        if (amount < 0) {
            return false;
        }
//проверяем достаточно ли у нас всех доступных средств
        return !(amount > this.getBalance());
    }

    public abstract boolean pay(double amount);

    public abstract boolean fill(double amount);

    public abstract String info();
}
