import java.util.Scanner;

public class CircularQueueWithUserInput {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueueWithUserInput(int size) {
        this.size = size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + element);
            return;
        }
        queue[rear] = element;
        rear = (rear + 1) % size;
        System.out.println("Enqueued: " + element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % size;
        System.out.println("Dequeued: " + element);
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1;
        }
        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        do {
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        } while (i != rear);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int size = scanner.nextInt();
        CircularQueueWithUserInput cq = new CircularQueueWithUserInput(size);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to enqueue: ");
                    int element = scanner.nextInt();
                    cq.enqueue(element);
                    break;
                case 2:
                    cq.dequeue();
                    break;
                case 3:
                    int frontElement = cq.peek();
                    if (frontElement != -1) {
                        System.out.println("Front Element: " + frontElement);
                    }
                    break;
                case 4:
                    cq.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

/*
2.	Circular Queue:
o	The rear connects back to the front to form a circular structure, making better use of space.

Circular Queue
A Circular Queue overcomes the limitations of the Simple Queue where unused spaces may arise after multiple dequeue operations. In a Circular Queue:
•	The last position is connected to the first position.
•	The queue operates in a circular fashion.

Algorithm for Circular Queue
Operations:
1.	Enqueue (Insertion):
o	Check if the queue is full: (rear + 1) % size == front.
o	If not full: 
	Insert the element at rear.
	Update rear = (rear + 1) % size.
2.	Dequeue (Deletion):
o	Check if the queue is empty: front == rear.
o	If not empty: 
	Remove the element at front.
	Update front = (front + 1) % size.
3.	Peek:
o	Return the element at front if the queue is not empty.
4.	IsEmpty:
o	Return true if front == rear.
5.	IsFull:
o	Return true if (rear + 1) % size == front.

Step-by-Step Execution
1.	Input: Enter the size of the queue: 5.
Queue size is initialized to 6 (5 + 1 for circular behavior).
2.	Operation 1 (Enqueue 10):
o	rear = 0, insert 10, update rear = 1.
o	Queue: [10, _, _, _, _, _].
3.	Operation 2 (Enqueue 20):
o	rear = 1, insert 20, update rear = 2.
o	Queue: [10, 20, _, _, _, _].
4.	Operation 3 (Dequeue):
o	front = 0, remove 10, update front = 1.
o	Queue: [10, 20, _, _, _, _] (logical state).
5.	Operation 4 (Display):
o	Output: 20.
6.	Operation 5 (Peek):
o	Front element: 20.
7.	Operation 6 (Enqueue 30):
o	rear = 2, insert 30, update rear = 3.
o	Queue: [10, 20, 30, _, _, _].

Applications of Circular Queue
1.	CPU Scheduling: Round-robin scheduling algorithms.
2.	Traffic Management: Managing circular queues in traffic lights.
3.	Buffer Management: Multimedia streaming and buffering.
4.	Memory Allocation: Efficient memory management in embedded systems.

Complexity Analysis
Operation	Time Complexity	Space Complexity
Enqueue	O(1)	O(n)
Dequeue	O(1)	O(n)
Peek	O(1)	O(n)

*/
