import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ch1 {
    public static void main(String[] args) {
//        printLargest(2, 1, 0);
//        printExtremeDoubles();
//        System.out.println(factorial(BigInteger.valueOf(100)));
//        printString("Hello World");
//        printBase36();
//        printLotteryNumber();
//        System.out.println(generatePascalsTriangle(4));
//        System.out.println(average(1, 2));
//        Ch1.printInt(6);
//        Ch1.normalize359(1200);
//        Ch1.normalize359(-1300);
//        int[][] square = {
//                {16, 3, 2, 13},
//                {5, 10, 11, 8},
//                {9, 6, 7, 12},
//                {4, 15, 14, 1}
//        };
//        System.out.println(isMagicSquare(square));
    }

    private static void printInt(int integer) {
        System.out.printf("%f", (float) integer);
    }

    private static int normalize359 (int integer) {
        if (integer < 0) {
            integer = integer / -1;
        }
        while (integer > 359) {
            integer %= 359;
        }
//        integer = Math.abs(Math.floorMod(integer, 359));
        System.out.println(integer);
        return integer;
    }

    private static boolean isMagicSquare(int[][] square) {
        int[] firstRow = square[0];
        int sum = 0;
        int width = 0;

        for (int i : firstRow) {
            sum += i;
            width++;
        }

        for (int[] row : square) {
            int rowSum = 0;
            for (int i : row) {
                rowSum += i;
            }
            if (rowSum != sum) {
                return false;
            }
        }

        for (int i = 0; i < width; i++) {
            int columnSum = 0;
            for (int j = 0; j < width; j++) {
                columnSum += square[j][i];
            }
            if (columnSum != sum) {
                return false;
            }
        }

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int i = 0; i < width; i++) {
            diagonalSum1 += square[i][i];
            diagonalSum2 += square[i][width - 1 - i];
        }

        return diagonalSum1 == sum && diagonalSum2 == sum;
    }

    private static void printLargest(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }

        System.out.println(max);
    }

    private static void printLargestMax(int a, int b, int c) {
        int max = a;
        max = Math.max(max, b);
        max = Math.max(max, c);

        System.out.println(max);
    }

    private static void printExtremeDoubles() {
        System.out.println(Math.nextUp(0.0d));
        System.out.println(Math.nextDown(Double.POSITIVE_INFINITY));
    }

    private static BigInteger factorial(BigInteger n) {
        BigInteger res = BigInteger.ONE;
        while (n.compareTo(BigInteger.ONE) != 0) {

            res = res.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }

        return res;
    }

    private static void printString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ' ') {
                System.out.println(s.charAt(i));
            }
        }
    }

    private static void printBase36() {
        long r = new Random(1L).nextLong();

        System.out.println(Long.toString(r, 36));
    }

    private static void printLotteryNumber() {
        int[] base = new int[49];
        for (int i = 0; i < 49; i++) {
            base[i] = i + 1;
        }

        Random r = new Random();
        ArrayList<Integer> picked = new ArrayList<>();

        while (picked.size() < 7) {
            int i = r.nextInt(49);
            int current = base[i];
            if (current != 0) {
                picked.add(current);
                base[i] = 0;
            }
        }

        Collections.sort(picked);
        System.out.println(picked);
    }

    private static ArrayList<ArrayList<Integer>> generatePascalsTriangle(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int rowCounter = 0;
        int columnCounter = 0;
        do {
            if (columnCounter == 0) {
                res.add(new ArrayList<>());
            }

            ArrayList<Integer> row = res.get(rowCounter);

            if (columnCounter == 0 || columnCounter == rowCounter) {
                row.add(1);
            } else {
                ArrayList<Integer> previousRow = res.get(rowCounter - 1);
                row.add(previousRow.get(columnCounter - 1) + previousRow.get(columnCounter));
            }


            if (columnCounter == rowCounter) {
                columnCounter = 0;
            } else {
                columnCounter++;
            }

            if (columnCounter == 0) {
                rowCounter++;
            }
        } while (rowCounter < n);

        return res;
    }

    private static float average(int first, int... rest) {
        int sum = first;

        for (int value : rest) {
            sum += value;
        }

        return (float) sum / (rest.length + 1);
    }
}
