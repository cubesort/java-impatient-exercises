package ch8;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Ch8_7 {
    public static void main(String[] args) {
        try {
            String[] words = first100words("ch8/words.txt");
            System.out.println(Arrays.toString(words));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String[] first100words(String pathname) throws IOException {
        Path path = Path.of(System.getProperty("java.class.path"), pathname);
        try (Scanner in = new Scanner(path)) {
            return in
                    .useDelimiter("[,\\s]")
                    .tokens()
                    .filter(Ch8_6::isWord)
                    .limit(100)
                    .toArray(String[]::new);
        }
    }
}
