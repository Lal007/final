package les1.polimorfizm;

public class Triangle extends Figure {

    private final double base;
    private final double height;

    public Triangle(String colour, double base, double height) {
        super(colour);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return (base + height) / 2;
    }
}
