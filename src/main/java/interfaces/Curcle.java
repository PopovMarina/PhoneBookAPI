package interfaces;

public class Curcle implements Shape{

    private double radius;

    public Curcle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI*radius*radius;
    }
}
