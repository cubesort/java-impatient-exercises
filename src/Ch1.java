import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ch1 {
    public static void main(String[] args) {
//        printLargest(2, 1, 0);
//        printExtremeDoubles();
//        System.out.println(factorial(BigInteger.valueOf(100)));
//        printString("Hello World");
//        printBase36();
        printLotteryNumber();
    }

    private static void printLargest(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        System.out.println(max);
    }

    private static void printLargestMax(int a, int b, int c) {
        int max = a;
        max = Math.max(max, b);
        max = Math.max(max, c);

        System.out.println(max);
    }

    private static void printExtremeDoubles() {
        System.out.println(Math.nextUp(0.0d));
        System.out.println(Math.nextDown(Double.POSITIVE_INFINITY));
    }

    private static BigInteger factorial(BigInteger n) {
        BigInteger res = BigInteger.ONE;
        while (n.compareTo(BigInteger.ONE) != 0) {

            res = res.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return res;
    }

    private static void printString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ' ') {
                System.out.println(s.charAt(i));
            }
        }
    }

    private static void printBase36() {
        long r = new Random(1L).nextLong();

        System.out.println(Long.toString(r, 36));
    }

    private static void printLotteryNumber() {
        int[] base = new int[49];
        for (int i = 0; i < 49; i++) {
            base[i] = i + 1;
        }

        Random r = new Random();
        ArrayList<Integer> picked = new ArrayList<>();

        while (picked.size() < 7) {
            int i = r.nextInt(49);
            int current = base[i];
            if (current != 0) {
                picked.add(current);
                base[i] = 0;
            }
        }

        Collections.sort(picked);
        System.out.println(picked);
    }
}
