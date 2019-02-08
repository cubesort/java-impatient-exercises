package ch4;

public class Ch4_4 {
}

abstract class Shape {
    private Point point = new Point(1,2);

    public void moveBy(double dx, double dy) {
        point.setX(point.getX() + dx);
        point.setY(point.getY() + dy);
    }

    abstract public Point getCenter();


}