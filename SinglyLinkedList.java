import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;

    // Insert at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Inserted: " + data);
    }

    // Delete the first occurrence of a value
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }
        if (head.data == data) {
            head = head.next;
            System.out.println("Deleted: " + data);
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Element not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Deleted: " + data);
        }
    }

    // Traverse and display
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Singly Linked List: ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter data to insert: ");
                        int data = scanner.nextInt();
                        sll.insert(data);
                        break;
                    case 2:
                        System.out.print("Enter data to delete: ");
                        int deleteData = scanner.nextInt();
                        sll.delete(deleteData);
                        break;
                    case 3:
                        sll.display();
                        break;
                    case 4:
                        scanner.close();
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
}

/*
Implementation of all types of linked list

Linked List Overview
A Linked List is a dynamic data structure consisting of nodes. Each node contains:
1.	Data: The actual value.
2.	Pointer/Reference: The address of the next (and sometimes the previous) node.

Types of Linked Lists
1.	Singly Linked List (SLL):
o	Each node points to the next node.
o	Traversal is one-directional.
2.	Doubly Linked List (DLL):
o	Each node points to both the next and the previous nodes.
o	Traversal can be bidirectional.
3.	Circular Linked List (CLL):
o	The last node points to the first node, forming a circle.
o	Can be implemented as singly or doubly linked.

Operations on Linked List
1.	Insertion:
o	At the beginning, end, or specific position.
2.	Deletion:
o	From the beginning, end, or specific position.
3.	Traversal:
o	Visit each node to display its value.
4.	Search:
o	Find a specific value in the list.

Applications of Linked Lists
1.	Dynamic Memory Management: Efficient for data with frequent insertions/deletions.
2.	Implementation of Data Structures: Stacks, queues, and graphs.
3.	Navigation Systems: Music playlists, undo-redo functionalities.

Complexity Analysis
Operation	Singly Linked List	Doubly Linked List	Circular Linked List
Traversal	O(n)	O(n)	O(n)
Insertion (Head)	O(1)	O(1)	O(1)
Insertion (End)	O(n)	O(1) (if tail)	O(1) (if tail)
Deletion (Head)	O(1)	O(1)	O(1)
Deletion (End)	O(n)	O(1) (if tail)	O(1) (if tail)

*/