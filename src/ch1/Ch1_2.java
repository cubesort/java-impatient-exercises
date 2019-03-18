package ch1;

public class Ch1_2 {
    public static void main(String[] args) {
        System.out.println(normalize359(1200));
        System.out.println(normalize359(-1300));
        System.out.println(normalize359floorMod(1200));
        System.out.println(normalize359floorMod(-1300));
    }

    private static int normalize359 (int integer) {
        if (integer < 0) {
            integer = integer / -1;
        }
        while (integer > 359) {
            integer %= 359;
        }
        return integer;
    }

    private static int normalize359floorMod (int integer) {
        if (integer < 0) {
            integer = integer / -1;
        }
        integer = Math.abs(Math.floorMod(integer, 359));
        return integer;
    }
}
