package ru.alfa;

public class Main {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard();
//Кредитная карта лимит 10 000, кредитный баланс 10 000, собственные средства 0
        creditCard.setCreditLimit(10000);
        creditCard.setCreditAccount(10000);
        creditCard.setDebitAccount(0);
        //Пополнение на 5 000
        creditCard.fill(5000);
        System.out.println(creditCard.info()); //ожидаем кредитные не изменились, собственные 5000
        //оплачиваем 5000
        creditCard.pay(5000);
        System.out.println(creditCard.info());//ожидаем кредитные без изменений, собственные 0
        //оплачиваем на 3000
        creditCard.pay(3000);
        System.out.println(creditCard.info());//ожидаем доступные кредитные средства 7000, собственные 0
        //пополняем на 2000
        creditCard.fill(2000);
        System.out.println(creditCard.info());//ожидаем доступные кредитные 9000, собственные 0
        //пополняем на 2000
        creditCard.fill(2000);
        System.out.println(creditCard.info());//ожидаем доступные кредитные средства 10 000, собственные 1 000
        System.out.println("######################");
/////////////////////
        BonusDebitCard bonusDebitCard = new BonusDebitCard();
        bonusDebitCard.setDebitAccount(500000);
        bonusDebitCard.fill(5000000);
        bonusDebitCard.pay(5000);
        System.out.println(bonusDebitCard.info());
        System.out.println("#######################");
        ////////////////////
        BonusCreditCard bonusCreditCard = new BonusCreditCard();
        bonusCreditCard.setCreditAccount(50000);
        bonusCreditCard.setCreditLimit(50000);
        bonusCreditCard.setDebitAccount(0);
        bonusCreditCard.fill(5100000);
        bonusCreditCard.pay(5000010);
        bonusCreditCard.pay(50000);
        bonusCreditCard.pay(50000);


        System.out.println(bonusCreditCard.info());


    }
}