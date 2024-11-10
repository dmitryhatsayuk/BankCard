package ru.alfa;

/**
 * Клас кредитной карты с бонусными опциями в виде накоплений
 */
public class BonusCreditCard extends CreditCard {
final private double savingAmount = 0.00001;

    /**
     * Метод для пополнения кредитной карты с бонусными опциями.
     * Переопределен от метода стандартной кредитной карты.
     *
     * @param amount - значение суммы пополнения
     * @return возвращает true в случае успешного пополнения
     */
    @Override
    public boolean upBalance(double amount) {

        if (amount > 0) {
            if (creditBalance + amount > limit) {
                balance = balance + amount - (limit - creditBalance);
                creditBalance = limit;
                System.out.println("Credit card successfully top up for " + amount);
                saving(amount,savingAmount);
                return true;
            } else if (creditBalance + amount <= limit) {
                creditBalance = creditBalance + amount;
                System.out.println("Credit card successfully top up for " + amount);
                saving(amount,savingAmount);
                return true;
            } else {
                System.out.println("Up balance failed");
                return false;
            }
        } else {
            System.out.println("Up balance failed");
            return false;
        }

    }

    @Override
    public void showInfo() {
        System.out.println("*** This is a Credit card with bonuses! ***" +
                "\nDebit balance:" + balance +
                "\nCard limit: " + limit +
                "\nCredit balance: " + creditBalance + "\nSaving balance: " + savingsBalance);
    }


}
