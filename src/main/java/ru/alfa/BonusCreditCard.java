package ru.alfa;

/**
 * Клас кредитной карты с бонусными опциями
 */
public class BonusCreditCard extends CreditCard {

    /**
     * Метод для проведения платежа по кредитной карте с бонусными опциями.
     * Расширяет метод pay простой кредитной карты за счет начисления кэшбэка и бонусов.
     *
     * @param amount значение суммы платежа
     * @return возвращает true в случае успешного списания средств
     */
    @Override
    public boolean pay(double amount) {
        if (amount > 0) {
            if (balance - amount >= 0) {
                balance = balance - amount;
                System.out.println("Credit card payed " + amount);
                cashingBack(amount);
                return true;
            } else if (creditBalance + (balance - amount) >= 0) {
                creditBalance = creditBalance + (balance - amount);
                balance = 0;
                System.out.println("Credit card payed " + amount);
                cashingBack(amount);
                return true;
            } else {
                System.out.println("Credit card pay failed");
                return false;
            }
        } else {
            System.out.println("Credit card pay failed");
            return false;
        }

    }

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
                saving(amount);
                return true;
            } else if (creditBalance + amount <= limit) {
                creditBalance = creditBalance + amount;
                System.out.println("Credit card successfully top up for " + amount);
                saving(amount);
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
                "\nCredit balance: " + creditBalance + "\nCashBack balance: " + cashBackBalance + "\nBonus balance: " + bonusBalance + "\nSaving balance: " + savingsBalance);
    }


}
