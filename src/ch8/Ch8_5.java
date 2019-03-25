package ch8;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ch8_5 {
    public static void main(String[] args) {
        Stream<String> offsets = stringToStream("serendipity");
        System.out.println(Arrays.toString(offsets.toArray()));
    }

    public static Stream<String> stringToStream(String str) {
        int len = str.codePointCount(0, str.length());
        return Stream
                .iterate(0, prev -> prev < len, prev -> str.offsetByCodePoints(prev, 1))
                .map(offset -> str.substring(offset, str.offsetByCodePoints(offset, 1)));
    }
}
