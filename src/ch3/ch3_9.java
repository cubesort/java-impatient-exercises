package ch3;

public class ch3_9 {
    static public void main(String[] args) {
        Greeter alex = new Greeter("Alex", 3);
        Greeter aaron = new Greeter("Aaron", 2);

        Thread threadAlex = new Thread(alex);
        Thread threadAaron = new Thread(aaron);

        threadAlex.start();
        threadAaron.start();
    }
}

class Greeter implements Runnable {
    private String target;
    private int times;

    Greeter(String target, int times) {
        this.target = target;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.times; i++) {
            System.out.println(this.target);
        }
    }
}