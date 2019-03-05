package ch5;

public class Ch5_13 {
    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4 };
        System.out.println(min(values));
    }

    public static int min(int[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("array can't be empty");
        }

        int min = values[0];
        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }

        assert checkMin(values, min);

        return min;
    }

    public static Boolean checkMin(int[] values, int value) {
        for (int v : values) {
            if (v < value) {
                return false;
            }
        }

        return true;
    }
}
