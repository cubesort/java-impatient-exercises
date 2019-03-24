package ch8;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch8_4 {
    public static void main(String[] args) {
        Stream<Long> random = random(25214903917L, 11L, (long) Math.pow(2, 48), 0L);
        System.out.println(random.limit(5).collect(Collectors.toList()));

    }

    public static Stream<Long> random(Long a, Long c, Long m, Long seed) {
        return Stream.iterate(seed, (prev) -> (a * prev + c) % m);
    }
}
