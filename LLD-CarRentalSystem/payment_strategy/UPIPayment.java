package payment_strategy;

public class UPIPayment implements PaymentStrategy {
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Paying using UPI for the amount of Rs." + amount);
    }
    
}
