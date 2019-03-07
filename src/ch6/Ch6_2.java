package ch6;

import java.util.Arrays;
import java.util.function.IntFunction;

public class Ch6_2 {
    public static void main(String[] args) {
        ArrayStackObj<Integer> stack = new ArrayStackObj<>(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}

class ArrayStack<E> {
    private E[] stack;
    private int size = 0;
    private IntFunction<E[]> constr;

    public ArrayStack(IntFunction<E[]> constr, int capacity) {
        this.constr = constr;
        stack = constr.apply(capacity);
    }

    public E pop() {
        if (size > 0) {
            return stack[--size];
        }

        return null;
    }

    public void push(E element) {
        if (size == stack.length) {
            E[] newStack = constr.apply(size * 2);
            System.arraycopy(stack, 0, newStack, 0, size);
            stack = newStack;
        }
        stack[size++] = element;
    }

    public Boolean isEmpty() {
        return size == 0;
    }
}

class ArrayStackObj<E> {
    private E[] stack;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayStackObj(int capacity) {
        stack = (E[]) new Object[capacity];
    }

    public E pop() {
        if (size > 0) {
            return stack[--size];
        }

        return null;
    }

    public void push(E element) {
        if (size == stack.length) {
            System.out.printf("resizing from %d to %d%n", size, size * 2);
            stack = Arrays.copyOf(stack, size * 2);
        }

        stack[size++] = element;
    }

    public Boolean isEmpty() {
        return size == 0;
    }
}
