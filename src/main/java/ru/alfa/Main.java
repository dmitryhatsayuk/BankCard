package ru.alfa;

public class Main {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard();
//Кредитная карта лимит 10 000, кредитный баланс 10 000, собственные средства 0
        creditCard.setLimit(10000);
        creditCard.setCreditBalance(10000);
        creditCard.setBalance(0);
        //Пополнение на 5 000
        creditCard.upBalance(5000);
        creditCard.showInfo(); //ожидаем кредитные не изменились, собственные 5000
        //оплачиваем 5000
        creditCard.pay(5000);
        creditCard.showInfo();//ожидаем кредитные без изменений, собственные 0
        //оплачиваем на 3000
        creditCard.pay(3000);
        creditCard.showInfo();//ожидаем доступные кредитные средства 7000, собственные 0
        //пополняем на 2000
        creditCard.upBalance(2000);
        creditCard.showInfo();//ожидаем доступные кредитные 9000, собственные 0
        //пополняем на 2000
        creditCard.upBalance(2000);
        creditCard.showInfo();//ожидаем доступные кредитные средства 10 000, собственные 1 000

//Пример кредитной карты с бонусной программой
        System.out.println("################");
        BonusCreditCard bonusCreditCard = new BonusCreditCard();
        bonusCreditCard.setBalance(100000);
        bonusCreditCard.setLimit(100000);
        bonusCreditCard.setCreditBalance(100000);
        bonusCreditCard.pay(600);
        bonusCreditCard.showInfo();
        bonusCreditCard.upBalance(1000);
        bonusCreditCard.showInfo();
        bonusCreditCard.pay(100000);
        bonusCreditCard.showInfo();
        bonusCreditCard.pay(9000);
        bonusCreditCard.showInfo();
        bonusCreditCard.upBalance(10000);
        bonusCreditCard.showInfo();


    }
}