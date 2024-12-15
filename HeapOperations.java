import java.util.Scanner;
class Heap {
    private int[] heap;
    private int size;
    private int capacity;
    // Constructor to initialize the heap
    public Heap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Utility function to get parent index
    private int parent(int index) {
        return (index - 1) / 2;
    }
    // Utility function to get left child index
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    // Utility function to get right child index
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    // a) Insert an element into the heap
    public void insert(int value) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full!");
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }
    private void heapifyUp(int index) {
        int temp = heap[index];
        while (index > 0 && temp > heap[parent(index)]) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = temp;
    }
    // b) Create a heap using Heapify method
    public void buildHeap(int[] array) {
        size = array.length;
        System.arraycopy(array, 0, heap, 0, size);
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // c) Perform Heap Sort
    public void heapSort() {
        int originalSize = size;
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            size--;
            heapifyDown(0);
        }
        size = originalSize;
    }
    // d) Delete the root value from the heap
    public int delete() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty!");
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }
    // Utility function to swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    // Display the heap
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
public class HeapOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the capacity of the heap:");
        int capacity = scanner.nextInt();
        Heap heap = new Heap(capacity);
        while (true) {
            System.out.println("\nHeap Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Build Heap (Heapify)");
            System.out.println("3. Perform Heap Sort");
            System.out.println("4. Delete Root");
            System.out.println("5. Display Heap");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    heap.insert(value);
                    System.out.println(value + " inserted.");
                    break;
                case 2: // Build Heap
                    System.out.print("Enter the number of elements: ");
                    int n = scanner.nextInt();
                    int[] array = new int[n];
                    System.out.println("Enter the elements:");
                    for (int i = 0; i < n; i++) {
                        array[i] = scanner.nextInt();
                    }
                    heap.buildHeap(array);
                    System.out.println("Heap built using heapify.");
                    break;
                case 3: // Heap Sort
                    System.out.println("Performing Heap Sort...");
                    heap.heapSort();
                    heap.display();
                    System.out.println("Heap Sort completed.");
                    break;
                case 4: // Delete Root
                    try {
                        int deletedValue = heap.delete();
                        System.out.println("Deleted root value: " + deletedValue);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5: // Display Heap
                    System.out.println("Current Heap:");
                    heap.display();
                    break;
                case 6: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

/*
A Heap is a specialized binary tree-based data structure that satisfies the heap property:
1.	Max-Heap: The value of each node is greater than or equal to the values of its children.
2.	Min-Heap: The value of each node is less than or equal to the values of its children.
Heap is often implemented using an array because of its structural properties:
•	The root is at index 0 (or 1 for 1-based indexing).
•	The left child of a node at index i is at index 2*i + 1.
•	The right child of a node at index i is at index 2*i + 2.
•	The parent of a node at index i is at index (i-1)/2.

Applications of Heaps
Heaps have a wide range of applications due to their efficiency in managing priorities and ordering:
1. Priority Queues
•	Definition: A priority queue is a data structure where elements are retrieved in order of priority.
•	Heap Usage: Heaps are the ideal choice for implementing priority queues because insertion and extraction of the highest/lowest priority element can be done in O(logn)
•	Example: Job scheduling in operating systems.
2. Heap Sort
•	Definition: A sorting algorithm that uses a heap to sort elements.
•	How It Works: Build a heap, then repeatedly extract the maximum (or minimum) and rebuild the heap.
•	Time Complexity: O(nlogn)
3. Graph Algorithms
•	Used in algorithms like Dijkstra's shortest path and Prim's Minimum Spanning Tree, where heaps are used to efficiently retrieve the next vertex with the smallest weight.
4. Median Maintenance
•	A combination of min-heap and max-heap can be used to maintain the median of a dynamic dataset efficiently.
5. Task Scheduling
•	Heaps are used to schedule tasks based on deadlines or priorities (e.g., CPU task scheduling).
6. Kth Largest/Smallest Element
•	Heaps efficiently find the k-th largest or smallest element in O(k+(n−k)log⁡k) time.

Heap and Memory Management
Heaps play an essential role in dynamic memory management in programming languages like C, C++, Java, and Python. Here's how:
1. Heap Memory Allocation
•	Definition: Heap memory is a region of a process's memory used for dynamic allocation.
•	How It Works: 
o	Memory is allocated and deallocated explicitly by the programmer (e.g., malloc/free in C or new/delete in C++).
o	The system uses a heap data structure to manage the free and used memory blocks efficiently.
2. Efficient Memory Allocation
•	When memory is requested, the system uses the heap to locate a free memory block of the required size.
•	Min-Heap can be used to maintain free memory blocks sorted by size, ensuring the smallest sufficient block is allocated.
3. Garbage Collection
•	Modern programming languages like Java and Python use heaps to track dynamically allocated memory.
•	A garbage collector reclaims unused memory by traversing the heap to find objects that are no longer reachable.
4. Fragmentation Management
•	The heap data structure helps reduce fragmentation by merging adjacent free blocks when memory is deallocated.

Comparison: Heap in Data Structure vs. Heap in Memory Management
Aspect	Heap in Data Structure	Heap in Memory Management
Purpose	Prioritization and efficient retrieval.	Dynamic memory allocation.
Type	Binary tree (Max-Heap or Min-Heap).	Managed area of memory.
Usage	Priority queues, sorting, etc.	Allocating and deallocating memory.
Managed By	Developer implements it explicitly.	Operating system or runtime.

Key Points About Heap's Utility in Memory Management
1.	Dynamic Allocation: Enables programs to allocate memory at runtime.
2.	Efficient Access: Reduces search time for finding free memory blocks.
3.	Fragmentation Control: Merges and reorganizes free memory to avoid waste.
4.	Scalability: Handles varying memory requests efficiently, suitable for complex applications.

Examples of Heap Usage
1.	Finding the Top K Elements
o	Use a Min-Heap to efficiently find the largest KK elements in a dataset.
2.	Shortest Path (Dijkstra's Algorithm)
o	Use a Min-Heap to prioritize nodes with the smallest distance.
3.	Memory Allocation
o	Allocate a block of memory when requested and deallocate it when no longer needed.

Step-by-Step Execution
1.	Insert an Element
o	Add the element to the end of the array.
o	"Heapify up" to restore the heap property.
o	Example: 
	Insert 10, 20, 15 into a heap.
	Heap after insertion: [20, 10, 15].
2.	Build Heap Using Heapify
o	Input an array: [10, 20, 15, 30, 40].
o	Apply "heapify down" starting from the last non-leaf node.
o	Resulting Heap: [40, 30, 15, 10, 20].
3.	Heap Sort
o	Repeatedly remove the root and heapify the remaining array.
o	Example: 
	Heap: [40, 30, 15, 10, 20].
	Sorted Array: [10, 15, 20, 30, 40].
4.	Delete Root
o	Replace the root with the last element.
o	Reduce the size and "heapify down."
o	Example: 
	Heap: [40, 30, 15, 10, 20].
	After deleting root: [30, 20, 15, 10].

Sample Input and Output
Input
Enter the capacity of the heap:
10
1. Insert 20
1. Insert 30
1. Insert 40
5. Display Heap
2. Build Heap [50, 20, 30, 10, 40]
5. Display Heap
3. Perform Heap Sort
4. Delete Root
5. Display Heap
6. Exit
Output
20 inserted.
30 inserted.
40 inserted.
Current Heap:
40 20 30

Heap built using heapify.
Current Heap:
50 40 30 10 20

Performing Heap Sort...
Sorted Array:
10 20 30 40 50
Deleted root value: 50
Current Heap:
40 20 30 10

Explanation of Code
1.	Heapify Up/Down:
o	Restores heap properties after insertion or deletion.
o	Heapify up: Bubble the node upward if it's greater than its parent.
o	Heapify down: Bubble the node downward if it's smaller than a child.
2.	Build Heap:
o	Applies heapify from bottom-up for all non-leaf nodes.
3.	Heap Sort:
o	Swap the root with the last element, shrink the heap, and apply heapify.
4.	Delete Root:
o	Replace root with the last element, shrink the heap, and apply heapify.

*/
