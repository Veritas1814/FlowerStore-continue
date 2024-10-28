package ucu.edu.decorators;

import ucu.edu.Item;
import ucu.edu.ItemDecorator;

public class RibbonDecorator extends ItemDecorator {
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 40;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", with ribbon";
    }
}
