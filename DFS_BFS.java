import java.util.Scanner;
public class DFS_BFS {
    private int[][] adjMatrix; // Adjacency matrix to represent the graph
    private int V; // Number of vertices

    // Constructor to initialize graph with V vertices
    public DFS_BFS(int V) {
        this.V = V;
        adjMatrix = new int[V][V]; // Initialize the adjacency matrix with all 0s
    }
    // Method to add an edge to the graph
    public void addEdge(int u, int v) {
        // For an undirected graph, set both adjMatrix[u][v] and adjMatrix[v][u] to 1
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // Since it's undirected
    }
    // Method to print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix Representation of the Graph:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    // Main method to test the implementation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input: Number of vertices and edges
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();
        DFS_BFS graph = new DFS_BFS(V); // Create a graph with V vertices
        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();
        System.out.println("Enter the edges (u v) where u and v are vertices (0 to " + (V - 1) + "):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        // Print the adjacency matrix representation of the graph
        graph.printGraph();

        sc.close();
    }
}

/*
What is BFS (Breadth-First Search)?
BFS is a graph traversal algorithm that explores all neighbours of a node before moving to the next level of nodes. It uses a queue data structure for its implementation.
Steps of BFS:
1.	Start from a source node.
2.	Visit all its immediate neighbors.
3.	Enqueue the neighbors into a queue.
4.	Dequeue a node from the queue, visit its neighbors, and repeat until all nodes are visited.
Algorithm:
1.	Initialize a queue and enqueue the starting node.
2.	Mark the starting node as visited.
3.	While the queue is not empty: 
o	Dequeue a node and process it.
o	Enqueue all unvisited neighbors of the dequeued node.
Example:
Graph:
      1
     / \
    2   3
   / \   \
  4   5   6
Adjacency List:
1 → [2, 3]
2 → [1, 4, 5]
3 → [1, 6]
4 → [2]
5 → [2]
6 → [3]
Start BFS from node 1:
•	Queue: [1]
•	Visit node 1 → Enqueue 2, 3 → Queue: [2, 3]
•	Visit node 2 → Enqueue 4, 5 → Queue: [3, 4, 5]
•	Visit node 3 → Enqueue 6 → Queue: [4, 5, 6]
•	Visit node 4 → Queue: [5, 6]
•	Visit node 5 → Queue: [6]
•	Visit node 6 → Queue: []
Output: 1 → 2 → 3 → 4 → 5 → 6

What is DFS (Depth-First Search)?
DFS is a graph traversal algorithm that explores as far as possible along each branch before backtracking. It uses a stack (or recursion) for its implementation.
Steps of DFS:
1.	Start from a source node.
2.	Visit an unvisited neighbour of the node.
3.	Mark it as visited and repeat until no unvisited neighbours remain.
4.	Backtrack to previous nodes to explore other unvisited paths.
Algorithm:
1.	Initialize a stack and push the starting node.
2.	Mark the starting node as visited.
3.	While the stack is not empty: 
o	Pop a node and process it.
o	Push all unvisited neighbours of the popped node.
Example:
Graph:
      1
     / \
    2   3
   / \   \
  4   5   6
Adjacency List:
1 → [2, 3]
2 → [1, 4, 5]
3 → [1, 6]
4 → [2]
5 → [2]
6 → [3]
Start DFS from node 1:
•	Stack: [1]
•	Visit node 1 → Push 3, 2 → Stack: [3, 2]
•	Visit node 2 → Push 5, 4 → Stack: [3, 5, 4]
•	Visit node 4 → Stack: [3, 5]
•	Visit node 5 → Stack: [3]
•	Visit node 3 → Push 6 → Stack: [6]
•	Visit node 6 → Stack: []
Output: 1 → 2 → 4 → 5 → 3 → 6

Applications of BFS
1.	Shortest Path in Unweighted Graph:
o	BFS is used to find the shortest path between nodes in an unweighted graph because it explores level-by-level.
2.	Web Crawlers:
o	BFS is used to visit all pages linked to a given web page.
3.	Social Networking Sites:
o	BFS is used to find people within a certain degree of connection.
4.	Network Broadcasting:
o	BFS is used for sending packets in computer networks.
5.	Finding Connected Components:
o	BFS can identify connected components in a graph.

Applications of DFS
1.	Pathfinding:
o	DFS is used to find paths in mazes or puzzles.
2.	Topological Sorting:
o	DFS is used to determine the order of tasks in a Directed Acyclic Graph (DAG).
3.	Cycle Detection:
o	DFS is used to detect cycles in a graph.
4.	Artificial Intelligence:
o	DFS is used in AI algorithms for decision-making (e.g., game trees).
5.	Strongly Connected Components:
o	DFS is used in algorithms like Kosaraju's or Tarjan's to find strongly connected components.

Difference Between BFS and DFS
Feature	BFS	DFS
Traversal Technique	Level-by-level (breadth-first).	Depth-wise exploration (depth-first).
Data Structure	Queue.	Stack or recursion.
Time Complexity	O(V+E), where V = vertices,   E = edges.	O(V + E).
Space Complexity	O(V), for the queue.	O(V), for the stack (recursion).
Shortest Path	Always finds the shortest path in unweighted graphs.	Does not guarantee the shortest path.
Applications	Shortest path, level-order traversal.	Pathfinding, topological sorting.
Behavior in Dense Graphs	Explores neighbors early.	Explores one path deeply before others.


Explanation of the Code
1.	Graph Representation:
o	The Graph class has an integer matrix adjMatrix[][] which stores the adjacency matrix representation of the graph. Each edge is represented by a 1 in the matrix.
2.	addEdge Method:
o	This method adds an edge between two vertices u and v. For an undirected graph, it sets adjMatrix[u][v] = 1 and adjMatrix[v][u] = 1.
3.	BFS Implementation:
o	The bfs method uses a queue to traverse the graph starting from a specified vertex. It uses a boolean array visited[] to keep track of visited vertices. The algorithm explores the neighbors level by level.
4.	DFS Implementation:
o	The dfs method uses a helper function dfsUtil to perform the DFS traversal recursively. It also uses a visited[] array to ensure that no vertex is visited twice.
5.	User Input:
o	The program prompts the user to enter the number of vertices and edges. Then, it asks for the edges in the form of pairs of integers representing the vertices connected by each edge. The user also provides the start vertex for both BFS and DFS.
6.	Output:
o	The BFS and DFS traversals starting from the specified vertex are printed out, showing the order in which vertices are visited.
Sample Output
Enter the number of vertices: 10
Enter the number of edges: 12
Enter the edges (u v) where u and v are vertices (0 to 9):
0 1
0 2
1 3
1 4
2 5
3 6
4 7
5 8
6 9
7 8
8 9
5 9
Enter the start vertex for BFS and DFS (0 to 9): 0
BFS Traversal: A B C D E F G H I J 
DFS Traversal: A B D E G H I C F J 
Explanation of the Sample Output:
•	BFS Traversal: 
o	BFS starts from vertex A (index 0). It visits A, then its neighbors B and C. Then, it explores D and E, and so on, until all vertices are visited.
•	DFS Traversal: 
o	DFS starts from vertex A (index 0). It explores as deep as possible before backtracking. Starting from A, it visits B, then recursively visits D, then backtracks and visits E, and so on, following the depth-first strategy.
Conclusion:
1.	BFS is better for finding shortest paths and exploring graphs level-by-level.
2.	DFS is more suited for problems requiring pathfinding, connectivity analysis, or exhaustive exploration.
3.	Both algorithms have their specific use cases depending on the problem at hand.

*/
