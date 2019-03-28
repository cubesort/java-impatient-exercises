package ch8;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ch8_12 {
    public static void main(String[] args) {
        try {
            Stream<String> words = Stream.of(Ch8_7.first100words("resources/words.txt"));
            System.out.println(Arrays.toString(getWordsOfMaxLength(words)));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String[] getWordsOfMaxLength(Stream<String> wordsStream) {
        String[] words = wordsStream.toArray(String[]::new);
        Supplier<Stream<String>> wordsSupplier = () -> Stream.of(words);

        Optional<String> max = wordsSupplier.get().max(Comparator.comparingInt(String::length));
        int maxLen = max.orElse("").length();
        return wordsSupplier.get().filter(s -> s.length() == maxLen).toArray(String[]::new);
    }
}
