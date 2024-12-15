import java.util.*;

public class KruskalMST {
    
    // Union-Find data structure
    static class UnionFind {
        int[] parent;
        int[] rank;
        
        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
                int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
                void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
   static class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
     // Kruskal's algorithm to find MST
    public static void kruskalMST(int V, List<Edge> edges) {
        UnionFind uf = new UnionFind(V);
                // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e.weight));
                List<Edge> mst = new ArrayList<>();
        int mstWeight = 0;
                // Process each edge in sorted order
        for (Edge edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int weight = edge.weight;
                        // If adding this edge doesn't form a cycle, include it in the MST
            if (uf.find(u) != uf.find(v)) {
                uf.union(u, v);
                mst.add(edge);
                mstWeight += weight;
            }
        }
        
        // Print the MST
        System.out.println("Edges in MST:");
        for (Edge edge : mst) {
            System.out.println((char)(edge.u + 65) + " - " + (char)(edge.v + 65) + " with weight " + edge.weight);
        }
        System.out.println("Total weight of MST: " + mstWeight);
    }
       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
                System.out.print("Enter number of vertices (V): ");
        int V = sc.nextInt();
        
        System.out.print("Enter number of edges (E): ");
        int E = sc.nextInt();
        
        List<Edge> edges = new ArrayList<>();
                System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(u, v, weight));
        }
        
        // Run Kruskal's algorithm
        kruskalMST(V, edges);
        
        sc.close();
    }
}

/*
Kruskal's Algorithm
Kruskal's Algorithm builds the MST by adding edges in increasing order of weight 
while ensuring no cycles are formed.
Steps:
1.	Sort all edges by weight.
2.	Add the smallest edge to the MST, ensuring it doesn't form a cycle.
3.	Repeat until the MST has V−1 edges.
Algorithm:
1.	Sort all edges in non-decreasing order by weight.
2.	Initialize MST as an empty set.
3.	Add the smallest edge to the MST if it doesn’t form a cycle (use the Union-Find algorithm to detect cycles).
4.	Repeat until the MST has V−1 edges.
Example:
Graph: Same as above.
Sorted Edges:
•	(A, B, 1), (C, D, 2), (A, C, 3), (B, D, 4)
Steps of Kruskal's Algorithm:
1.	Add edge (A, B) → MST: {(A, B)}.
2.	Add edge (C, D) → MST: {(A, B), (C, D)}.
3.	Add edge (A, C) → MST: {(A, B), (C, D), (A, C)}.
Resulting MST: Same as Prim's MST.

Applications of Prim's and Kruskal's Algorithm
1.	Network Design:
o	Design minimum-cost networks (telecommunications, electrical grids, etc.).
o	Example: Connecting servers in a data center.
2.	Transportation:
o	Designing road, rail, or pipeline systems to minimize cost.
3.	Clustering:
o	MST is used in clustering techniques (e.g., K-means, hierarchical clustering).
4.	Approximation Algorithms:
o	MSTs are used in approximation algorithms for NP-hard problems like the Traveling Salesman Problem (TSP).
5.	Graph-Based Models:
o	Applications in 3D graphics, vision, and robotics (minimum spanning surfaces).


1.	Kruskal's Algorithm: A greedy algorithm that sorts the edges 
in non-decreasing order of weights and adds edges one by one to the spanning tree, 
ensuring no cycles are formed.

Time Complexity:
•	Kruskal’s Algorithm: O(E log E), where E is the number of edges. Sorting the edges 
takes O(E log E), and union-find operations take almost constant time, amortized by path compression.

In Kruskal's algorithm, we:
1.	Sort all edges in increasing order of weights.
2.	Add edges to the MST if they don't form a cycle, 
using a Union-Find (Disjoint Set Union) data structure.

Explanation of the Code:
Kruskal's Algorithm:
•	The algorithm sorts all edges based on their weights.
•	It uses Union-Find (Disjoint Set Union) to ensure no cycles are created 
when adding edges to the MST.
•	It continues adding edges to the MST until there are V-1 edges in the MST.


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