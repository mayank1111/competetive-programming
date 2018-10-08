// Java program for Kruskal's algorithm to find Minimum Spanning Tree
// of a given connected, undirected and weighted graph
import java.util.*;
import java.lang.*;
import java.io.*;

public class INOIPractice1 {
	static int V, E;
	static Edge[] edge;
	static long count=0;
	static subset[] subsets;

	// A class to represent a graph edge
	class Edge implements Comparable<Edge> {
		int src, dest, weight;

		// Comparator function used for sorting edges based on
		// their weight
		public int compareTo(Edge compareEdge) {
			return this.weight - compareEdge.weight;
		}
	};

	// A class to represent a subset for union-find
	class subset {
		int parent, rank;
	};

	// V-> no. of vertices & E->no.of edges
	// collection of all edges

	// Creates a graph with V vertices and E edges
	INOIPractice1(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; ++i) {
			edge[i] = new Edge();

		}
	}

	// A utility function to find set of an element i
	// (uses path compression technique)
	int find( int i) {
		// find root and make root as parent of i (path compression)
		if (subsets[i].parent != i)
			subsets[i].parent = find( subsets[i].parent);

		return subsets[i].parent;
	}

	// A function that does union of two sets of x and y
	// (uses union by rank)
	void Union( int x, int y) {
		int xroot = find( x);
		int yroot = find( y);

		// Attach smaller rank tree under root of high rank tree
		// (Union by Rank)
		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;

		// If ranks are same, then make one as root and increment
		// its rank by one
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	// The main function to construct MST using Kruskal's algorithm
	void KruskalMST() {
		Edge result[] = new Edge[V]; // Tnis will store the resultant MST
		int e = 0; // An index variable, used for result[]
		int i = 0; // An index variable, used for sorted edges
		for (i = 0; i < V; ++i)
			result[i] = new Edge();

		// Step 1: Sort all the edges in non-decreasing order of their
		// weight. If we are not allowed to change the given graph, we
		// can create a copy of array of edges
		Arrays.sort(edge);

		// Allocate memory for creating V ssubsets
		subsets = new subset[V+1];
		for (i = 0; i <= V; ++i)
			subsets[i] = new subset();

		// Create V subsets with single elements
		for (int v = 0; v <= V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0; // Index used to pick next edge

		// Number of edges to be taken is equal to V-1
		while (e < V - 1) {
			// Step 2: Pick the smallest edge. And increment the index
			// for next iteration
			Edge next_edge = new Edge();
			next_edge = edge[i++];

			int x = find( next_edge.src);
			int y = find(next_edge.dest);

			// If including this edge does't cause cycle, include it
			// in result and increment the index of result for next edge
			if (x != y) {
				result[e++] = next_edge;
				count+=next_edge.weight;
				Union( x, y);
			}
			// Else discard the next_edge
		}

		
	}

	// Driver Program
	public static void main(String[] args) {

		
		Scanner input = new Scanner(System.in);
		V = input.nextInt();
		E = input.nextInt();
		INOIPractice1 graph = new INOIPractice1(V, E);
		for (int i = 0; i < E; ++i) {
			edge[i].src = input.nextInt();
			edge[i].dest = input.nextInt();
			edge[i].weight = input.nextInt();
		}

		graph.KruskalMST();
		System.out.println(count);
	}
}
// This code is contributed by Aakash Hasija