package ucu.edu;

public abstract class ItemDecorator implements Item {
    protected Item item;

    public ItemDecorator(Item item) {
        this.item = item;
    }
}