package com.company;

class Queue<E>{
    private E[] elements;
    private int index = 0;
    private int size;

    Queue(int size) {
        elements = (E[]) new Object[size];
        this.size = size;
    }

    void enqueue(E element ) throws StackFullException {
        if (index >= size) {
            throw new StackFullException();
        }

        elements[index] = element;
        index++;
    }

    E dequeue () throws StackEmptyException {
        if (index == 0) {
            throw new StackEmptyException();
        }
E returnElement= elements[0];


        for (int i = 0; i < size-2; i++) {
            elements[i]=elements[i+1];

        }
        elements[4]=null;
        index--;
        return returnElement;
    }
}


public class Main {
    public static void main(String[] args) {
        Queue<String> strings = new Queue<>(5);
        try {
            strings.enqueue("Hello");
            System.out.println(strings.dequeue());
            strings.enqueue("World");
            strings.enqueue("!");
            strings.enqueue("I am in");
            strings.enqueue("Pain!");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
            strings.enqueue("Hello");
            strings.enqueue("World");
            System.out.println(strings.dequeue());
            strings.enqueue("Hello");
            System.out.println(strings.dequeue());
            System.out.println(strings.dequeue());
        } catch (StackFullException | StackEmptyException e) {
            e.printStackTrace();
        }

    }
}

