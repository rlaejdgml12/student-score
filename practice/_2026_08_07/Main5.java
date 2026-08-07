package _2026_08_07;

interface PaymentProcessor{
    void pay(int amount);
}

class CardPaymentProcessor implements PaymentProcessor {
    @Override
    public void pay(int amount){
        System.out.println("카드 결제 : " + amount + "원");
    }
}

class KaKaoPaymentProcessor implements PaymentProcessor{
    @Override
    public void pay(int amount){
        System.out.println("카카오페이 결제 : " + amount + "원");
    }
}

public class Main5 {
    public static void main(String[] args) {
        PaymentProcessor processor = new CardPaymentProcessor();
        processor.pay(10000);
        PaymentProcessor processor1 = new KaKaoPaymentProcessor();
        processor1.pay(10000);
    }
}
