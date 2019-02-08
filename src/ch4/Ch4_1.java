package ch4;

import java.awt.*;
import java.util.Objects;

public class Ch4_1 {
    static public void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(1, 2);
        System.out.println(a);
        System.out.println(a.equals(b));

        LabeledPoint c = new LabeledPoint("c", 1, 2);
        LabeledPoint d = new LabeledPoint("c", 1, 2);
        System.out.println(c);
        System.out.println(c.equals(d));

        System.out.println(a.equals(c));
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Point other = (Point) obj;

        return x == other.x && y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LabeledPoint [x=" + getX() + ", y=" + getY() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        LabeledPoint other = (LabeledPoint) obj;

        return label.equals(other.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, getX(), getY());
    }
}