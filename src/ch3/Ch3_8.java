package ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ch3_8 {
    static public void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aa");
        strings.add("aaa");
        strings.add("a");

        luckySort(strings, (s1, s2) -> s1.length() - s2.length());

        System.out.println(strings);
    }

    static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        while (!isSorted(strings, comp)) {
            Collections.shuffle(strings);
        }
    }

    static boolean isSorted (ArrayList<String> strings, Comparator<String> comp) {
        for (int i = 0; i < strings.size() - 1; i++) {
            if (comp.compare(strings.get(i), strings.get(i + 1)) > 0) {
                return false;
            }
        }

        return true;
    }
}
