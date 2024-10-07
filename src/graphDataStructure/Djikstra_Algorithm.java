package graphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Djikstra_Algorithm {

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
			return this.dst-o.dst;
		}
	}

	static int k = Integer.MAX_VALUE;
	List<List<Integer>> ans = new ArrayList<>();

	public static void main(String[] args) {
		int v = 6;

		ArrayList<Edge> graph[] = new ArrayList[v];

		createGraph(graph);

		djikstra(graph,v,0);
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

		graph[1].add(new Edge(1, 2, 1));
		graph[1].add(new Edge(1, 3, 7));

		graph[2].add(new Edge(2, 4, 3));

		graph[3].add(new Edge(3, 5, 1));

		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
	}

	
	// O(E+ ElogV)
	public static void djikstra(ArrayList<Edge> graph[], int V,int src) {
		if (graph.length == 0) {
			return;
		}

		PriorityQueue<Pair> q = new PriorityQueue<>();

		boolean[] visitArray = new boolean[V];

		int[] distance = new int[V];
		
		for (int i = 0; i < distance.length; i++) {
			if(i != src) {
				distance[i] = Integer.MAX_VALUE;
			}
		} 

		q.offer(new Pair(0, 0));

		while (!q.isEmpty()) {

			Pair curr = q.remove();

			if (!visitArray[curr.node]) {
				visitArray[curr.node] = true;

				for (int i = 0; i < graph[curr.node].size(); i++) {
					Edge e = graph[curr.node].get(i);
					int u = e.src;
					int v = e.dst;

					// relaxation
					if (distance[u] + e.weight < distance[v]) {
						distance[v] = distance[u] + e.weight;
						q.offer(new Pair(v, distance[v]));
					}
				}
			}

		}
		
		System.out.println(Arrays.toString(distance));
	}

}
