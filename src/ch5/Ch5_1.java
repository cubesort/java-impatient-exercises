package ch5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ch5_1 {
    public static void main(String[] args) {
        try {
            System.out.println(readValues("./data.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public static ArrayList<Double> readValues(String filename) throws FileNotFoundException {
        ArrayList<Double> lines = new ArrayList<>();

        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextDouble()) {
                lines.add(in.nextDouble());
            }
        }

        return lines;
    }
}
