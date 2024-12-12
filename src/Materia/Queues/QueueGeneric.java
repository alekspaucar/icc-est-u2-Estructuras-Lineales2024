package Materia.Queues;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import Materia.Models.NodeGeneric;

public class QueueGeneric<T> {
    private NodeGeneric<T> front; //nodo al frente de la cola
    private NodeGeneric<T> rear; //nodo al final de la cola
    private int size;

    public QueueGeneric(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    //metodo para encolar nodos
    public void enqueue(T value){
        NodeGeneric<T> newNode = new NodeGeneric<>(value);
        if(isEmpty()){
            front = newNode;
            rear = newNode;
        }else{
            rear.setNext(newNode);
            rear = newNode;
        }    
    }

    public boolean isEmpty(){
        return front == null;
    }

    //Desencolar
    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("La cola esta vacia");
        }
        T node = front.getValue();
        front = front.getNext();
        if(front ==null){
            rear = null;
        }
        return node;
    }
    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return front.getValue();
    }

    public int getSize(){
        int cont = 0;
        NodeGeneric<T> current = front;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    public int getSize2(){
        return size;
    }
    public void printQueueGeneric(){
        NodeGeneric<T> current = front;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
    public NodeGeneric<T> popNode(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        NodeGeneric<T> value = front;
        front = front.getNext();
        size--;
        return value;
    }
}