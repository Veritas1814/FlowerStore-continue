package ucu.edu.delivery;

import ucu.edu.Item;
import java.util.List;

public class PostDeliveryStrategy implements Delivery {
    @Override
    public boolean deliver(List<Item> items) {
        System.out.println("Delivering items via post.");
        return true;
    }
}
