package ch5;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Ch5_2 {
    public static void main(String[] args) {
        try {
            double sum = sumOfValues("./data.txt");
            System.out.println(sum);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

    }

    public static double sumOfValues(String filename) throws FileNotFoundException {
        ArrayList<Double> values = Ch5_1.readValues(filename);

        double sum = 0;
        for (Double value : values) {
            sum += value;
        }

        return sum;
    }
}
