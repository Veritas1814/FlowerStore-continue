package ucu.edu.payment;

public class PayPalPaymentStrategy implements Payment {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
        return true;
    }
}
