import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Ch2 {
    public static void main(String[] args) {
//        String[] date = { "2", "2019" };
//        Cal.generateCal(date);
//        Point p = new Point(3, 4).translate(1, 3).scale(0.5f);
//        System.out.println(p.getX());
//        System.out.println(p.getY());
//        Point p1 = new Point();
//        Car car = new Car();
//        car.move(100);
//        System.out.println(car.getGas());
//        System.out.println(car.getLocation());
//        car.addGas(10);
//        System.out.println(car.getGas());
//        System.out.println(car.getLocation());
//        int[] array = { 1, 2, 3, 4, 5 };
//        System.out.println(RandomNumbers.randomElement(array));
//        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        for (int item : array) {
//            arrayList.add(item);
//        }
//        System.out.println(RandomNumbers.randomElement(arrayList));
//        Queue queue = new Queue();
//        queue.add("0");
//        queue.add("1");
//        queue.add("2");
//        System.out.println(queue.getHead());
//        System.out.println(queue.getTail());
//        queue.remove();
//        System.out.println(queue.getHead());
//        System.out.println(queue.getTail());
//        Queue.Iterator iterator = queue.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
    }
}

class Cal {
    public static void generateCal(String[] args) {
        LocalDate date = LocalDate.now().withDayOfMonth(1);
        int month;
        if (args.length >= 2) {
            month = Integer.parseInt(args[0]);
            int year = Integer.parseInt(args[1]);
            date = LocalDate.of(year, month, 1);
        } else {
            month = date.getMonthValue();
        }

        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, ... 7 = Sunday
        for (int i = 0; i < value && i < 7; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 7)
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 7)
            System.out.println();
    }
}

class Point {
    private float x;
    private float y;

    public Point (float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point () { }

    public Point translate(float offsetX, float offsetY) {
        this.x += offsetX;
        this.y += offsetY;

        return this;
    }

    public Point scale(float scaleBy) {
        this.x *= scaleBy;
        this.y *= scaleBy;

        return this;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}

class RandomNumbers {
    public static int randomElement(ArrayList<Integer> array) {
        if (array.size() == 0){
            return 0;
        }

        Random random = new Random();
        int i = random.nextInt(array.size());

        return array.get(i);
    }

    public static int randomElement(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        Random random = new Random();
        int i = random.nextInt(array.length);

        return array[i];
    }
}

class Car {
    private final int milePerGallon;
    private int location;
    private int gas = 100;

    public Car() {
        this.milePerGallon = 20;
    }

    public Car(int milePerGallon) {
        this.milePerGallon = milePerGallon;
    }

    public void move(int distance) {
        this.location += distance;
        this.gas -= distance / milePerGallon;
    }

    public int getGas() {
        return gas;
    }

    public int getLocation() {
        return location;
    }

    public void addGas(int gas) {
        this.gas += gas;
    }
}

class Queue {
    class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    class Iterator {
        Node current = head;

        public String next() {
            String currentValue = current.value;
            current = current.next;
            return currentValue;
        }
    }

    private Node head;
    private Node tail;

    public Queue.Iterator iterator() {
        return new Iterator();
    }

    public void add(String value) {
        if (this.tail != null) {
            this.tail.next = new Node(value);
            this.tail = this.tail.next;
        } else {
            this.head = new Node(value);
            this.tail = this.head;
        }
    }

    public void remove() {
        if (this.head != null) {
            this.head = this.head.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }
}