package ch2;

import java.util.ArrayList;
import java.util.Random;

public class Ch2_10 {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5 };
        System.out.println(ch2.RandomNumbers.randomElement(array));
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int item : array) {
            arrayList.add(item);
        }
        System.out.println(ch2.RandomNumbers.randomElement(arrayList));
    }
}

class RandomNumbers {
    public static int randomElement(ArrayList<Integer> array) {
        if (array.size() == 0){
            return 0;
        }

        Random random = new Random();
        int i = random.nextInt(array.size());

        return array.get(i);
    }

    public static int randomElement(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        Random random = new Random();
        int i = random.nextInt(array.length);

        return array[i];
    }
}
