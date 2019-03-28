package ch8;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class Ch8_10 {
    private static String[] VOWELS = { "a", "e", "i", "o", "u" };

    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(wordsWithAllVowels("resources/words.txt")));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    private static String[] wordsWithAllVowels(String pathname) throws IOException {
        Path path = Path.of(System.getProperty("user.dir"), pathname);

        try (Scanner in = new Scanner(path)) {
            return in
                    .useDelimiter("[^\\w]")
                    .tokens()
                    .filter(Ch8_10::hasAllVowels)
                    .toArray(String[]::new);
        }
    }

    private static boolean hasAllVowels(String str) {
        String lower = str.toLowerCase();

        for (String vowel : VOWELS) {
            if (!lower.contains(vowel)) {
                return false;
            }
        }

        return true;
    }
}
