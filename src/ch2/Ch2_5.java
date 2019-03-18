package ch2;

public class Ch2_5 {
    public static void main(String[] args) {
        Point p = new Point(3, 4).translate(1, 3).scale(0.5f);
        System.out.println(p.getX());
        System.out.println(p.getY());
    }
}

final class Point {
    private float x;
    private float y;

    public Point (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point () { }

    public Point translate(float offsetX, float offsetY) {
        this.x += offsetX;
        this.y += offsetY;

        return this;
    }

    public Point scale(float scaleBy) {
        this.x *= scaleBy;
        this.y *= scaleBy;

        return this;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}


