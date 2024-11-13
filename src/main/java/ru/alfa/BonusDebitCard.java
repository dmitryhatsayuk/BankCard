package ru.alfa;

//карта с бонусной программой в виде накоплений
public class BonusDebitCard extends DebitCard {

    private double savingsAccount;

    //поскольку бонусная программа будет касаться только пополнений, то переопределим метод fill
    @Override
    public boolean fill(double amount) {
        if (super.fill(amount)){
            saving(amount);
            return true;
        }
        return false;
    }

    @Override
    public String info() {
        return super.info()+ "\nSavings: " + savingsAccount;
    }


    private void saving(double amount) {
        savingsAccount = savingsAccount + amount * 0.00005;
    }


}
