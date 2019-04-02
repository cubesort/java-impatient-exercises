package ch8;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

public class Ch8_16 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find500PrimesWith50Digits()));
    }

    public static BigInteger[] find500PrimesWith50Digits() {
        BigInteger seed = BigInteger.valueOf((long) Math.pow(10, 50));

        return Stream
                .iterate(seed, prev -> prev.add(BigInteger.ONE))
                .filter(b -> b.isProbablePrime(10))
                .limit(500)
                .toArray(BigInteger[]::new);
    }
}
