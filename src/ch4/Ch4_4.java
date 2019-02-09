package ch4;

public class Ch4_4 {
    static public void main(String[] args) {
        Circle circle = new Circle(new Point(1, 1), 2);
        circle.moveBy(1, 1);
        try {
            Circle clonedCircle = circle.clone();
            System.out.println(clonedCircle.getRadius());
            System.out.println(clonedCircle.getCenter());
            clonedCircle.moveBy(1, 1);
            System.out.println(clonedCircle.getCenter());
            System.out.println(circle.getCenter());
        } catch (CloneNotSupportedException err) {
            System.out.println(err);
        }
    }
}

abstract class Shape implements Cloneable {
    private Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        point.setX(point.getX() + dx);
        point.setY(point.getY() + dy);
    }

    abstract public Point getCenter();

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape cloned = (Shape) super.clone();
        cloned.point = new Point(point.getX(), point.getY());

        return cloned;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return getPoint();
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

class Rectangle extends Shape implements Cloneable{
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.height = height;
        this.width = width;
    }

    @Override
    public Point getCenter() {
        Point topLeft = getPoint();
        return new Point(topLeft.getX() + (width / 2), topLeft.getY() + (height / 2));
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

class Line extends Shape implements Cloneable{
    private Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public Point getCenter() {
        Point from = getPoint();
        return new Point(to.getX() - from.getX(), to.getY() - from.getY());
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line cloned = (Line) super.clone();
        cloned.to = new Point(to.getX(), to.getY());

        return cloned;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
    }
}
