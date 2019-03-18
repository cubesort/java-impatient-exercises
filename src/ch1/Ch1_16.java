package ch1;

public class Ch1_16 {
    public static void main(String[] args) {
        System.out.println(average(1, 2));
    }

    public static float average(int first, int... rest) {
        int sum = first;

        for (int value : rest) {
            sum += value;
        }

        return (float) sum / (rest.length + 1);
    }
}
