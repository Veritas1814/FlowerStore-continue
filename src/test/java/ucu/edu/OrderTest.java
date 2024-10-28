package ucu.edu;

import org.junit.jupiter.api.Test;
import ucu.edu.delivery.DHLDeliveryStrategy;
import ucu.edu.delivery.PostDeliveryStrategy;
import ucu.edu.payment.CreditCardPaymentStrategy;
import ucu.edu.payment.PayPalPaymentStrategy;
import ucu.edu.decorators.PaperDecorator;
import ucu.edu.decorators.RibbonDecorator;
import ucu.edu.decorators.BasketDecorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    void testPaymentStrategies() {
        Order order = new Order();
        order.setPaymentStrategy(new CreditCardPaymentStrategy("1234-5678-9101-1121", "John Doe", "123", "12/25"));
        order.setDeliveryStrategy(new PostDeliveryStrategy());

        Item item = new FlowerBucket();
        order.addItem(item);

        order.setPaymentStrategy(new PayPalPaymentStrategy("john.doe@example.com"));
        order.processOrder();
    }

    @Test
    void testDeliveryStrategies() {
        Order order = new Order();
        order.setPaymentStrategy(new CreditCardPaymentStrategy("1234-5678-9101-1121", "John Doe", "123", "12/25"));

        Item item = new FlowerBucket();
        order.addItem(item);

        order.setDeliveryStrategy(new DHLDeliveryStrategy());
        order.processOrder();
    }

    @Test
    void testDecorators() {
        Item flowerBucket = new FlowerBucket();

        flowerBucket = new PaperDecorator(flowerBucket);
        flowerBucket = new RibbonDecorator(flowerBucket);
        flowerBucket = new BasketDecorator(flowerBucket);

        assertEquals("Flower Bucket containing various flowers, wrapped in paper, with ribbon, in a basket", flowerBucket.getDescription());

        double basePrice = flowerBucket.getPrice();
        assertEquals(57, basePrice); 
    }
}
