package ch3;

public class Ch3_4 {
    public static void main(String[] args) {
        IntSequence seq = IntSequence.of(3, 1, 4, 1, 5, 6);
        System.out.println(seq.hasNext());
        System.out.println(seq.next());

        IntSequence constant = IntSequence.constant(1);
        System.out.println(constant.next());
        System.out.println(constant.next());
    }
}

interface IntSequence {
    int next();

    default boolean hasNext() {
        return true;
    }

    static IntSequence of (int... numbers) {
        return new IntSequence() {
            private int counter = 0;

            public boolean hasNext() {
                return counter < numbers.length;
            }

            public int next() {
                counter++;
                return numbers[counter - 1];
            }
        };
    }

    static IntSequence constant (int value) {
        return () -> value;
    }
}