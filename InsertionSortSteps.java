import java.util.Scanner;

public class InsertionSortSteps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Display the original array
        System.out.println("Original array:");
        printArray(arr);

        // Perform Insertion Sort with steps
        insertionSortWithSteps(arr);

        // Display the sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    // Insertion sort with step-by-step output
    public static void insertionSortWithSteps(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element to be inserted
            int j = i - 1;

            // Move elements of the sorted portion that are greater than the key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the current element at the correct position
            arr[j + 1] = key;

            // Print the array after each insertion
            System.out.println("\nAfter inserting element " + key + ":");
            printArray(arr);
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

/*
Insertion Sort Algorithm:
Insertion Sort is a simple and efficient algorithm for small datasets. It works by building a sorted portion of the array one element at a time. Each new element is compared with the elements in the sorted portion and inserted in its correct position.
Algorithm Steps:
1. Start with the second element (index 1), assuming the first element is already sorted.
2. Compare the current element with the elements in the sorted portion.
3. Shift elements of the sorted portion that are larger than the current element to the right.
4. Insert the current element in its correct position within the sorted portion.
5. Repeat for all elements in the array.

Time Complexity:
1. Best Case:O(n) 
   - Happens when the array is already sorted, requiring only one comparison per element.
2. Average Case:O(n^2) 
   - Elements are partially out of order, requiring multiple comparisons and shifts.
3. Worst Case:O(n^2)
   - Occurs when the array is sorted in reverse order, requiring maximum comparisons and shifts.

Space Complexity: 
- Space: O(1) (in-place sorting algorithm).
Java Program: Insertion Sort with Step-by-Step Output

How It Works:
1. The program takes input for the array size and elements from the user.
2. The `insertionSortWithSteps` method:
   - Iterates through the array starting from the second element.
   - Finds the correct position for the current element by shifting larger elements in the sorted portion to the right.
   - Inserts the current element and prints the array state after each insertion.
3. The sorted array is displayed at the end.
Example Input and Output:
Input:

Enter the number of elements: 5
Enter 5 elements:
64 34 25 12 22

Output:
Original array:
64 34 25 12 22
After inserting element 34:
34 64 25 12 22
After inserting element 25:
25 34 64 12 22
After inserting element 12:
12 25 34 64 22
After inserting element 22:
12 22 25 34 64

Sorted array:
12 22 25 34 64

*/