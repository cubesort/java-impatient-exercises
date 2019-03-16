package ch7;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Ch7_5 {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>(List.of("a", "b", "c", "d", "e", "f"));
        swap(list, 1, 4);

        System.out.println(list);
    }

    public static <E> void swap(List<E> list, int i, int j) {
        if (list instanceof RandomAccess) {
            E temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        } else {
            if (i > j) {
                int temp = i;
                i = j;
                j = temp;
            }

            ListIterator<E> iterator = list.listIterator(i);
            E temp1 = iterator.next();

            for (int n = i + 1; n < j; n++) {
                iterator.next();
            }
            E temp2 = iterator.next();
            iterator.set(temp1);

            for (int n = j; n >= i; n--) {
                iterator.previous();
            }
            iterator.set(temp2);
        }
    }
}
