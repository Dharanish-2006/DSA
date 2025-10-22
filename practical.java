1. Stack using LinkedList

import java.util.*;

public class Stackll {
    public static void main(String args[]) {

        LinkedList<Integer> s = new LinkedList<Integer>();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        System.out.println("Initial Stack: " + s);
        System.out.println("The element at the top of the Stack is: " + s.peek());

        s.pop();
        System.out.println("The elements in Stack after pop: " + s);
        System.out.println("The size of the Stack is: " + s.size());
    }
}


2.  Stack using Array

import java.util.*;

public class StackArray {
    public static void main(String args[]) {
        int maxSize = 5;
        int[] stack = new int[maxSize];
        int top = -1;

        // Push elements
        stack[++top] = 10;
        stack[++top] = 20;
        stack[++top] = 30;
        stack[++top] = 40;
        stack[++top] = 50;

        System.out.print("Initial Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();

        // Peek element
        System.out.println("The element at the top of the Stack is: " + stack[top]);

        // Pop operation
        top--;
        System.out.print("The elements in Stack after pop: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();

        // Size of stack
        System.out.println("The size of the Stack is: " + (top + 1));
    }
}

3.  Queue using Linked List

import java.util.*;

public class Queuell {
    public static void main(String args[]) {

        Queue<Integer> q = new LinkedList<Integer>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println("Initial Queue: " + q);

        System.out.println("The element at the front of the Queue is: " + q.peek());

         q.remove();
        System.out.println("The elements in Queue after dequeue: " + q);

                System.out.println("The size of the Queue is: " + q.size());
    }
}

4. Queue using Array

import java.util.*;

public class QueueArray {
    public static void main(String args[]) {
        int maxSize = 5;
        int[] queue = new int[maxSize];
        int front = 0, rear = -1, size = 0;

        // Enqueue elements
        queue[++rear] = 10;
        size++;
        queue[++rear] = 20;
        size++;
        queue[++rear] = 30;
        size++;
        queue[++rear] = 40;
        size++;
        queue[++rear] = 50;
        size++;

        System.out.print("Initial Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();

        // Peek element
        System.out.println("The element at the front of the Queue is: " + queue[front]);

        // Dequeue operation
        front++;
        size--;

        System.out.print("The elements in Queue after dequeue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();

        // Size of Queue
        System.out.println("The size of the Queue is: " + size);
    }
}

5. Postfix Evaluation

import java.util.*;

public class Eval {
    static int evaluate(String exp) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isDigit(c)) {
                s.push(c - '0');  // Convert char digit to int
            } else {
                int val1 = s.pop();
                int val2 = s.pop();

                if (c == '+')
                    s.push(val2 + val1);
                else if (c == '-')
                    s.push(val2 - val1);
                else if (c == '*')
                    s.push(val2 * val1);
                else if (c == '/')
                    s.push(val2 / val1);
            }
        }
        return s.pop();
    }

    public static void main(String[] args) {
        String exp = "23-";
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Postfix Evaluation: " + evaluate(exp));
    }
}
