package ch1;

public class Ch1_14 {
    public static void main(String[] args) {
        int[][] square = {
                {16, 3, 2, 13},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}
        };
        System.out.println(isMagicSquare(square));
    }

    public static boolean isMagicSquare(int[][] square) {
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
}
