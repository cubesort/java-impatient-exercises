package ch7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Ch7_8 {
    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir");
            Map<String, Set<Integer>> counts = findLines(path + "/resources/words.txt");
            System.out.println(counts);
        } catch(IOException ex) {
            System.out.println(ex.toString());
        }
    }

    public static Map<String, Set<Integer>> findLines(String filename) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            Map<String, Set<Integer>> lineMap = new HashMap<>();

            String line = in.readLine();
            int lineNumber = 1;
            while (line != null) {
                String[] words = line.split("[^\\w]");
                for (String word : words) {
                    if (!word.equals("")) {
                        Set<Integer> lines = lineMap.getOrDefault(word, new TreeSet<>());
                        lines.add(lineNumber);
                        lineMap.put(word, lines);
                    }
                }
                lineNumber++;
                line = in.readLine();
            }

            return lineMap;
        }
    }
}
