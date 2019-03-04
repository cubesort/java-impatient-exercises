package ch5;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ch5_5 {
    public static void main(String[] args) {

    }

    public static void print(String inFilename, String outFilename) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(inFilename));
            out = new PrintWriter(outFilename);

            while (in.hasNext()) {
                out.println(in.next());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (in != null) {
                in.close();
            }

            if (out != null) {
                out.close();
            }
        }

    }
}
