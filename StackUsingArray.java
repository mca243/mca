import java.util.Scanner;

// Stack class using an array
class Stack {
    private int maxSize;
    private int top;
    private int[] stack;

    // Constructor to initialize the stack with a maximum size
    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1; // Stack is empty when top is -1
    }

    // Push operation
    public void push(int data) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow. Cannot push " + data);
        } else {
            stack[++top] = data;
            System.out.println(data + " pushed to stack");
        }
    }

    // Pop operation
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow. Nothing to pop.");
        } else {
            int popped = stack[top--];
            System.out.println(popped + " popped from stack");
        }
    }

    // Peek operation
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get the size of the stack
    public void getSize() {
        System.out.println("Size of stack: " + (top + 1));
    }

    // Display all elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the stack size from the user
        System.out.print("Enter the maximum size of the stack: ");
        int size = scanner.nextInt();
        Stack stack = new Stack(size);

        int choice;

        // Menu-driven program
        do {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Stack is Empty");
            System.out.println("5. Get Stack Size");
            System.out.println("6. Display Stack");
            System.out.println("7. Exit");
            System.out.print("Enter your choice (1-7): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Push operation
                    System.out.print("Enter element to push: ");
                    int data = scanner.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    // Pop operation
                    stack.pop();
                    break;
                case 3:
                    // Peek operation
                    stack.peek();
                    break;
                case 4:
                    // Check if stack is empty
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack is not empty.");
                    }
                    break;
                case 5:
                    // Get size of stack
                    stack.getSize();
                    break;
                case 6:
                    // Display stack
                    stack.display();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}

/*
The program provides a menu-driven interface that allows the user to perform operations such as 
push, pop, peek, check if the stack is empty, and get the stack size.
How the Code Works:
1. Stack Class:
   - The stack is represented using an array (`stack[]`).
   - The top variable keeps track of the index of the top element. 
Initially, it is set to -1 to indicate that the stack is empty.
   - The `push()`, `pop()`, `peek()`, `isEmpty()`, `getSize()`, and `display()` 
methods handle various operations on the stack.
2. Menu-Driven Program:
   - The user is prompted to choose an operation from a menu.
   - The user can input elements to push onto the stack, pop elements, 
check the top element, check if the stack is empty, and display all elements in the stack.
Example Output:
Input:
Enter the maximum size of the stack: 5
Menu Options:
Stack Operations:
1. Push
2. Pop
3. Peek
4. Check if Stack is Empty
5. Get Stack Size
6. Display Stack
7. Exit
Enter your choice: 1
Enter element to push: 10
10 pushed to stack

Stack Operations:
1. Push
2. Pop
3. Peek
4. Check if Stack is Empty
5. Get Stack Size
6. Display Stack
7. Exit
Enter your choice: 1
Enter element to push: 20
20 pushed to stack

Stack Operations:
1. Push
2. Pop
3. Peek
4. Check if Stack is Empty
5. Get Stack Size
6. Display Stack
7. Exit
Enter your choice: 3
Top element is: 20

Stack Operations:
1. Push
2. Pop
3. Peek
4. Check if Stack is Empty
5. Get Stack Size
6. Display Stack
7. Exit
Enter your choice: 2
20 popped from stack

Stack Operations:
1. Push
2. Pop
3. Peek
4. Check if Stack is Empty
5. Get Stack Size
6. Display Stack
7. Exit
Enter your choice: 6
Stack elements: 10
Key Points:
- Push and Pop operations are \(O(1)\) since they only involve adding or
removing the element at the top.
- Peek, isEmpty, getSize, and display operations are 
also \(O(1)\), \(O(1)\), \(O(1)\), and \(O(n)\) respectively, 
where \(n\) is the number of elements in the stack.
- The stack is implemented using a fixed-size array. 
If the array is full, a Stack Overflow error is thrown when pushing an element. 
If the stack is empty, a Stack Underflow error is thrown when popping an element.

*/
