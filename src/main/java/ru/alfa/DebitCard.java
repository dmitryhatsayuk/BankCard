package ru.alfa;

/**
 * Клас простой дебетовой карты
 */
public class DebitCard extends BankCard {

    @Override
    public void showInfo() {
        System.out.println("*** This is a Debit card*** \n" + " Balance: " + balance);
    }

    /**
     * Метод для пополнения стандартной дебетовой карты.
     *
     * @param amount - значение суммы пополнения
     * @return возвращает true в случае успешного пополнения
     */
    public boolean upBalance(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Balance top up successfully for " + amount);
            return true;
        } else {
            System.out.println("Up balance failed");
            return false;
        }
    }


}
