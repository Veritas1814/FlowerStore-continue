package ucu.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.List;
import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;
    private Rose rose;
    private Chamomile chamomile;
    private Tulip tulip;
    @BeforeEach
    public void init()   {
        flower = new Flower();
        rose = new Rose(5.0, FlowerColor.RED, 20.0);
        chamomile = new Chamomile(2.5, FlowerColor.WHITE, 15.0);
        tulip = new Tulip(3.0, FlowerColor.YELLOW, 10.0);
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }
    @Test
    public void testRoseAttributes() {
        Assertions.assertEquals("#FF0000", rose.getColor());
        Assertions.assertEquals(FlowerType.ROSE, rose.getFlowerType());
        Assertions.assertEquals(20.0, rose.getPrice());
        Assertions.assertEquals(5.0, rose.getSepalLength());
    }

    @Test
    public void testChamomileAttributes() {
        Assertions.assertEquals("#FFFFFF", chamomile.getColor());
        Assertions.assertEquals(FlowerType.CHAMMOMILE, chamomile.getFlowerType());
        Assertions.assertEquals(15.0, chamomile.getPrice());
        Assertions.assertEquals(2.5, chamomile.getSepalLength());
    }

    @Test
    public void testTulipAttributes() {
        Assertions.assertEquals("#FFFF00", tulip.getColor());
        Assertions.assertEquals(FlowerType.TULIP, tulip.getFlowerType());
        Assertions.assertEquals(10.0, tulip.getPrice());
        Assertions.assertEquals(3.0, tulip.getSepalLength());
    }
    @Test
    public void testSetSepalLength() {
        rose.setSepalLength(6.0);
        Assertions.assertEquals(6.0, rose.getSepalLength());

        chamomile.setSepalLength(3.0);
        Assertions.assertEquals(3.0, chamomile.getSepalLength());

        tulip.setSepalLength(4.0);
        Assertions.assertEquals(4.0, tulip.getSepalLength());
    }

}
class FlowerBucketTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_QUANTITY = 1000;
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Rose();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }
}
class StoreTest {
    private Store store;
    private Rose rose;
    private Chamomile chamomile;
    private Tulip tulip;

    @BeforeEach
    public void init() {
        store = new Store();
        rose = new Rose(5.0, FlowerColor.RED, 20.0);
        chamomile = new Chamomile(2.5, FlowerColor.WHITE, 15.0);
        tulip = new Tulip(3.0, FlowerColor.YELLOW, 10.0);

        store.addFlower(rose);
        store.addFlower(chamomile);
        store.addFlower(tulip);
    }

    @Test
    public void testAddFlower() {
        Flower newRose = new Rose(6.0, FlowerColor.RED, 25.0);
        store.addFlower(newRose);

        List<Flower> results = store.searchFlowers(FlowerType.ROSE, null, null, null);
        Assertions.assertEquals(2, results.size());
    }

    @Test
    public void testSearchFlowersByType() {
        List<Flower> results = store.searchFlowers(FlowerType.ROSE, null, null, null);
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(FlowerType.ROSE, results.get(0).getFlowerType());
    }

    @Test
    public void testSearchFlowersByColor() {
        List<Flower> results = store.searchFlowers(null, FlowerColor.WHITE, null, null);
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(FlowerColor.WHITE.getCode(), results.get(0).getColor());
    }

    @Test
    public void testSearchFlowersByPriceRange() {
        List<Flower> results = store.searchFlowers(null, null, 15.0, 25.0);
        Assertions.assertEquals(2, results.size());
    }

    @Test
    public void testSearchFlowersByTypeAndColor() {
        List<Flower> results = store.searchFlowers(FlowerType.ROSE, FlowerColor.RED, null, null);
        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(FlowerColor.RED.getCode(), results.get(0).getColor());
        Assertions.assertEquals(FlowerType.ROSE, results.get(0).getFlowerType());
    }

    @Test
    public void testSearchFlowersNoResults() {
        List<Flower> results = store.searchFlowers(FlowerType.TULIP, FlowerColor.RED, null, null);
        Assertions.assertEquals(0, results.size());
    }

}