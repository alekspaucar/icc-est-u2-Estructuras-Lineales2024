import Controller.MenuController;
import Ejercicio_01_sign.ValidacionSignos;
import Ejercicio_02_sorting.OrdenarStack; // Asegúrate de importar correctamente
import Materia.Queues.Queue;
import Materia.Queues.QueueGeneric;
import Materia.Stacks.StackGeneric;
import Models2.Pantalla;
import java.util.Stack; // Pila estándar de Java

public class App {
    public static void main(String[] args) throws Exception {
        runSignValidator();

        // Usar la pila estándar de Java para OrdenarStack
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Stack original: " + stack);
        OrdenarStack.ordenar(stack); // Ordenar la pila estándar de Java
        System.out.println("Stack ordenado: " + stack);

        runStackGeneric(); // Usando StackGeneric
        runQueue();
        runQueueGeneric();
        runControllerManager();
    }

    public static void runSignValidator() {
        String input1 = "([]){}";
        String input2 = "({})";
        String input3 = "[{()}]";

        System.out.println("Input: " + input1 + " -> " + ValidacionSignos.esValido(input1));
        System.out.println("Input: " + input2 + " -> " + ValidacionSignos.esValido(input2));
        System.out.println("Input: " + input3 + " -> " + ValidacionSignos.esValido(input3));
    }

    private static void runControllerManager() {
        MenuController menuController = new MenuController();
        menuController.showMenu();
    }

    public static void runQueue() {
        Queue cola = new Queue();
        cola.enqueue(10);
        cola.enqueue(20);
        cola.enqueue(30);
        cola.enqueue(40);

        cola.printQueue();
        int cont = cola.getSize();
        System.out.println("Tamaño: " + cont);

        System.out.println(cola.peek());
        System.out.println(cola.dequeue());
        System.out.println(cola.dequeue());
        System.out.println(cola.peek());
    }

    public static void runQueueGeneric() {
        System.out.println("-------------");
        QueueGeneric<Pantalla> cola = new QueueGeneric<>();

        cola.enqueue(new Pantalla(1, "Home page", "/home"));
        cola.enqueue(new Pantalla(1, "Menu page", "/home/menu"));
        cola.enqueue(new Pantalla(1, "Users page", "/home/menu/users"));

        System.out.println("Estoy en " + cola.dequeue().getRuta());
        System.out.println("Estoy en " + cola.peek().getRuta());
    }

    public static void runStackGeneric() {
        StackGeneric<Pantalla> router = new StackGeneric<>();

        router.push(new Pantalla(1, "Home page", "/home"));
        router.push(new Pantalla(1, "Menu page", "/home/menu"));
        router.push(new Pantalla(1, "Users page", "/home/menu/users"));

        System.out.println("Estoy en " + router.peek().getRuta());
        System.out.println("Regreso a " + ((router.popNode().getNext().getValue())).getRuta());
        System.out.println("Estoy en " + router.peek().getRuta());

        router.push(new Pantalla(1, "Settings Page", "/home/menu/settings"));

        System.out.println("Pantalla = " + router.getSize());
        System.out.println("Estoy en " + router.peek().getRuta());
        router.printStack();
    }
}
