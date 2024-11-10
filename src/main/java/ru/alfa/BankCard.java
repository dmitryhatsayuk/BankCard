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
     * Поле лимита суммы за которую начисляется кэшбэк
     */
    protected double cashBackPaymentLimit;
    /**
     * Размер кэшбэка
     */

    protected double cashBackAmount;
    /**
     * Поле бонусного баланса
     */
    protected double bonusBalance;
    /**
     * Размер начисляемого бонуса
     */
    protected double bonusAmount;
    /**
     * Поле баланса накоплений
     */
    protected double savingsBalance;
    /**
     * Доля начисляемых накоплений
     */
    private double savingAmount;

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

    protected void cashingBack(double amount, double bonusAmount, double cashBackAmount, double cashBackPaymentLimit) {
        bonusBalance = bonusBalance + (amount * bonusAmount);
        if (amount > cashBackPaymentLimit) {
            cashBackBalance = cashBackBalance + (amount * cashBackAmount);
        }
        System.out.println("You received cashback or bonuses");

    }

    /**
     * Метод для начисления накоплений при пополнении карты.
     *
     * @param amount - сумма пополнения
     */

    protected void saving(double amount, double savingAmount) {

        savingsBalance = savingsBalance + (amount * savingAmount);
        System.out.println("You received savings");
    }
}
