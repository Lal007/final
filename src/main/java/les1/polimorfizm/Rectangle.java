package les1.polimorfizm;

public class Rectangle extends Figure {

    private final double width;
    private final double high;

    public Rectangle(String colour, double width, double high) {
        super(colour);
        this.width = width;
        this.high = high;
    }

    @Override
    double calculateArea() {
        return width * high;
    }
}
