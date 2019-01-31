package ch3;

import java.io.File;
import java.util.Arrays;

public class ch3_13 {
    public static void main(String[] args) {
        File[] files = new File(".").listFiles();
        sort(files);
        System.out.println(Arrays.toString(files));
    }

    public static void sort(File[] files) {
        Arrays.sort(files, (a, b) -> {
            if (a.isDirectory() && !b.isDirectory()) {
                return -1;
            }

            if (!a.isDirectory() && b.isDirectory()) {
                return 1;
            }

            return a.compareTo(b);
        });
    }
}
