import java.util.PriorityQueue;
import java.util.Scanner;

class Element implements Comparable<Element> {
    int value;
    int priority;

    // Constructor
    public Element(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    // Compare elements based on priority (higher priority comes first)
    @Override
    public int compareTo(Element other) {
        return Integer.compare(other.priority, this.priority); // Max-Heap style
    }

    @Override
    public String toString() {
        return "Value: " + value + ", Priority: " + priority;
    }
}

public class UserInputPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Element> priorityQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.priority, e1.priority));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Enqueue (Add Element)");
            System.out.println("2. Dequeue (Remove Highest Priority)");
            System.out.println("3. Peek (View Highest Priority)");
            System.out.println("4. Display All Elements");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int value = scanner.nextInt();
                    System.out.print("Enter priority: ");
                    int priority = scanner.nextInt();
                    priorityQueue.add(new Element(value, priority));
                    System.out.println("Enqueued: " + value + " with priority " + priority);
                    break;
                case 2:
                    if (priorityQueue.isEmpty()) {
                        System.out.println("Queue is empty. Cannot dequeue.");
                    } else {
                        Element removed = priorityQueue.poll();
                        System.out.println("Dequeued: " + removed);
                    }
                    break;
                case 3:
                    if (priorityQueue.isEmpty()) {
                        System.out.println("Queue is empty. Cannot peek.");
                    } else {
                        System.out.println("Highest Priority Element: " + priorityQueue.peek());
                    }
                    break;
                case 4:
                    if (priorityQueue.isEmpty()) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("All Elements in Priority Queue:");
                        PriorityQueue<Element> tempQueue = new PriorityQueue<>((e1, e2) -> Integer.compare(e2.priority, e1.priority));
                        tempQueue.addAll(priorityQueue);
                        while (!tempQueue.isEmpty()) {
                            System.out.println(tempQueue.poll());
                        }
                    }
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
Priority Queue
A Priority Queue is a specialized data structure where each element is associated with a priority, and elements with higher priority are served before those with lower priority. If two elements have the same priority, they are served according to their order in the queue (depending on implementation).

Key Characteristics of a Priority Queue
1.	Prioritized Processing: 
o	Elements are dequeued in order of priority.
2.	Order of Insertion: 
o	If priorities are equal, insertion order may determine processing order.
3.	Heap-Based Implementation: 
o	Commonly implemented using a heap for efficient insertion and deletion.

Algorithm for Priority Queue
Operations:
1.	Enqueue: 
o	Insert the element based on its priority into the queue.
o	Maintain the priority order in the queue.
2.	Dequeue: 
o	Remove and return the element with the highest priority.
3.	Peek: 
o	Return the element with the highest priority without removing it.

The queue stores elements as pairs of value and priority.

Step-by-Step Execution
1.	Initialization:
o	The queue is empty.
2.	Enqueue Operations:
o	Input: Value = 10, Priority = 3. 
	Add (10, 3) to the queue.
	Queue: [(10, 3)].
o	Input: Value = 20, Priority = 5. 
	Add (20, 5) to the queue.
	Queue: [(20, 5), (10, 3)].
o	Input: Value = 30, Priority = 4. 
	Add (30, 4) to the queue.
	Queue: [(20, 5), (10, 3), (30, 4)].
3.	Peek Operation:
o	Output: Highest Priority Element: (20, 5).
4.	Dequeue Operation:
o	Remove (20, 5) (highest priority).
o	Queue: [(30, 4), (10, 3)].
5.	Display Operation:
o	Output: 
o	Value: 30, Priority: 4
o	Value: 10, Priority: 3

Applications of Priority Queue
1.	CPU Scheduling:
o	Used in operating systems to manage tasks based on priority.
2.	Graph Algorithms:
o	Used in Dijkstra's and Prim's algorithms for finding shortest paths 
and minimum spanning trees.
3.	Event Simulation:
o	Simulating events where events are processed in priority order.
4.	Network Routing:
o	Managing packets in routers based on priority.
5.	Data Compression:
o	Used in Huffman encoding to build trees with prioritized nodes.

Complexity Analysis
Operation	Time Complexity	Space Complexity
Enqueue	O(log n)	O(n)
Dequeue	O(log n)	O(n)
Peek	O(1)	O(n)

*/