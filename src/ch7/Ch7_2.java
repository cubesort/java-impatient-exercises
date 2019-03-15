package ch7;

import java.util.*;

public class Ch7_2 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>(List.of("abc", "edf"));
//        toUpperCase(arr);
//        toUpperCaseLoop(arr);
        toUpperCaseReplaceAll(arr);
        System.out.println(arr);
    }

    public static void toUpperCase(ArrayList<String> arr) {
        ListIterator<String> iterator = arr.listIterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            iterator.set(s.toUpperCase());
        }
    }

    public static void toUpperCaseLoop(ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i).toUpperCase());
        }
    }

    public static void toUpperCaseReplaceAll(ArrayList<String> arr) {
        arr.replaceAll(String::toUpperCase);
    }
}
