package ch7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ch7_11 {
    public static void main(String[] args) {
        System.out.println(shuffleSentence("this is a very short sentence"));
    }

    public static String shuffleSentence(String sentence) {
        List<String> list = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        List<String> sublist = list.subList(1, list.size() - 1);
        Collections.shuffle(sublist);
        return String.join(" ", list);
    }
}
