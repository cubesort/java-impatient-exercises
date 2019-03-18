package ch1;

public class Ch1_8 {
    public static void main(String[] args) {
        printString("Hello World");
    }

    public static void printString(String s) {
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current != ' ') {
                System.out.println(s.charAt(i));
            }
        }
    }
}
