package ru.alfa;

public class BonusCreditCard extends CreditCard {
    //карта с бонусами и кэшбэком
    private double bonusAccount;
    private double cashBackAccount;

    @Override
    //переопределим только метод оплаты, поскольку две бонусные программы касаются только его
    public boolean pay(double amount) {
        if (!canPay(amount)) {
            return false;
        }
        if (debitAccount >= amount) {
            debitAccount -= amount;
            cashingBackFive(amount);
            bonusingOne(amount);
            return true;
        }
        creditAccount = getBalance() - amount;
        cashingBackFive(amount);
        bonusingOne(amount);
        return true;
    }

    @Override
    public String info() {
        return "Debit Account: " + debitAccount + "\nCredit Account: " + creditAccount + "\nBonus Account: " + bonusAccount + "\nCashBack: " + cashBackAccount;
    }

    //можно конечно задавать значения в полях, но кажется у каждой бонусной программы будет своя логика
    private void bonusingOne(double amount) {
        //проверки на не отрицательность доверим вышестоящим методам
        bonusAccount = bonusAccount + amount * 0.01;
    }

    private void cashingBackFive(double amount) {
        if (amount > 5000000) {
            cashBackAccount = cashBackAccount + amount * 0.05;
        }
    }

}
