import java.util.Arrays;

public class QuickSort {
    // Function to perform Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after the pivot
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot element
        int i = low - 1; // Index of smaller element

        for (int j = low; j < high; j++) {
            // If the current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (the pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the pivot index
    }

    // Main method to test the Quick Sort
    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("Original Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}

/*
Quick Sort in Detail
Quick Sort is a divide-and-conquer sorting algorithm that selects a "pivot" element,
partitions the array into elements smaller than the pivot and elements greater than the pivot, 
and recursively sorts the subarrays.

Algorithm
1.	Choose a Pivot: Select an element as the pivot 
(commonly the last element, first element, or middle element).
2.	Partition the Array: Rearrange the array so that: 
o	All elements smaller than the pivot are on the left.
o	All elements larger than the pivot are on the right.
3.	Recursively Apply Quick Sort: Apply the above steps to the left and right subarrays.

Steps of Quick Sort
Let’s sort: [10, 80, 30, 90, 40, 50, 70].
1.	Choose Pivot: Select the last element as the pivot (70).
2.	Partition: Rearrange the array: 
o	Elements smaller than 70: [10, 30, 40, 50].
o	Pivot (70).
o	Elements larger than 70: [80, 90]. Result: [10, 30, 40, 50, 70, 80, 90].
3.	Recursively Sort Subarrays: Sort [10, 30, 40, 50] and [80, 90].


Step-by-Step Execution
Input Array: [10, 80, 30, 90, 40, 50, 70]
1.	First Partition:
o	Pivot = 70.
o	Rearrange: [10, 30, 40, 50, 70, 80, 90].
o	Pivot index = 4.
2.	Left Subarray: [10, 30, 40, 50].
o	Pivot = 50.
o	Rearrange: [10, 30, 40, 50].
o	Pivot index = 3.
3.	Right Subarray: [80, 90].
o	Pivot = 90.
o	Rearrange: [80, 90].
o	Pivot index = 6.
Final sorted array: [10, 30, 40, 50, 70, 80, 90].

Applications of Quick Sort
1.	General Purpose Sorting: Used in many programming libraries due to its efficiency.
2.	Data Processing: For sorting data in large-scale applications.
3.	Searching Algorithms: Prepares data for binary searches or merge-like operations.
4.	Database Management: Frequently used for query optimization and index sorting.
5.	Distributed Systems: Adapted for parallel and distributed sorting tasks.
Advantages and Disadvantages
Advantages:
1.	Efficient: Performs well for large datasets.
2.	In-Place: Requires minimal additional memory.
3.	Adaptable: Works well with parallelization.
Disadvantages:
1.	Worst Case: Poor pivot choices can degrade performance to O(n^2).
2.	Not Stable: Relative order of equal elements may not be preserved.

*/