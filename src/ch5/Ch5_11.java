package ch5;

public class Ch5_11 {
    public static void main(String[] args) {
        System.out.println(factorial(3));
    }

    public static int factorial(int n) {
//        StackWalker walker = StackWalker.getInstance();
//        walker.forEach(frame -> System.out.printf("calculate: %d %s%n", n, frame));

        if (n == 1) {
            Exception ex = new Exception();
            ex.printStackTrace();

            return 1;
        }

        return n * factorial(n - 1);
    }
}
