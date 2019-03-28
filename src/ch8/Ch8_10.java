package ch8;

import java.io.IOException;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch8_10 {
    public static void main(String[] args) {
        try {
            Stream<String> words = Stream.of(Ch8_7.first100words("resources/words.txt"));
            System.out.println(getAverageLength(words));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static double getAverageLength(Stream<String> words) {
        return words.collect(Collectors.summarizingInt(String::length)).getAverage();
    }
}
