package Materia.Queues;

import java.util.NoSuchElementException;

import Materia.Models.Node;

public class Queue {
    private Node front; //nodo al frente de la cola
    private Node rear; //nodo al final de la cola
    private int size;

    //Creamos unaa cola con nodos vacios
    public Queue(){
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    //metodo para encolar nodos
    public void enqueue(int value){
        Node newNode = new Node(value);
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
    public Node dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("La cola esta vacia");
        }
        Node node = front;
        front = front.getNext();
        if(front ==null){
            rear = null;
        }
        return node;
    }
    public Node peek(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return front;
    }
    public void printQueue(){
        Node current = front;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
    public int getSize(){
        int cont = 0;
        Node current = front;
        while (current != null) {
            cont++;
            current = current.getNext();
        }
        return cont;
    }

    public int getSize2(){
        return size;
    }
}