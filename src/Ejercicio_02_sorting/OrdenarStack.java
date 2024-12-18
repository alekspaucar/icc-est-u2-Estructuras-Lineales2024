package Ejercicio_02_sorting;

import java.util.Stack;

public class OrdenarStack {
    public static void ordenar(Stack<Integer> stack) {
        
        Stack<Integer> auxiliar = new Stack<>();

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