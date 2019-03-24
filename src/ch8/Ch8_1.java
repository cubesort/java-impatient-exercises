package ch8;

import java.util.List;
import java.util.stream.Stream;

public class Ch8_1 {
    public static void main(String[] args) {
        String[] words = { "long", "long", "srt", "srt", "long", "long", "long", "long", "long", "long", "long" };
        getFirstFiveLongWords(words);
    }

    public static String[] getFirstFiveLongWords(String[] words) {
        return Stream.of(words)
                .filter((s) -> {
                    System.out.println("filtering");
                    return s.length() > 3;
                })
                .limit(5)
                .toArray(String[]::new);
    }
}
