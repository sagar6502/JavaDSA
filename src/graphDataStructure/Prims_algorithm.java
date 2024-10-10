package graphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Prims_algorithm {

	static class Edge {
		int src;
		int dst;
		int weight;

		public Edge(int src, int dst, int weight) {
			this.src = src;
			this.dst = dst;
			this.weight = weight;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.src+" : "+this.dst+" : "+this.weight;
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


	public static void main(String[] args) {
		int v = 4;

		ArrayList<Edge> graph[] = new ArrayList[v];

		createGraph(graph);

		primsAlgorithm(graph,v,0);
//		System.out.println(k);
	}

	// un-directed non-weighted graph
	public static void createGraph(ArrayList<Edge> graph[]) {
		// to avoid java.lang.NullPointerException
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 2, 15));
		graph[0].add(new Edge(0, 3, 30));

		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 3, 40));

		graph[2].add(new Edge(2, 0, 15));
		graph[2].add(new Edge(2, 3, 50));

		graph[3].add(new Edge(3, 0, 30));
		graph[3].add(new Edge(3, 1, 40));
		graph[3].add(new Edge(3, 2, 50));

	}

	
	// O(E+ ElogV)
	/**
	 * @param graph
	 * @param V
	 * @param src
	 */
	public static void primsAlgorithm(ArrayList<Edge> graph[], int V,int src) {
		if (graph.length == 0) {
			return;
		}

		PriorityQueue<Pair> q = new PriorityQueue<>();

		int[] parent = new int[V];
		boolean[] visitArray = new boolean[V];

		ArrayList<Edge> ans = new ArrayList<>();

		q.offer(new Pair(src, 0));
		int cost = 0;

		while (!q.isEmpty()) {
			Pair curr = q.remove();
			
			if (!visitArray[curr.node]) {
				visitArray[curr.node] = true;
				cost += curr.dst;
				ans.add(new Edge(parent[curr.node],curr.node,curr.dst));
				for (int i = 0; i < graph[curr.node].size(); i++) {
					Edge e = graph[curr.node].get(i);
					int v = e.dst;
					if(!visitArray[v]) {
						parent[v] = curr.node;
						q.add(new Pair(v,e.weight));
					}
					
				}
			}

		}
		
		System.out.println(cost);
		System.out.println(ans);
	}

}
