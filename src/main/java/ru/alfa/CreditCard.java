package ru.alfa;

/**
 * Клас кредитной карты
 */
public class CreditCard extends BankCard {
    /**
     * Поле значения кредитного лимита
     */
    protected double limit;
    /**
     * Поле значения кредитного баланса
     */
    protected double creditBalance;

    /**
     * Сеттер для задания кредитного лимита
     *
     * @param limit значение лимита
     * @return возвращает true в случае успешного назначения лимита
     */
    public boolean setLimit(double limit) {
        if (limit >= 0) {
            this.limit = limit;
            System.out.println("Limit set to " + limit);
            return true;
        } else {
            System.out.println("Limit setting failed");
            return false;
        }
    }

    /**
     * Сеттер для задания кредитного баланса.
     * Изначально планировалось задавать баланс равный лимиту при создании карты,
     * но исходя из ТЗ они задаются отдельно.
     *
     * @param creditBalance значение баланса
     * @return возвращает true в случае успешного задания баланса
     */
    public boolean setCreditBalance(double creditBalance) {
        if (creditBalance >= 0) {
            this.creditBalance = creditBalance;
            System.out.println("Credit balance set to " + creditBalance);
            return true;
        } else {
            System.out.println("Credit balance setting failed");
            return false;
        }
    }

    @Override
    public void showInfo() {
        System.out.println("*** This is a Credit card ***" + "\nDebit balance:" + balance + "\nCard limit: " + limit + "\nCredit balance: " + creditBalance);
    }

    /**
     * Метод для проведения платежа по кредитной карте.
     * Переопределяет метод абстрактной карты, позволяя использовать кредитный баланс.
     *
     * @param amount - значение суммы платежа
     * @return возвращает true в случае успешного списания средств
     */
    @Override
    public boolean pay(double amount) {
        if (amount > 0) {
            if (balance - amount >= 0) {
                balance = balance - amount;
                System.out.println("Credit card payed " + amount);
                return true;
            } else if (creditBalance + (balance - amount) >= 0) {
                creditBalance = creditBalance + (balance - amount);
                balance = 0;
                System.out.println("Credit card payed " + amount);
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
     * Метод для пополнения стандартной кредитной карты.
     *
     * @param amount - значение суммы пополнения
     * @return возвращает true в случае успешного пополнения
     */
    public boolean upBalance(double amount) {
        if (amount > 0) {
            if (creditBalance + amount > limit) {
                balance = balance + amount - (limit - creditBalance);
                creditBalance = limit;
                System.out.println("Credit card successfully top up for " + amount);
                return true;
            } else if (creditBalance + amount <= limit) {
                creditBalance = creditBalance + amount;
                System.out.println("Credit card successfully top up for " + amount);
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
}
