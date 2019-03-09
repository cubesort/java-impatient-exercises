package ch6;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ch6_12 {
    public static void main(String[] args) {

    }

    public static <T> void minMax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        T min = Collections.min(elements, comp);
        T max = Collections.max(elements, comp);

        result.add(min);
        result.add(max);
    }
}
