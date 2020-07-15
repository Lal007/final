package les1.polimorfizm;

public class Circle extends Figure {

    private final double radius;

    public Circle(String colour, double radius) {
        super(colour);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return 3.14 * Math.pow(radius, 2);
    }
}
