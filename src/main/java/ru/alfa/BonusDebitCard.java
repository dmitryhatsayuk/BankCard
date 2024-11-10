package ru.alfa;

/**
 * Клас дебетовой карты с бонусными опциями в виде кэшбэка, бонусов и накоплений
 */
public class BonusDebitCard extends DebitCard {

    private final double cashBackAmount = 0.05;
    private final double cashBackPaymentLimit = 5000000;
    private final double bonusAmount = 0.01;
    private final double savingsAmount = 0.00005;

    /**
     * Метод для проведения платежа по дебетовой карте с бонусными опциями.
     * Расширяет метод pay простой дебетовой карты за счет начисления кэшбэка и бонусов.
     *
     * @param amount - значение суммы платежа
     * @return возвращает true в случае успешного списания средств
     */
    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Payment successful for " + amount);
            cashingBack(amount, bonusAmount, cashBackAmount, cashBackPaymentLimit);
            return true;
        } else {
            System.out.println("Payment failed");
            return false;
        }
    }

    /**
     * Метод для пополнения дебетовой карты с бонусными опциями.
     * Переопределен от метода стандартной дебетовой карты.
     *
     * @param amount - значение суммы пополнения
     * @return возвращает true в случае успешного пополнения
     */
    @Override
    public boolean upBalance(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Balance top up successfully for " + amount);
            saving(amount, savingsAmount);
            return true;
        } else {
            System.out.println("Up balance failed");
            return false;
        }
    }

    @Override
    public void showInfo() {
        System.out.println("*** This is a Debit card with bonuses! ***" + "\nBalance: " + balance + "\nCashBack balance: " + cashBackBalance + "\nBonus balance: " + bonusBalance + "\nSaning balance: " + savingsBalance);

    }
}
