package ucu.edu;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class FlowerPack {
    private Flower flower;
    private int count;

    public FlowerPack(final Flower flower, final int newcount){
        this.flower = new Flower(flower);
        this.count = newcount;
    }

    public double getPrice(){
        return flower.getPrice()*count;
    }
}
