package payment_strategy;

public class CashPayment implements PaymentStrategy {
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Paying using Cash for the amount of Rs." + amount);
    }
    
}
