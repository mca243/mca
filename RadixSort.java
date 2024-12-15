import java.util.Arrays;

public class RadixSort {
    // Main function to implement Radix Sort
    public static void radixSort(int[] arr) {
        // Find the maximum number to determine the number of digits
        int max = Arrays.stream(arr).max().getAsInt();

        // Apply counting sort for each digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Counting sort used as a subroutine
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array to store sorted numbers
        int[] count = new int[10]; // Count array for digits 0-9

        // Count the occurrences of each digit at the current position
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Update count[i] so it will contain the actual position of this digit in output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array by placing numbers in the sorted order of the current digit
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the sorted numbers back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Driver function to test the algorithm
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original Array: " + Arrays.toString(arr));

        radixSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

/*
Radix Sort in Detail
Radix Sort is a non-comparative sorting algorithm that works by distributing 
elements into buckets according to their individual digits. It processes the digits from 
the least significant to the most significant (LSD) or vice versa (MSD). Radix Sort is 
particularly useful for sorting integers or strings where the keys can be broken down into 
digits or characters.

Algorithm
1.	Find the maximum number to know the number of digits.
2.	Use counting sort (a stable sorting algorithm) for each digit. 
o	Sort numbers by each digit, starting with the least significant digit.
3.	Repeat the process for every digit until all the digits are processed.

Steps of Radix Sort
Let’s say we have an array: [170, 45, 75, 90, 802, 24, 2, 66].
1.	Find the maximum number:
Maximum = 802 → Number of digits = 3.
2.	Sort by the least significant digit (unit place):
After sorting: [802, 2, 24, 45, 66, 170, 75, 90].
3.	Sort by the next digit (tens place):
After sorting: [802, 2, 24, 45, 66, 75, 90, 170].
4.	Sort by the most significant digit (hundreds place):
After sorting: [2, 24, 45, 66, 75, 90, 170, 802].



Step-by-Step Execution
1.	Input Array: [170, 45, 75, 90, 802, 24, 2, 66]
2.	Sorting by Unit Place (exp = 1):
Count: [2, 1, 0, 0, 1, 1, 1, 0, 1, 1]
Sorted: [802, 2, 24, 45, 66, 170, 75, 90]
3.	Sorting by Tens Place (exp = 10):
Count: [2, 1, 0, 0, 2, 1, 0, 1, 0, 1]
Sorted: [802, 2, 24, 45, 66, 75, 90, 170]
4.	Sorting by Hundreds Place (exp = 100):
Count: [4, 2, 2, 0, 0, 0, 0, 0, 0, 0]
Sorted: [2, 24, 45, 66, 75, 90, 170, 802]

Applications of Radix Sort
1.	Sorting Integers or Strings: Especially useful for large datasets 
where keys are uniformly distributed.
2.	Telephone Directories: Efficient for sorting numbers and names based on multi-key fields.
3.	Digital Data: Used in applications involving sorting IP addresses, postal codes, or dates.
4.	Preprocessing for Histogram Equalization: Helps in graphics or image processing.
5.	Big Data: Used in parallel processing environments due to its non-comparative nature.

Advantages and Limitations
Advantages:
1.	Linear Time Complexity: O(nk)O(nk) where nn is the number of elements, 
and kk is the number of digits.
2.	Stable Sort: Preserves the order of equal elements.
3.	Non-Comparative: Does not use comparison operators, making it fast for integers.
Limitations:
1.	Not In-Place: Requires extra space for counting sort.
2.	Depends on Data Type: Works efficiently only for data that can be digitized 
(like integers or fixed-length strings).
3.	Large Range Handling: Inefficient for datasets with very large keys or floating-point numbers.

*/