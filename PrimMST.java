import java.util.*;
public class PrimMST {
        // Prim's algorithm to find MST
    public static void primMST(int V, List<List<int[]>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // Min-heap based on weight
        
        // Start from the first vertex (vertex 0)
        pq.add(new int[]{0, 0}); // {vertex, weight}
        
        int mstWeight = 0;
        List<String> mstEdges = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int u = edge[0];
            int weight = edge[1];
            
            // If this vertex has already been visited, skip it
            if (visited[u]) continue;
            
            visited[u] = true;
            mstWeight += weight;
            
            // Add the edge to MST (skip the starting vertex 0)
            if (weight > 0) {
                mstEdges.add((char)(u + 65) + " - " + (char)(edge[0] + 65) + " with weight " + weight);
            }
            
            // Add all the neighbors to the priority queue
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (!visited[v]) {
                    pq.add(new int[]{v, w});
                }
            }
        }
        
        // Print the MST
        System.out.println("Edges in MST:");
        for (String edge : mstEdges) {
            System.out.println(edge);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();
        
        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();
        
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }
        
        // Run Prim's algorithm
        primMST(V, adj);
        
        sc.close();
    }
}

/*
Prim's Algorithm
Prim's Algorithm grows the MST from a starting vertex by repeatedly adding 
the smallest edge that connects a vertex in the MST to a vertex outside the MST.
Steps:
1.	Start from any vertex.
2.	Add the smallest edge connecting a vertex in the MST to a vertex outside the MST.
3.	Repeat until all vertices are included.
Algorithm:
1.	Initialize the MST set with one vertex.
2.	Use a priority queue or array to find the minimum-weight edge 
connecting a vertex in the MST to a vertex outside.
3.	Add the edge and the new vertex to the MST.
4.	Repeat until all vertices are included.
Example:
Graph:
      A
   1 / \ 3
    B---C
   4 \ / 2
      D
Adjacency Matrix:
  A   B   C   D
A 0   1   3   0
B 1   0   0   4
C 3   0   0   2
D 0   4   2   0
Steps of Prim's Algorithm:
1.	Start at A.
2.	Add edge (A, B) → MST: {(A, B), 1}.
3.	Add edge (A, C) → MST: {(A, B), (A, C)}.
4.	Add edge (C, D) → MST: {(A, B), (A, C), (C, D)}.
Resulting MST:
    A
   / \
  B   C
       \
        D
Total Weight: 1+3+2=61 + 3 + 2 = 6


2.	Prim's Algorithm: Another greedy algorithm that grows the MST by adding 
the cheapest edge from the tree to a vertex outside the tree, starting from an arbitrary vertex.
Time Complexity:
•	Prim’s Algorithm: O(E log V), where V is the number of vertices and E is the number of edges.
It uses a priority queue (min-heap) to efficiently get the minimum edge at each step.
In Prim's algorithm, we:
1.	Start from any vertex and grow the MST by adding the cheapest edge that connects a vertex inside the tree to a vertex outside the tree.
Prim's Algorithm:
•	It starts with a random vertex and uses a priority queue (min-heap) 
to always add the smallest weight edge that connects a vertex inside the MST to a vertex outside the MST.
•	The algorithm terminates when all vertices are included in the MST.

Differences Between Prim's and Kruskal's Algorithm
Feature	Prim's Algorithm	Kruskal's Algorithm
Approach	Grows the MST one vertex at a time.	Grows the MST one edge at a time.
Data Structures	Priority Queue (Min-Heap) or Array for edge selection.	Union-Find (Disjoint Set) for cycle detection.
Graph Representation	Works efficiently with dense graphs (adjacency matrix).	Works efficiently with sparse graphs (edge list).
Edge Selection	Chooses the smallest edge that connects the MST to a new vertex.	Chooses the smallest edge that doesn’t form a cycle.
Cycle Detection	Not explicitly needed.	Explicitly required using Union-Find.
Initial Input	Requires a starting vertex.	Requires a sorted list of edges.
Time Complexity	O(E+VlogV) using Min-Heap.	O(ElogE+ElogV) using Union-Find.

Conclusion
•	Prim's Algorithm: Best suited for dense graphs where the number of edges is large relative to vertices.
•	Kruskal's Algorithm: Ideal for sparse graphs with fewer edges.
•	Kruskal’s algorithm sorts all edges
•	Prim’s algorithm grows the MST starting from an arbitrary vertex, adding edges one by one
Both algorithms yield the same MST but follow different strategies. The choice depends on the graph's characteristics and the specific application requirements.


*/