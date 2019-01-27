package ch3;

public class ch3_10 {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("r1");

        Runnable r2 = () -> System.out.println("r2");

        runTogether(r1, r2);
        runInOrder(r1, r2);
    }

    public static void runTogether(Runnable... tasks) {
        for (Runnable task : tasks) {
            new Thread(task).start();
        }
    }

    public static void runInOrder(Runnable... tasks) {
        for (Runnable task : tasks) {
            task.run();
        }
    }
}
