package ucu.edu;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Flower> inventory;

    public Store() {
        this.inventory = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        inventory.add(flower);
    }


    public List<Flower> searchFlowers(FlowerType type, FlowerColor color, Double minPrice, Double maxPrice) {
        List<Flower> results = new ArrayList<>();

        for (Flower flower : inventory) {
            boolean matches = true;

            if (type != null && !flower.getFlowerType().equals(type)) {
                matches = false;
            }

            if (color != null && !flower.getColor().equals(color.getCode())) {
                matches = false;
            }

            if (minPrice != null && flower.getPrice() < minPrice) {
                matches = false;
            }
            if (maxPrice != null && flower.getPrice() > maxPrice) {
                matches = false;
            }

            if (matches) {
                results.add(flower);
            }
        }

        return results;
    }
}
