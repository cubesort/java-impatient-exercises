package ch1;

import java.util.ArrayList;

public class Ch1_15 {
    public static void main(String[] args) {
        System.out.println(generatePascalsTriangle(4));
    }

    public static ArrayList<ArrayList<Integer>> generatePascalsTriangle(int n) {
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
}
