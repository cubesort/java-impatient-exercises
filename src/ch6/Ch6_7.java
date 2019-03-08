package ch6;

public class Ch6_7 {
    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(1, 2);
        System.out.println(pair.min());
        System.out.println(pair.max());
    }
}

class Pair<E extends Comparable> {
    private E first;
    private E second;

    public Pair (E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public E max() {
        Comparable a = (Comparable) first;
        Comparable b = (Comparable) second;
        if (a.compareTo(b) >= 0) {
            return first;
        }

        return second;
    }

    public E min() {
        E max = max();
        if (max == first) {
            return second;
        }

        return first;
    }
}
