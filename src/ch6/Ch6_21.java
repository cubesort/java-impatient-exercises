package ch6;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Ch6_21 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Ch6_21.<List<String>>constructArr(10)));
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public static <T> T[] constructArr(int length, T... values) {
        return (T[]) Array.newInstance(values.getClass().getComponentType(), length);
    }
}
