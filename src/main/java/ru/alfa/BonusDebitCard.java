package ru.alfa;

/**
 * Клас дебетовой карты с бонусными опциями
 */
public class BonusDebitCard extends DebitCard {

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
            cashingBack(amount);
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
            saving(amount);
            return true;
        } else {
            System.out.println("Up balance failed");
            return false;
        }
    }

    @Override
    public void showInfo() {
        System.out.println("*** This is a Debit card with bonuses! ***" +
                "\nBalance: " + balance +
                "\nCashBack balance: " + cashBackBalance +
                "\nBonus balance: " + bonusBalance +
                "\nSaning balance: " + savingsBalance);

    }
}