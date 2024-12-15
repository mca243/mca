import java.util.Scanner;

public class SelectionSortSteps {
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

        // Perform Selection Sort with steps
        selectionSortWithSteps(arr);

        // Display the sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    // Selection sort with step-by-step output
    public static void selectionSortWithSteps(int[] arr) {
        int n = arr.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Index of the smallest element
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the smallest element with the first element of the unsorted portion
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            // Print the array after each pass
            System.out.println("\nAfter pass " + (i + 1) + ":");
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
Selection Sort Algorithm:
Selection Sort is a simple sorting algorithm. It works by dividing the array 
into a sorted and an unsorted region. The smallest (or largest, depending on sorting order)
element from the unsorted region is selected and swapped with the first 
element of the unsorted region, expanding the sorted region by one.

Algorithm Steps:
1. Start with the first element of the array.
2. Find the smallest element in the unsorted portion of the array.
3. Swap the smallest element with the first element of the unsorted portion.
4. Move the boundary of the sorted region one element to the right.
5. Repeat until the entire array is sorted.

Time Complexity:
1. Best Case: O(n^2)
   - Even if the array is already sorted, the algorithm performs all comparisons.

2. Average Case: O(n^2)  
   - The algorithm always compares all elements, regardless of initial order.

3. Worst Case:O(n^2)
   - Same as the average case because the algorithm's structure doesn't change with input.

Space Complexity:
Space:O(1) (in-place sorting algorithm).

How It Works:
1. The program takes the size and elements of the array as input from the user.
2. The `selectionSortWithSteps` method:
   - Finds the smallest element in the unsorted part of the array.
   - Swaps it with the first element of the unsorted portion.
   - Prints the state of the array after each pass.
3. The process repeats until the array is sorted.

 Example Input and Output:
Input:

Enter the number of elements: 5
Enter 5 elements:
64 34 25 12 22

Output:
Original array:
64 34 25 12 22

After pass 1:
12 34 25 64 22

After pass 2:
12 22 25 64 34

After pass 3:
12 22 25 64 34

After pass 4:
12 22 25 34 64

Sorted array:
12 22 25 34 64

*/
