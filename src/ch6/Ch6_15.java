package ch6;

import java.util.ArrayList;
import java.util.function.Function;

public class Ch6_15 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        ArrayList<Integer> mapped = map(arr, e -> e * 2);
        System.out.println(mapped);
    }

    public static <T, R> ArrayList<R> map(ArrayList<T> arr, Function<? super T, ? extends R> func) {
        ArrayList<R> res = new ArrayList<>();
        arr.forEach((element) -> res.add(func.apply(element)));

        return res;
    }
}
