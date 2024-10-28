package ucu.edu;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Flower {
    private FlowerColor color;
    private FlowerType flowerType;
    private double price;
    private double sepalLength;

    public Flower(Flower flower){
        this.color = flower.color;
        this.flowerType = flower.flowerType;
        this.price = flower.price;
        this.sepalLength = flower.sepalLength;
    }

    public String getColor(){
        return color.getCode();
    }
}
class Rose extends Flower {
    public Rose() {
        this.setColor(FlowerColor.RED);
        this.setPrice(0.0);
        this.setSepalLength(0.0);
        this.setFlowerType(FlowerType.ROSE);
    }
    public Rose(double sepalLength, FlowerColor color, double price) {
        super(color, FlowerType.ROSE , price, sepalLength);
    }
}
class Chamomile extends Flower {
    public Chamomile() {
        this.setColor(FlowerColor.WHITE);
        this.setPrice(0.0);
        this.setSepalLength(0.0);
        this.setFlowerType(FlowerType.CHAMMOMILE);
    }
    public Chamomile(double sepalLength, FlowerColor color, double price) {
        super(color, FlowerType.CHAMMOMILE , price, sepalLength);
    }
}
class Tulip extends Flower {
    public Tulip() {
        this.setColor(FlowerColor.YELLOW);
        this.setPrice(0.0);
        this.setSepalLength(0.0);
        this.setFlowerType(FlowerType.TULIP);
    }
    public Tulip(double sepalLength, FlowerColor color, double price) {
        super(color, FlowerType.TULIP , price, sepalLength);
    }
}