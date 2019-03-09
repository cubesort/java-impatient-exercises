package ch6;

import java.util.Arrays;

public class Ch6_20 {
    public static void main(String[] args) {
        String[] arr = repeat(2, "a", "b");
        System.out.println(Arrays.toString(arr));
    }

    @SafeVarargs
    public static final <T> T[] repeat(int n, T... objs) {
        @SuppressWarnings("unchecked")
        T[] res = (T[]) java.lang.reflect.Array.newInstance(objs.getClass().getComponentType(), n * objs.length);

        for (int i = 0; i < objs.length; i++) {
            System.arraycopy(objs, 0, res, i * objs.length, objs.length);
        }

        return res;
    }
}
