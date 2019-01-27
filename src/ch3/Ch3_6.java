package ch3;

import java.math.BigInteger;

public class Ch3_6 {
    public static void main(String[] args) {
        SquareSequence seq = new SquareSequence();

        System.out.println(seq.next());
        System.out.println(seq.next());
        System.out.println(seq.next());
        System.out.println(seq.next());
    }
}

interface Sequence<T> {
    default boolean hasNext() {
        return true;
    }

    T next();
}

class SquareSequence implements Sequence<BigInteger> {
    private BigInteger currentValue = BigInteger.ZERO;
    public BigInteger next() {
        BigInteger ret = currentValue.multiply(currentValue);
        currentValue = currentValue.add(BigInteger.ONE);
        return ret;
    }
}