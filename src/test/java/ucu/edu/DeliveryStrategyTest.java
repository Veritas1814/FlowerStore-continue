package ucu.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ucu.edu.delivery.DHLDeliveryStrategy;
import ucu.edu.delivery.PostDeliveryStrategy;
import ucu.edu.delivery.Delivery;

import java.util.List;


public class DeliveryStrategyTest {

    private List<Item> items;

    @BeforeEach
    void setUp() {
        FlowerBucket bucket = new FlowerBucket();

        FlowerPack pack = new FlowerPack() {
            @Override
            public double getPrice() {
                return 20.0;
            }
        };

        bucket.add(pack);
        items = List.of(bucket);
    }

    @Test
    void testPostDelivery() {
        Delivery postDelivery = new PostDeliveryStrategy();
        org.junit.jupiter.api.Assertions.assertTrue(postDelivery.deliver(items));
    }

    @Test
    void testDHLDelivery() {
        Delivery dhlDelivery = new DHLDeliveryStrategy();
        org.junit.jupiter.api.Assertions.assertTrue(dhlDelivery.deliver(items));
    }
}