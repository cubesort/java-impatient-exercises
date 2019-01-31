package ch3;

public class Ch3_14 {
    public static void main(String[] args) {
        Runnable[] runnables = {
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(1);
                    }
                },
                () -> System.out.println(2)
        };

        Runnable run = concatRunnables(runnables);
        Thread thread = new Thread(run);
        thread.start();
    }

    public static Runnable concatRunnables(Runnable[] runnables) {
        return () -> {
          for (Runnable runnable : runnables) {
              runnable.run();
          }
        };
    }
}
