package ru.alfa;

/**
 * Абстрактный класс карты
 */
abstract class BankCard {
    /**
     * Поле баланса основных средств
     */
    protected double balance;
    /**
     * Поле баланса кэшбэка
     */
    protected double cashBackBalance;
    /**
     * Поле бонусного баланса
     */
    protected double bonusBalance;
    /**
     * Поле баланса накоплений
     */
    protected double savingsBalance;

    /**
     * Метод для проведения платежа по карте
     *
     * @param amount - сумма платежа
     * @return возвращает true в случае успешного списания средств
     */
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Payment successful for " + amount);
            return true;
        } else {
            System.out.println("Payment failed");
            return false;
        }
    }

    /**
     * Метод для получения значения баланса основных средств
     *
     * @return возвращает баланс основных средств
     */
    public double getBalance() {
        System.out.println("Balance: " + balance);
        return balance;
    }

    /**
     * Метод позволяющий задать баланс основных средств
     *
     * @param amount - значение суммы баланса
     * @return возвращает true в случае успешного назначения баланса
     */
    public boolean setBalance(double amount) {
        if (amount >= 0) {
            balance = amount;
            System.out.println("Balance set to " + balance);
            return true;
        } else {
            System.out.println("Setting balance failed");
            return false;
        }
    }

    /**
     * Метод для отображения информации о карте, присущий всем типам карт
     */
    public abstract void showInfo();

    /**
     * Метод для начисления кэшбэка и бонусных баллов за покупку.
     *
     * @param amount - сумма платежа
     */
//    Значение процента бонуса и кэшбэка зашито в формулу, поскольку по ТЗ указаны неизменными,
//     но кажется лучше вынести в поля.
    protected void cashingBack(double amount) {
        bonusBalance = bonusBalance + (amount * 0.01);
        if (amount > 5000000) {
            cashBackBalance = cashBackBalance + (amount * 0.05);
        }
        System.out.println("You received cashback or bonuses");

    }

    /**
     * Метод для начисления накоплений при пополнении карты.
     *
     * @param amount - сумма пополнения
     */
//    Значение размера накопления зашито в формулу, поскольку по ТЗ указано неизменным,
//    но кажется лучше вынести в поля.
    protected void saving(double amount) {

        savingsBalance = savingsBalance + (amount * 0.00005);
        System.out.println("You received savings");
    }
}
