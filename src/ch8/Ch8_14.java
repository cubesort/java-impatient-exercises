package ch8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ch8_14 {
    public static void main(String[] args) {
        Stream<ArrayList<Integer>> lists = new ArrayList<>(List.of(
                new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of(4, 5, 6))
        )).stream();

//        System.out.println(reduceJoin1(lists));
//        System.out.println(reduceJoin2(lists));
        System.out.println(reduceJoin3(lists));
    }

    public static <T> ArrayList<T> reduceJoin1(Stream<ArrayList<T>> lists) {
        return lists.reduce((acc, list) -> {
            acc.addAll(list);
            return acc;
        }).orElse(new ArrayList<>());
    }

    public static <T> ArrayList<T> reduceJoin2(Stream<ArrayList<T>> lists) {
        return lists.reduce(new ArrayList<>(), (acc, list) -> {
            acc.addAll(list);
            return acc;
        });
    }

    public static <T> ArrayList<T> reduceJoin3(Stream<ArrayList<T>> lists) {
        return lists.reduce(new ArrayList<>(), (acc, list) -> {
            acc.addAll(list);
            return acc;
        }, (a, b) -> {
            a.addAll(b);
            return a;
        });
    }
}
