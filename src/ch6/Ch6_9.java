package ch6;

import java.util.ArrayList;
import java.util.Collections;

public class Ch6_9 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        Pair<Integer> pair = firstLast(arr);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());

        Pair<Integer> minMax = minMax(arr);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }

    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<? extends E> arr) {
        E first = arr.get(0);
        E last = arr.get(arr.size() - 1);

        return new Pair<>(first, last);
    }

    public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<? extends E> arr) {
        E min = Collections.min(arr);
        E max = Collections.max(arr);

        return new Pair<>(min, max);
    }
}
