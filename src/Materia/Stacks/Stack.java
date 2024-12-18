package Materia.Stacks;

import Materia.Models.NodeGeneric;
import java.util.EmptyStackException;

public class Stack<T> {  // Cambiar a Stack<T> para hacerlo genérico
    
    private NodeGeneric<T> top;
    private int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T value) {  // Cambiar a T
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getValue();
    }

    public void printStack() {
        NodeGeneric<T> current = top;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public int getSize() {
        int cont = 0;
        NodeGeneric<T> current = top;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    public int getSize2() {
        return size;
    }

    public NodeGeneric<T> popNode() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        NodeGeneric<T> value = top;
        top = top.getNext();
        size--;
        return value;
    }
}
