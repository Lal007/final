package les1.polimorfizm;

public abstract class Figure {

    private final String colour;

    public Figure(String colour) {
        this.colour = colour;
    }

    abstract double calculateArea();

    public String getColour() {
        return colour;
    }
}
