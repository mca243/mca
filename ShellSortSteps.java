import java.util.Scanner;

public class ShellSortSteps {
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

        // Perform Shell Sort with steps
        shellSortWithSteps(arr);

        // Display the sorted array
        System.out.println("Sorted array:");
        printArray(arr);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }

    // Shell Sort with step-by-step output
    public static void shellSortWithSteps(int[] arr) {
        int n = arr.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("\nGap = " + gap + ":");

            // Perform a gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;

                // Shift earlier gap-sorted elements up until the correct location for temp is found
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // Put temp (the original arr[i]) in its correct location
                arr[j] = temp;

                // Print the array after each insertion
                printArray(arr);
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
Shell Sort Algorithm:
Shell Sort is an advanced version of the Insertion Sort. 
It improves the efficiency of insertion sort by allowing 
the comparison and exchange of elements that are far apart. 
This is done using a sequence of gaps between compared 
elements that gradually decreases to 1, when it performs a final Insertion Sort pass.

Algorithm Steps:
1. Choose an initial gap size: 
The gap size is typically chosen as half of the array length, 
and it is reduced progressively (e.g., divided by 2).
2. Perform gapped insertion sort: 
For each gap size, perform an insertion sort where instead of comparing adjacent elements, 
elements that are gap positions apart are compared.
3. Reduce the gap: 
After each pass, the gap size is reduced (usually by dividing by 2), 
and the process is repeated until the gap becomes 1, 
at which point a final insertion sort is performed.
Time Complexity:
- Best Case: \(O(n \log n)\)  
  - If the gap sequence is chosen well (e.g., using the Hibbard or Sedgewick sequences), 
the time complexity can approach \(O(n \log n)\).
  
- Average Case: \(O(n^{1.3})\) to \(O(n^2)\)  
  - Depends on the choice of gap sequence.
The standard gap sequence often results in \(O(n^{1.3})\) in practice.

- Worst Case: \(O(n^2)\)  
  - Occurs with certain gap sequences (like the original sequence used by Shell), 
leading to \(O(n^2)\) behavior.

Space Complexity:  
- Space: \(O(1)\)  
  - Shell Sort is an in-place sorting algorithm, meaning it requires no extra space apart 
from the input array.

Java Program: Shell Sort with Step-by-Step Output
How It Works:
1. User Input: The program takes the array size and its elements as input from the user.
2. Shell Sort Process: 
   - The program first selects a gap (typically \(n/2\)) and then performs a gapped insertion sort.
   - After each pass, the gap is reduced (usually halved).
   - For each gap, the program shows the array after sorting with that gap.
3. Final Sorting: When the gap reaches 1, a final pass is performed, and the array is fully sorted.
Example Input and Output:
Input:
Enter the number of elements: 5
Enter 5 elements:
64 34 25 12 22
Output:
Original array:
64  34  25  12  22
Gap = 2:
25 34 64 12 22
25 34 64 12 22
25 34 22 12 64
Gap = 1:
22 25 34 12 64
22 25 12 34 64
22 12 25 34 64
12 22 25 34 64
Sorted array:
12 22 25 34 64
Explanation of Output:
1. Gap = 2: Elements are compared with a gap of 2. 
After the first pass, some elements are shifted, and the array becomes closer to being sorted.
2. Gap = 1: After the gap is reduced to 1, it performs a final insertion sort, 
where elements are compared adjacent to each other, and the array is fully sorted.
Key Features of Shell Sort:
- Improved Performance: Shell Sort significantly reduces the number of comparisons 
compared to the regular Insertion Sort by allowing comparisons between elements far apart.
- Gap Sequence: The choice of gap sequence is critical for its efficiency. 
The program uses a simple gap halving strategy.

*/
