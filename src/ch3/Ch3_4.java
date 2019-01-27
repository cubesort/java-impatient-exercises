package ch3;

public class Ch3_4 {
    public static void main(String[] args) {
        IntSequence seq = IntSequence.of(3, 1, 4, 1, 5, 6);
        System.out.println(seq.hasNext());
        System.out.println(seq.next());
    }
}

interface IntSequence {
    int next();

    boolean hasNext();

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
}