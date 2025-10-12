public class QueueArray {
    int front, rear, size, capacity;
    int[] queue;

    QueueArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(int item) {
        if (size == capacity) {
            System.out.println("Queue full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    int dequeue() {
        if (size == 0) {
            System.out.println("Queue empty");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    void display() {
        if (size == 0) {
            System.out.println("Queue empty");
            return;
        }
        for (int i = 0; i < size; i++)
            System.out.print(queue[(front + i) % capacity] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
    }
}
