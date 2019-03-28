package ch8;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Ch8_13 {
    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(6, 7, 8, 9);

        System.out.println(Arrays.toString(zip(s1, s2).toArray()));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iter = second.iterator();
        Stream<T> ret = first.flatMap((e) -> {
            if (iter.hasNext()) {
                T el = iter.next();
                return Stream.of(e, el);
            }

            return Stream.of(e, null);
        });

        if (iter.hasNext()) {
            Stream<T> secondHalf = StreamSupport
                    .stream(Spliterators.spliteratorUnknownSize(iter, 0), false)
                    .flatMap(e -> Stream.of(null, e));

            ret = Stream.concat(ret, secondHalf);
        }

        return ret;
    }
}
