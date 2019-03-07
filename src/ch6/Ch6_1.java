package ch6;

import java.util.ArrayList;

public class Ch6_1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.isEmpty());
        Integer poped = stack.pop();
        System.out.println(poped);
        System.out.println(stack.isEmpty());
    }
}

class Stack<E> {
    private ArrayList<E> stack = new ArrayList<>();
    private int size = 0;

    public void push(E element) {
        stack.add(element);
        size++;
    }

    public E pop() {
        if (size > 0) {
            E last = stack.get(size - 1);
            stack.remove(size - 1);
            size--;
            return last;
        }

        return null;
    }

    public Boolean isEmpty() {
        return size == 0;
    }
}
