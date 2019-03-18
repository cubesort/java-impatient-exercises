package ch1;

public class Ch1_4 {
    public static void main(String[] args) {
        printExtremeDoubles();
    }

    public static void printExtremeDoubles() {
        System.out.println(Math.nextUp(0.0d));
        System.out.println(Math.nextDown(Double.POSITIVE_INFINITY));
    }
}
