package ch7;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ch7_3 {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(List.of(1, 2, 3));
        Set<Integer> s2 = new HashSet<>(List.of(3, 4, 5));

//        System.out.println(union(s1, s2));
//        System.out.println(intersection(s1, s2));
        System.out.println(difference(s1, s2));
    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> union = new HashSet<>();

        union.addAll(s1);
        union.addAll(s2);

        return union;
    }

    public static <E> Set<E> intersection(Set<E> s1, Set<E> s2) {
        Set<E> intersection = union(new HashSet<E>(), s1);
        intersection.retainAll(s2);

        return intersection;
    }

    public static <E> Set<E> difference(Set<E> s1, Set<E> s2) {
        Set<E> difference = new HashSet<>();
        difference.addAll(s1);
        difference.removeAll(s2);

        return difference;
    }
}
