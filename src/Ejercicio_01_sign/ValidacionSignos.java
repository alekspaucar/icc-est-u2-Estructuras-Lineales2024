package Ejercicio_01_sign;

import java.util.Stack;

public class ValidacionSignos {
    
    public static boolean esValido(String str) {
        Stack<Character> pila = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                pila.push(c);
            } else if (c == ')' && !pila.isEmpty() && pila.peek() == '(') {
                pila.pop();
            } else if (c == '}' && !pila.isEmpty() && pila.peek() == '{') {
                pila.pop();
            } else if (c == ']' && !pila.isEmpty() && pila.peek() == '[') {
                pila.pop();
            } else {
                return false;
            }
        }
        return pila.isEmpty();
    }
}