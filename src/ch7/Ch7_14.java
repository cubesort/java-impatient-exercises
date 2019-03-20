package ch7;

import java.util.AbstractList;
import java.util.List;

public class Ch7_14 {
    public static void main(String[] args) {
        List<Integer> list = getImmutableList(5);
        System.out.println(list.get(3));
        System.out.println(list.size());
    }

    public static List<Integer> getImmutableList(int n) {
        return new AbstractList<>() {
           final private int cap = n;

            @Override
            public Integer get(int index) {
                if (index >= 0 && index < cap) {
                    return index;
                }
                return null;
            }

            @Override
            public int size() {
                return cap;
            }
        };
    }
}
