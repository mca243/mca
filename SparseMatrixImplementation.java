import java.util.Scanner;

class SparseNode {
    int row, col, value;
    SparseNode next;

    SparseNode(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.next = null;
    }
}

class SparseMatrix {
    SparseNode head;

    public void addElement(int row, int col, int value) {
        SparseNode newNode = new SparseNode(row, col, value);
        if (head == null) {
            head = newNode;
        } else {
            SparseNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void displayAsList() {
        if (head == null) {
            System.out.println("The sparse matrix is empty.");
            return;
        }
        System.out.println("Row\tCol\tValue");
        SparseNode current = head;
        while (current != null) {
            System.out.println(current.row + "\t" + current.col + "\t" + current.value);
            current = current.next;
        }
    }

    public void displayAsMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        SparseNode current = head;
        while (current != null) {
            matrix[current.row][current.col] = current.value;
            current = current.next;
        }
        System.out.println("Full Matrix Representation:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class SparseMatrixImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the number of rows and columns of the matrix:");
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                System.out.println("Matrix dimensions must be positive.");
                return;
            }

            SparseMatrix sparseMatrix = new SparseMatrix();

            System.out.println("Enter the number of non-zero elements:");
            int nonZeroElements = scanner.nextInt();

            if (nonZeroElements < 0) {
                System.out.println("Number of non-zero elements cannot be negative.");
                return;
            }

            System.out.println("Enter the row, column, and value for each non-zero element:");
            for (int i = 0; i < nonZeroElements; i++) {
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                int value = scanner.nextInt();

                if (row >= rows || col >= cols || row < 0 || col < 0) {
                    System.out.println("Invalid row or column. Please enter values within the matrix bounds.");
                    i--;
                    continue;
                }
                sparseMatrix.addElement(row, col, value);
            }

            System.out.println("\nSparse Matrix Representation (as list):");
            sparseMatrix.displayAsList();

            System.out.println("\nSparse Matrix Representation (as matrix):");
            sparseMatrix.displayAsMatrix(rows, cols);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            scanner.close();
        }
    }
}

/*
Implementing a sparse matrix using a linked list in Java involves 
representing non-zero elements as nodes in a linked list. Each node stores the row index,
column index, and value of the non-zero element. 
Step-by-Step Implementation
1.	Understand Sparse Matrix Representation A sparse matrix contains mostly zero values.
Instead of storing the entire matrix, we store only the non-zero values along 
with their row and column indices.
2.	Create a Node Class Each node represents a non-zero element and includes:
o	The row index.
o	The column index.
o	The value of the element.
o	A reference to the next node.
3.	Create a SparseMatrix Class This class manages the linked list and provides methods to:
o	Add a non-zero element to the sparse matrix.
o	Display the matrix in a readable format.
o	Perform operations like addition or transpose (optional).
4.	Take User Input Allow the user to specify matrix dimensions and enter non-zero elements.
5.	Display the Sparse Matrix Show the non-zero elements in a readable format 
and optionally convert it back to the full matrix format for visualization.

Code
Step-by-Step Execution
1.	User Input Example Input:
2.	Enter the number of rows and columns of the matrix:
4 5
3.	Enter the number of non-zero elements:
4
4.	Enter the row, column, and value for each non-zero element:
0 1 5
1 2 8
3 0 6
3 4 7
5.	Adding Elements to the Linked List After input, the linked list will look like:
o	Node(0, 1, 5) -> Node(1, 2, 8) -> Node(3, 0, 6) -> Node(3, 4, 7)
6.	Display as List
7.	Row    Col    Value
 0      1      5
1      2      8
 3      0      6
  3      4      7
8.	Convert and Display as Full Matrix Construct the full matrix from the linked list:
9.	Full Matrix Representation:
0 5 0 0 0
0 0 8 0 0
0 0 0 0 0
6 0 0 0 7
How the Code Works
1.	Node Creation
o	The Node class holds information about each non-zero element (row, column, value)
and links to the next node.
2.	Adding Elements
o	The addElement method inserts a new non-zero element at the end of the linked list.
3.	Display as List
o	The displayAsList method iterates through the linked list and prints each node’s data.
4.	Convert to Full Matrix
o	The displayAsMatrix method initializes a 2D array with zeros.
o	It populates the array by traversing the linked list and placing non-zero 
values at their respective positions.
5.	Efficiency
o	Only non-zero elements are stored, saving memory compared to using a full matrix.

Output
For the above input, the output will be:
Sparse Matrix Representation (as list):
Row    Col    Value
0          1      5
1          2      8
3         0      6
3         4      7

Sparse Matrix Representation (as matrix):
0 5 0 0 0
0 0 8 0 0
0 0 0 0 0
6 0 0 0 7

*/