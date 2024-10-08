package graphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Bellman_Ford_Algorithm {

	static class Edge {
		int src;
		int dst;
		int weight;

		public Edge(int src, int dst, int weight) {
			this.src = src;
			this.dst = dst;
			this.weight = weight;
		}
	}

	static class Pair implements Comparable<Pair> {
		int node;
		int dst;

		public Pair(int node, int dst) {
			this.node = node;
			this.dst = dst;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.dst - o.dst;
		}
	}

	static int k = Integer.MAX_VALUE;
	List<List<Integer>> ans = new ArrayList<>();

	public static void main(String[] args) {
		int v = 5;

		ArrayList<Edge> graph[] = new ArrayList[v];

		createGraph(graph);

		bellman_ford(graph, v, 0);
		System.out.println("Is negative cycle detected ? :: "+detectNegativeCycles(graph, v, 0));
//		System.out.println(k);
	}

	// un-directed non-weighted graph
	public static void createGraph(ArrayList<Edge> graph[]) {
		// to avoid java.lang.NullPointerException
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));

		graph[1].add(new Edge(1, 2, -4));

		graph[2].add(new Edge(2, 3, 2));

		graph[3].add(new Edge(3, 4, 4));
		
		graph[4].add(new Edge(4, 1, -1));
	}

	// worst - O(n^3) and best - O(n*n)
	public static void bellman_ford(ArrayList<Edge> graph[], int V, int src) {
		if (graph.length == 0) {
			return;
		}

		int[] distance = new int[V];

		for (int i = 0; i < distance.length; i++) {
			if (i != src) {
				distance[i] = Integer.MAX_VALUE;
			}
		}

		for (int k = 0; k < V - 1; k++) {

			for (int i = 0; i < V; i++) {
				for (int j = 0; j < graph[i].size(); j++) {
					Edge e = graph[i].get(j);
					int u = e.src;
					int v = e.dst;
					if (distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]) {
						distance[v] = distance[u] + e.weight;
					}
				}
			}

		}

		System.out.println(Arrays.toString(distance));
	}

	// worst - O(n^3) and best - O(n*n)
	public static boolean detectNegativeCycles(ArrayList<Edge> graph[], int V, int src) {
		if (graph.length == 0) {
			return false;
		}

		int[] distance = new int[V];

		for (int i = 0; i < distance.length; i++) {
			if (i != src) {
				distance[i] = Integer.MAX_VALUE;
			}
		}

		for (int k = 0; k < V - 1; k++) {

			for (int i = 0; i < V; i++) {
				for (int j = 0; j < graph[i].size(); j++) {
					Edge e = graph[i].get(j);
					int u = e.src;
					int v = e.dst;
					if (distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]) {
						distance[v] = distance[u] + e.weight;
					}
				}
			}

		}

		for (int k = 0; k < 1; k++) {

			for (int i = 0; i < V; i++) {
				for (int j = 0; j < graph[i].size(); j++) {
					Edge e = graph[i].get(j);
					int u = e.src;
					int v = e.dst;
					if (distance[u] != Integer.MAX_VALUE && distance[u] + e.weight < distance[v]) {
						return true;
					}
				}
			}

		}

		return false;
	}

}
