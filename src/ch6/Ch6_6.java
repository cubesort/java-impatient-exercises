package ch6;

import java.util.ArrayList;

public class Ch6_6 {
    public static void main(String[] args) {
        ArrayList<Integer> listA = new ArrayList<>();
        listA.add(1);
        ArrayList<Integer> listB = new ArrayList<>();
        listB.add(2);
        append(listA, listB);
        System.out.println(listB);
        append2(listB, listA);
        System.out.println(listA);
    }

    public static <E> void append(ArrayList<E> source, ArrayList<? super E> dest) {
        for (E e : source) {
            dest.add(e);
        }
    }

    public static <E> void append2(ArrayList<? extends E> source, ArrayList<E> dest) {
        for (E e : source) {
            dest.add(e);
        }
    }
}
