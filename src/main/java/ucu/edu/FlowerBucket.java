package ucu.edu;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket implements Item {
    private List<FlowerPack> flowerPacks = new ArrayList<>();

    public void add(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    @Override
    public double getPrice() {
        return flowerPacks.stream().mapToDouble(FlowerPack::getPrice).sum();
    }

    @Override
    public String getDescription() {
        return "Flower Bucket containing various flowers";
    }
}
