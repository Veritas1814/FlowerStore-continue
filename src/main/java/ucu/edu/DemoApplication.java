package ucu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ucu.edu.delivery.DHLDeliveryStrategy;
import ucu.edu.delivery.PostDeliveryStrategy;
import ucu.edu.payment.CreditCardPaymentStrategy;
import ucu.edu.payment.PayPalPaymentStrategy;
import ucu.edu.Item;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
@RestController
@RequestMapping("/api/flowers")
class FlowerController {

	@GetMapping
	public List<Flower> getFlowers() {
		return List.of(
				new Rose(5.0, FlowerColor.RED, 10.0),
				new Chamomile(4.0, FlowerColor.WHITE, 5.0),
				new Tulip(6.0, FlowerColor.YELLOW, 7.0)
		);
	}
}

@RestController
@RequestMapping("/api/order")
class OrderController {

	private final Order order = new Order();

	{
		FlowerBucket roseBucket = new FlowerBucket();
		roseBucket.add(new FlowerPack(new Rose(), 5));

		FlowerBucket tulipBucket = new FlowerBucket();
		tulipBucket.add(new FlowerPack(new Tulip(), 3));

		order.addItem(roseBucket);
		order.addItem(tulipBucket);
	}

	@GetMapping
	public Order getOrder() {
		return order;
	}

	@GetMapping("/pay/credit-card")
	public String payWithCreditCard() {
		CreditCardPaymentStrategy payment = new CreditCardPaymentStrategy("1234-5678-9101-1121", "John Doe", "123", "12/25");
		order.setPaymentStrategy(payment);
		return payment.pay(order.getTotalPrice()) ? "Payment successful with Credit Card." : "Payment failed with Credit Card.";
	}

	@GetMapping("/pay/paypal")
	public String payWithPayPal() {
		PayPalPaymentStrategy payment = new PayPalPaymentStrategy("john.doe@example.com");
		order.setPaymentStrategy(payment);
		return payment.pay(order.getTotalPrice()) ? "Payment successful with PayPal." : "Payment failed with PayPal.";
	}

	@GetMapping("/deliver/post")
	public String deliverByPost() {
		PostDeliveryStrategy delivery = new PostDeliveryStrategy();
		order.setDeliveryStrategy(delivery);
		return delivery.deliver(order.getItems()) ? "Delivery successful by Post." : "Delivery failed by Post.";
	}

	@GetMapping("/deliver/dhl")
	public String deliverByDHL() {
		DHLDeliveryStrategy delivery = new DHLDeliveryStrategy();
		order.setDeliveryStrategy(delivery);
		return delivery.deliver(order.getItems()) ? "Delivery successful by DHL." : "Delivery failed by DHL.";
	}
}
