package ch1;

import java.math.BigInteger;

public class Ch1_6 {
    public static void main(String[] args) {
        System.out.println(factorial(BigInteger.valueOf(1000)));
    }

    public static BigInteger factorial(BigInteger n) {
        BigInteger res = BigInteger.ONE;
        while (n.compareTo(BigInteger.ONE) != 0) {

            res = res.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return res;
    }
}
