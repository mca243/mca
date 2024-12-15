import java.util.Scanner;

class BSTNode {
    int data;
    BSTNode left, right;

    BSTNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {
    BSTNode root;

    // a) Insert a node in BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private BSTNode insertRec(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // b) Delete a node from BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private BSTNode deleteRec(BSTNode root, int value) {
        if (root == null)
            return root;

        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(BSTNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // c) Find height of BST
    public int findHeight() {
        return heightRec(root);
    }

    private int heightRec(BSTNode root) {
        if (root == null)
            return -1;
        return Math.max(heightRec(root.left), heightRec(root.right)) + 1;
    }

    // d) Perform Inorder Traversal
    public void inorder() {
        System.out.println("Inorder Traversal:");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // e) Perform Preorder Traversal
    public void preorder() {
        System.out.println("Preorder Traversal:");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(BSTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // f) Perform Postorder Traversal
    public void postorder() {
        System.out.println("Postorder Traversal:");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(BSTNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // g) Find maximum value in BST
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return maxValue(root);
    }

    private int maxValue(BSTNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}

public class BSTOperations {
    public static void main(String[] args) {
        BST bst = new BST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Find Height");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Find Maximum");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    bst.insert(value);
                    System.out.println(value + " inserted.");
                    break;
                case 2:
                    System.out.print("Enter value to delete: ");
                    value = scanner.nextInt();
                    bst.delete(value);
                    System.out.println(value + " deleted (if present).");
                    break;
                case 3:
                    System.out.println("Height of the tree: " + bst.findHeight());
                    break;
                case 4:
                    bst.inorder();
                    break;
                case 5:
                    bst.preorder();
                    break;
                case 6:
                    bst.postorder();
                    break;
                case 7:
                    try {
                        System.out.println("Maximum value in the tree: " + bst.findMax());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
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
A Binary Search Tree (BST) is a binary tree where each node satisfies the following properties:
1.	Key Property:
o	The value of the left child of a node is less than the value of the node.
o	The value of the right child of a node is greater than the value of the node.
o	This rule applies recursively to all nodes in the tree.
2.	Binary Tree Structure:
o	Each node can have at most two children: left and right.
3.	Inorder Traversal Property:
o	An inorder traversal of a BST produces a sorted sequence of elements in ascending order.

Applications of Binary Search Tree
1.	Searching:
o	Efficiently find elements in O(log⁡n)O(\log n) time in a balanced BST.
o	Example: Lookups in a symbol table, dictionary, or database index.
2.	Sorting:
o	Inorder traversal produces sorted data.
3.	Dynamic Data Structure:
o	Insertions and deletions are performed efficiently.
4.	Key Applications:
o	Database indexing: BST can store and retrieve data efficiently.
o	Priority queues: BSTs like AVL trees or Red-Black trees support efficient insertion and deletion.
o	Computer Networks: Used for routing tables in network routers.
o	Huffman Encoding: BSTs form the basis for encoding algorithms.

Operations in Binary Search Tree
1. Insertion
•	A new node is inserted such that the BST property is preserved.
•	Steps: 
1.	Start from the root.
2.	If the new value is smaller than the current node, move to the left subtree.
3.	If the new value is larger, move to the right subtree.
4.	Repeat until you reach a null position.
•	Time Complexity: O(h), where h is the height of the tree.
2. Search
•	Checks whether a given value exists in the BST.
•	Steps: 
1.	Start from the root.
2.	If the value matches the current node, return true.
3.	If the value is smaller, move to the left subtree.
4.	If the value is larger, move to the right subtree.
5.	Repeat until the value is found or the subtree is null.
•	Time Complexity: O(h).
3. Deletion
•	Deletes a node from the BST while maintaining the BST property.
•	Cases: 
1.	Node has no children: Simply remove the node.
2.	Node has one child: Replace the node with its child.
3.	Node has two children: Find the inorder successor (smallest value in the right subtree), replace the node with the successor, and delete the successor node.
•	Time Complexity: O(h).
4. Inorder Traversal
•	Visits nodes in ascending order: Left → Root → Right.
•	Produces sorted output.
•	Time Complexity: O(n).
5. Preorder Traversal
•	Visits nodes in the order: Root → Left → Right.
•	Useful for tree reconstruction.
•	Time Complexity: O(n).
6. Postorder Traversal
•	Visits nodes in the order: Left → Right → Root.
•	Useful for deleting or freeing memory in trees.
•	Time Complexity: O(n).
7. Finding the Minimum and Maximum
•	Minimum: Traverse the leftmost subtree.
•	Maximum: Traverse the rightmost subtree.
•	Time Complexity: O(h).
8. Find Height
•	The height of the BST is the longest path from the root to a leaf.
•	Steps: 
1.	Compute the height of the left and right subtrees recursively.
2.	Height = 1 + max(left height, right height).
•	Time Complexity: O(n).

Example
Input:
Insert the following values into a BST: 50, 30, 70, 20, 40, 60, 80.
BST Structure:
        50
       /  \
     30    70
    / \    / \
  20  40  60  80
Operations and Results:
1.	Search for 60: Found.
2.	Delete 30: 
     50
    /  \
  40    70
 /      / \
        20   60 80
3. Inorder Traversal: 20, 40, 50, 60, 70, 80.
4. Preorder Traversal: 50, 40, 20, 70, 60, 80.
5. Postorder Traversal: 20, 40, 60, 80, 70, 50.
6. Height: 2.
7. Maximum Value: 80.


Step-by-Step Explanation
1.	Node Class
o	Represents a node in the BST, storing data, a reference to the left child, and a reference to the right child.
2.	Insertion
o	Adds a new node while maintaining the BST property: 
	Left subtree contains values less than the node.
	Right subtree contains values greater than the node.
3.	Deletion
o	Deletes a node by considering three cases: 
	Node has no child (leaf node).
	Node has one child.
	Node has two children (replace with the smallest value in the right subtree).
4.	Finding Height
o	Recursively calculates the height of the left and right subtrees and returns the maximum.
5.	Traversals
o	Inorder: Left → Root → Right
o	Preorder: Root → Left → Right
o	Postorder: Left → Right → Root
6.	Finding Maximum
o	The maximum value in a BST is the rightmost node.

Sample Input and Output
1.	Insert Nodes
2.	Input: 50, 30, 70, 20, 40, 60, 80
3.	Tree: 
          50
        /    \
      30      70
     /  \    /  \
   20   40  60   80
4.	Inorder Traversal
5.	Output: 20 30 40 50 60 70 80
6.	Delete Node (50)
7.	Input: Delete 50
8.	Tree after deletion: 
          60
        /    \
      30      70
     /  \       \
   20   40       80
9.	Height of Tree
10.	Output: 2
11.	Find Maximum
12.	Output: 80

*/

































































