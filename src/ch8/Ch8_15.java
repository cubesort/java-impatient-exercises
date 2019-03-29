package ch8;

import java.util.stream.Stream;

public class Ch8_15 {
    public static void main(String[] args) {
        Stream<Double> numbers = Stream.of(1D, 2D, 3D);
        System.out.println(average(numbers));
    }

    public static double average(Stream<Double> numbers) {
        Tuple stats = numbers.reduce(
                new Tuple(0, 0),
                (tuple, number) -> new Tuple(tuple.total + number, tuple.count + 1),
                (t1, t2) -> new Tuple(t1.total + t2.total, t1.count + t2.count));

        return stats.total / stats.count;
    }

    private static class Tuple {
        double total;
        double count;

        Tuple(double total, double count) {
            this.total = total;
            this.count = count;
        }
    }
}
