package ucu.edu;
import lombok.Getter;
@Getter
public enum FlowerColor {
    RED("#FF0000"),WHITE("#FFFFFF"),YELLOW("#FFFF00");
    private String code;
    FlowerColor(final String outcode){
        this.code = outcode;
    }
}
