package ucu.edu.payment;

public class CreditCardPaymentStrategy implements Payment {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expirationDate;

    public CreditCardPaymentStrategy(String cardNumber, String cardHolderName, String cvv, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
        return true;
    }
}
