package ch7;

import java.util.AbstractList;
import java.util.List;
import java.util.function.IntFunction;

public class Ch7_16 {
    public static void main(String[] args) {
        List<Double> list = getImmutableListCached(Double::valueOf);
        list.get(100);
        System.out.println(list.get(100));
    }

    public static <E> List<E> getImmutableListCached(IntFunction<E> fn) {
        return new AbstractList<>() {
            private Ch7_13.Cache<Integer, E> cache = new Ch7_13.Cache<>(100);

            @Override
            public E get(int index) {
                if (cache.containsKey(index)) {
                    System.out.printf("retrieve result for %d from cache\n", index);
                    return cache.get(index);
                }

                E ret = fn.apply(index);
                cache.put(index, ret);
                return ret;
            }

            @Override
            public int size() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
