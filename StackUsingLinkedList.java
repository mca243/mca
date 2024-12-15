import java.util.Scanner;

// StackNode class to represent each element in the linked list
class StackNode {
    int data;
    StackNode next;

    // Constructor
    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

// LinkedStack class that implements stack operations using a linked list
class LinkedStack {
    private StackNode top;
    private int size;

    // Constructor
    public LinkedStack() {
        this.top = null;
        this.size = 0;
    }

    // Push operation
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(data + " pushed to stack");
    }

    // Pop operation
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to pop.");
            return;
        }
        int popped = top.data;
        top = top.next;
        size--;
        System.out.println(popped + " popped from stack");
    }

    // Peek operation
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return;
        }
        System.out.println("Top element is: " + top.data);
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get size of stack
    public void getSize() {
        System.out.println("Size of stack: " + size);
    }

    // Display all elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        StackNode temp = top;
        System.out.print("Stack elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedStack stack = new LinkedStack();
        int choice;

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
Implementing Stack Using Linked List in Java
Here's a Java program that implements a stack using a linked list. 
The program is menu-driven and allows the user to perform operations such as 
push, pop, peek, check if the stack is empty, and get the stack size.

How the Code Works:
1. Node Class: This class represents a node in the linked list, containing the 
data and a reference to the next node.
2. Stack Class: This class implements stack operations using a linked list. The stack has:
   - A reference to the top node (`top`).
   - A counter for the stack size (`size`).
   - Methods for push, pop, peek, isEmpty, getSize, and display.
3. Menu-Driven Main Program: The user can interact with the stack using a menu. 
Based on the user's input, it performs the corresponding operation on the stack.

Operations:
- Push: Adds an element to the top of the stack.
- Pop: Removes the top element of the stack.
- Peek: Displays the top element without removing it.
- isEmpty: Checks if the stack is empty.
- Size: Returns the current size of the stack.
- Display: Shows all the elements in the stack from top to bottom.

---

 Example Output:


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
1. Push and Pop operations are \(O(1)\) as we only interact with the top node.
2. Peek, isEmpty, getSize operations are also \(O(1)\).
3. Stack Implementation using a linked list ensures that no space is wasted, 
unlike array-based implementations, where resizing might be required.

*/