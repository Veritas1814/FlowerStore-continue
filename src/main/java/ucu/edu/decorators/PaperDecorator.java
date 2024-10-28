package ucu.edu.decorators;
import ucu.edu.ItemDecorator;
import ucu.edu.Item;

public class PaperDecorator extends ItemDecorator {
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return item.getPrice() + 13;
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", wrapped in paper";
    }
}

