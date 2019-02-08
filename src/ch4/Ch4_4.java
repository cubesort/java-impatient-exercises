package ch4;

public class Ch4_4 {
    static public void main(String[] args) {
        
    }
}

abstract class Shape {
    private Point point = new Point(1,2);

    public void moveBy(double dx, double dy) {
        point.setX(point.getX() + dx);
        point.setY(point.getY() + dy);
    }

    abstract public Point getCenter();

    class Circle implements Cloneable {
        private Point center;
        private double radius;

        public Circle(Point center, double radius) {
            this.center = center;
            this.radius = radius;
        }

        @Override
        public Circle clone() throws CloneNotSupportedException {
            Circle cloned = (Circle) super.clone();
            cloned.center = new Point(center.getX(), center.getY());

            return cloned;
        }
    }

    class Rectangle implements Cloneable{
        private Point topLeft;
        private double width;
        private double height;

        public Rectangle(Point topLeft, double width, double height) {
            this.topLeft = topLeft;
            this.height = height;
            this.width = width;
        }

        @Override
        public Rectangle clone() throws CloneNotSupportedException {
            Rectangle cloned = (Rectangle) super.clone();
            cloned.topLeft = new Point(topLeft.getX(), topLeft.getY());

            return cloned;
        }
    }

    class Line implements Cloneable{
        private Point from;
        private Point to;

        public Line(Point from, Point to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public Line clone() throws CloneNotSupportedException {
            Line cloned = (Line) super.clone();
            cloned.from = new Point(from.getX(), from.getY());
            cloned.to = new Point(to.getX(), to.getY());

            return cloned;
        }
    }
}
