package Ejercicio_02_sorting;

import java.util.Stack;  // Importar la pila estándar de Java

public class OrdenarStack {
    public static void ordenar(Stack<Integer> stack) {
        Stack<Integer> auxiliar = new Stack<>();  // Usa la pila auxiliar

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!auxiliar.isEmpty() && auxiliar.peek() > temp) {
                stack.push(auxiliar.pop());
            }
            auxiliar.push(temp);
        }
        while (!auxiliar.isEmpty()) {
            stack.push(auxiliar.pop());
        }
    }
}
