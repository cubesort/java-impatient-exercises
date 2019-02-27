package ch4;

public class Ch4_7 {
    public static void main(String[] args) {
        System.out.println(Color.getBlue());
        System.out.println(Color.valueOf("BLUE"));
        System.out.println(Color.BLUE);
        System.out.println(Color.BLUE.name());
    }
}

enum Color {
    BLACK,
    RED,
    BLUE,
    GREEN,
    CYAN,
    MAGENTA,
    YELLOW,
    WHITE;

    static Color getRed() {
        return RED;
    }

    static Color getGreen() {
        return GREEN;
    }

    static Color getBlue() {
        return BLUE;
    }
}