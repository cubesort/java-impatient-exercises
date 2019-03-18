package ch1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ch1_13 {
    public static void main(String[] args) {
        printLotteryNumber();
    }

    public static void printLotteryNumber() {
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
