package ucu.edu.decorators;

import ucu.edu.ItemDecorator;
import ucu.edu.Item;

public class BasketDecorator extends ItemDecorator {
    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 4;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", in a basket";
    }
}
