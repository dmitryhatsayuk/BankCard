package ru.alfa;

public class CreditCard extends BankCard {

    protected double debitAccount;
    protected double creditAccount;
    protected double creditLimit;

    //если есть долг, то его нужно учесть при назначении нового значения кредитного счета,
// но и больше лимита делать нельзя. Также банк моет установить нулевой лимит-логика продолжит работать
    public boolean setCreditAccount(double amount) {
        if (amount > creditLimit) {
            return false;
        }
        creditAccount = (creditLimit - creditAccount) + amount;
        return true;
    }

    // если мы меняем лимит, то на такую же сумму должно меняться значение кредитного счета
    // при этом лимит может стать меньше долга и логика везде должна работать
    public boolean setCreditLimit(double amount) {
        if (creditLimit < 0) {
            return false;
        }
        creditAccount = creditAccount + (amount - creditLimit);
        creditLimit = amount;
        return true;
    }

    //менять сумму дебетовых средств можно только если погашены все долги
    //при нулевом лимите и отрицательном уровне кредитных средств тоже работает
    // (случай когда тебе банк больше не дает в долг, но ты еще должен ему)
    public boolean setDebitAccount(double amount) {
        if (amount< 0||creditLimit>creditAccount ) {
            return false;
        }
        debitAccount = amount;
        return true;
    }
    @Override
    //в этом методе нам нужно показать все доступные денежки, поскольку баланс это количество и тех и других
    public double getBalance() {
        return debitAccount + creditAccount;
    }

    @Override
    public boolean pay(double amount) {
        //если всех своих и кредитных денег не хватает то, извините
        if (!canPay(amount)) {
            return false;
        }
        //если хватает своих то тратим только их
        if (debitAccount >= amount) {
            debitAccount -= amount;
            return true;
        }
        //в остальных случаях берем с кредитного счета ровно столько сколько не хватило на свои деньги
        creditAccount = getBalance() - amount;
        return true;
    }

    @Override
    public boolean fill(double amount) {
        if (amount < 0) {
            return false;
        }
        //если платеж не покрывает весь долг, то просто кладем все на кредитный
        if (creditLimit - creditAccount >= amount) {
            creditAccount += amount;
        }
//если покрывает (даже если мы не тратили кредитные), то кидаем на дебетовый счет все что не скушал кредитный,
//а кредитный становится равен лимиту
        else {
            debitAccount = debitAccount + amount - (creditLimit - creditAccount);
            creditAccount = creditLimit;
        }
        return true;
    }

    @Override
    public String info() {
        return " Debit Account: " + debitAccount + " Credit Account: " + creditAccount;
    }
}
