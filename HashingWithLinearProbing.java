import java.util.Scanner;
class HashTable {
    private int[] table;
    private boolean[] deleted;
    private int tableSize;
    // Constructor to initialize the hash table
    public HashTable(int size) {
        tableSize = size;
        table = new int[tableSize];
        deleted = new boolean[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = Integer.MIN_VALUE; // Use Integer.MIN_VALUE to indicate empty slots
        }
    }
    // Hash function
    private int hashFunction(int key) {
        return key % tableSize;
    }
    // Insert a key into the hash table
    public void insert(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != Integer.MIN_VALUE && table[index] != Integer.MIN_VALUE && table[index] != key) {
            index = (index + 1) % tableSize;
            if (index == originalIndex) {
                System.out.println("Hash table is full! Cannot insert key: " + key);
                return;
            }
        }
        table[index] = key;
        deleted[index] = false;
        System.out.println("Inserted key " + key + " at index " + index);
    }
    // Search for a key in the hash table
    public boolean search(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != Integer.MIN_VALUE) {
            if (table[index] == key && !deleted[index]) {
                return true;
            }
            index = (index + 1) % tableSize;
            if (index == originalIndex) {
                break;
            }
        }
        return false;
    }
    // Delete a key from the hash table
    public void delete(int key) {
        int index = hashFunction(key);
        int originalIndex = index;

        while (table[index] != Integer.MIN_VALUE) {
            if (table[index] == key && !deleted[index]) {
                deleted[index] = true;
                System.out.println("Deleted key " + key + " from index " + index);
                return;
            }
            index = (index + 1) % tableSize;
            if (index == originalIndex) {
                break;
            }
        }
        System.out.println("Key " + key + " not found!");
    }
    // Display the hash table
    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != Integer.MIN_VALUE && !deleted[i]) {
                System.out.println("Index " + i + ": " + table[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }
}

public class HashingWithLinearProbing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();
        HashTable hashTable = new HashTable(size);
        while (true) {
            System.out.println("\nHash Table Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter the key to insert: ");
                    int keyToInsert = scanner.nextInt();
                    hashTable.insert(keyToInsert);
                    break;
                case 2: // Search
                    System.out.print("Enter the key to search: ");
                    int keyToSearch = scanner.nextInt();
                    if (hashTable.search(keyToSearch)) {
                        System.out.println("Key " + keyToSearch + " is present in the hash table.");
                    } else {
                        System.out.println("Key " + keyToSearch + " is not found in the hash table.");
                    }
                    break;
                case 3: // Delete
                    System.out.print("Enter the key to delete: ");
                    int keyToDelete = scanner.nextInt();
                    hashTable.delete(keyToDelete);
                    break;
                case 4: // Display
                    hashTable.display();
                    break;
                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}


/*
Hashing is a technique used to map keys to positions in a hash table using a hash function. When two keys map to the same position (collision), Linear Probing is used to resolve the collision by searching the next available slot in a sequential manner.

How Linear Probing Works
1.	Hash Function: Determines the index for a key using index=key mod  table size
2.	Collision Handling: If the calculated index is occupied: 
o	Check the next index (index + 1) mod table size
o	Repeat until an empty slot is found.
3.	Insertion: Place the key in the empty slot.
4.	Search: Start from the hash index and probe sequentially until the key is found or an empty slot is encountered.
5.	Deletion: Mark the slot as deleted (special marker).


Step-by-Step Execution
1.	Initialize the Hash Table
o	Input: size = 10
o	The hash table has 10 slots, all initialized to empty (Integer.MIN_VALUE).
2.	Insert Keys
o	Input: keys = {15, 25, 35, 45, 55}
o	Hash function: index=key mod  size. 
	15 → index 5
	25 → index 5 (collision) → linear probe → index 6
	35 → index 5 (collision) → linear probe → index 7
	45 → index 5 (collision) → linear probe → index 8
	55 → index 5 (collision) → linear probe → index 9
3.	Search
o	Input: key = 35
o	Start at index 35mod  10=5, probe until key is found at index 7.
4.	Delete
o	Input: key = 25
o	Mark index 6 as deleted.
5.	Display Hash Table
o	Output: 
o	Index 0: Empty
o	Index 1: Empty
o	Index 2: Empty
o	Index 3: Empty
o	Index 4: Empty
o	Index 5: 15
o	Index 6: Empty
o	Index 7: 35
o	Index 8: 45
o	Index 9: 55

How the Code Works
1.	Insert Operation
o	Compute the hash index for the key.
o	If the slot is empty, insert the key.
o	If there’s a collision, probe sequentially until an empty slot is found.
2.	Search Operation
o	Compute the hash index for the key.
o	Check the slot and probe until the key is found or an empty slot is reached.
3.	Delete Operation
o	Find the key in the hash table and mark its slot as deleted.
4.	Display
o	Traverse the hash table and print each slot.
Advantages of Linear Probing
•	Simple to implement.
•	Requires no extra memory for pointers.
Disadvantages
•	Clustering: Long chains of occupied slots form, increasing search time.
•	Full Table: Performance degrades as the table becomes full.

*/