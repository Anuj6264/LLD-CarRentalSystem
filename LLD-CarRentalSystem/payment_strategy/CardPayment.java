package payment_strategy;

public class CardPayment implements PaymentStrategy {

    @Override
    public void processPayment(double amount) {
        System.out.println("Paying using Card for the amount of Rs." + amount);
    }
}
