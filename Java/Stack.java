public class Stack {
    int top = -1;
    int[] stack;

    Stack(int size) {
        stack = new int[size];
    }

    void push(int value) {
        if (top == stack.length - 1) {
            System.out.println("Overflow");
            return;
        }
        stack[++top] = value;
    }

    int pop() {
        if (top == -1) {
            System.out.println("Underflow");
            return -1;
        }
        return stack[top--];
    }

    int peek() {
        return (top == -1) ? -1 : stack[top];
    }

    void display() {
        for (int i = 0; i <= top; i++) System.out.print(stack[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack(5);
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();
        System.out.println(s.peek());
        s.pop();
        s.display();
    }
}
