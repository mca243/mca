import java.util.Scanner;

public class BubbleSortSteps {
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

        // Perform Bubble Sort with steps
        bubbleSortWithSteps(arr);

        // Display the sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    // Bubble sort with step-by-step output
    public static void bubbleSortWithSteps(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("\nPass " + (i + 1) + ":");

            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }

                // Print the array after each comparison
                printArray(arr);
            }

            // If no swaps occurred, the array is sorted
            if (!swapped) {
                System.out.println("No swaps needed. Array is sorted.");
                break;
            }
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
Bubble Sort Algorithm:
Bubble Sort is a simple comparison-based sorting algorithm. It repeatedly compares adjacent elements in the list and swaps them if they are in the wrong order. This process is repeated until the list is sorted.
Algorithm Steps:
1.	Start at the beginning of the array.
2.	Compare the current element with the next element.
3.	If the current element is greater than the next element, swap them.
4.	Repeat this process for every pair of adjacent elements in the array.
5.	Reduce the range of comparison by one in each iteration as the largest elements "bubble up" to their correct position.
6.	Stop when no swaps are needed, indicating the array is sorted.

Time Complexity:
1.	Best Case: O(n)
o	Occurs when the array is already sorted, requiring no swaps.
o	Optimized implementations check for this condition by tracking swaps.
2.	Average Case: O(n^2)
o	Most of the time, elements will require partial swaps for sorting.
3.	Worst Case: O(n^2)
o	Happens when the array is in reverse order, requiring the maximum number of swaps.
Space Complexity:
•	Space: O(1)  (in-place sorting algorithm; no additional memory is required).
Example Input and Output:
Input:
Enter the number of elements: 5
Enter 5 elements:
64 34 25 12 22
Output:
Original array:
64 34 25 12 22

Pass 1:
34 64 25 12 22
34 25 64 12 22
34 25 12 64 22
34 25 12 22 64

Pass 2:
25 34 12 22 64
25 12 34 22 64
25 12 22 34 64

Pass 3:
12 25 22 34 64
12 22 25 34 64

Pass 4:
12 22 25 34 64
Sorted array:
12 22 25 34 64

*/