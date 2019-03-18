package ch2;

public class Ch2_16 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add("0");
        queue.add("1");
        queue.add("2");
        System.out.println(queue.getHead());
        System.out.println(queue.getTail());
        queue.remove();
        System.out.println(queue.getHead());
        System.out.println(queue.getTail());
        Queue.Iterator iterator = queue.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
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