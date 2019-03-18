package ch1;

import java.util.Random;

public class Ch1_10 {
    public static void main(String[] args) {
        printBase36();
    }

    public static void printBase36() {
        long r = new Random(1L).nextLong();

        System.out.println(Long.toString(r, 36));
    }
}
