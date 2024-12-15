import java.util.Arrays;

public class BinarySearch {
    // Function to perform Binary Search
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate mid index

            if (arr[mid] == target) {
                return mid; // Return the index if target is found
            } else if (arr[mid] < target) {
                low = mid + 1; // Target is in the right subarray
            } else {
                high = mid - 1; // Target is in the left subarray
            }
        }
        return -1; // Return -1 if target is not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50}; // Sorted array for binary search
        int target = 30; // Element to be searched

        int result = binarySearch(arr, target); // Perform the search

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found.");
        }
    }
}


/*
Linear Search and Binary Search
Linear Search and Binary Search are two fundamental searching algorithms. Linear Search works on any collection, while Binary Search requires the collection to be sorted.

Linear Search
Algorithm
1.	Start from the first element of the array.
2.	Compare the current element with the target value.
3.	If they match, return the index of the current element.
4.	If no match is found after traversing the entire array, return -1 (element not found).

Step-by-Step Execution
1.	Input Array: [10, 20, 30, 40, 50], Target: 30.
2.	Start at index 0: 
o	Compare arr[0] (10) with 30. Not a match.
3.	Move to index 1: 
o	Compare arr[1] (20) with 30. Not a match.
4.	Move to index 2: 
o	Compare arr[2] (30) with 30. Match found at index 2.
Output: Element found at index: 2.


Applications of Linear Search
1.	Unsorted Arrays: Works on any unsorted dataset.
2.	Small Data: Efficient for small datasets.
3.	Flexible: Useful when the dataset does not support sorting or indexing.

Binary SearchAlgorithm
1.	Sort the array (if not already sorted).
2.	Initialize two pointers: low = 0 and high = arr.length - 1.
3.	Calculate the middle index: mid = low + (high - low) / 2.
4.	Compare the target value with arr[mid]: 
o	If the target is equal to arr[mid], return mid.
o	If the target is smaller than arr[mid], search the left subarray.
o	If the target is larger than arr[mid], search the right subarray.
5.	Repeat until the target is found or low > high.
Step-by-Step Execution
1.	Input Array: [10, 20, 30, 40, 50] (Sorted), Target: 30.
2.	First Iteration: 
o	low = 0, high = 4, mid = 2.
o	Compare arr[mid] (30) with 30. Match found at index 2.
Output: Element found at index: 2.

Applications of Binary Search
1.	Large Sorted Arrays: Efficient for datasets where nn is large.
2.	Databases: Used for searching in sorted database tables.
3.	Finding Bounds: Used in algorithms like finding the smallest/largest element satisfying a condition.
4.	Strings: Works on sorted strings for dictionary-like operations.

Comparison of Linear and Binary Search
Feature	Linear Search	Binary Search
Data Requirement	Works on unsorted data	Requires sorted data
Best Case	O(1)	O(1)
Worst Case	O(n)	O(log n)
Space Complexity	O(1)	O(1)
Applications	Small, unsorted data	Large, sorted data


*/