package ucu.edu.delivery;

import ucu.edu.Item;
import java.util.List;

public interface Delivery {
    boolean deliver(List<Item> items);
}
