package ch7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ch7_7 {
    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir");
            Map<String, Integer> counts = count(path + "/src/ch7/words.txt");
            System.out.println(counts);
        } catch(FileNotFoundException ex) {
            System.out.println(ex.toString());
        }
    }

    public static Map<String, Integer> count(String path) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(path))) {
            in.useDelimiter(" ");
            Map<String, Integer> counts = new TreeMap<>();

            while (in.hasNext()) {
                String word = in.next();
                counts.compute(word, (k, v) -> v == null ? 1 : v + 1);
            }

            return counts;
        }
    }
}
