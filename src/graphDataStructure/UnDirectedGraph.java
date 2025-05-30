package graphDataStructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnDirectedGraph {

	/*
	 * Graph is a non-linear data structure consisting of vertices and edges. The
	 * vertices are sometimes also referred to as nodes and the edges are lines or
	 * arcs that connect any two nodes in the graph. More formally a Graph is
	 * composed of a set of vertices( V ) and a set of edges( E ). The graph is
	 * denoted by G(V, E).
	 * 
	 * Components of a Graph:
	 * 
	 * Vertices: Vertices are the fundamental units of the graph. Sometimes,
	 * vertices are also known as vertex or nodes. Every node/vertex can be labeled
	 * or unlabeled.
	 * 
	 * Edges: Edges are drawn or used to connect two nodes of the graph. It can be
	 * ordered pair of nodes in a directed graph. Edges can connect any two nodes in
	 * any possible way. There are no rules. Sometimes, edges are also known as
	 * arcs. Every edge can be labelled/unlabelled.
	 */

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

	/*
	 * This graph implementation is done by Adjacency list method. It is efficient
	 * for finding neighbors.
	 */

	public static void main(String[] args) {
		int v = 7;

		ArrayList<Edge> graph[] = new ArrayList[v];

		createGraph(graph);
		
		findAllPath(graph,0,3);

		/*
		// print the neighbors of 2
		for (int i = 0; i < graph[2].size(); i++) {
			System.out.println(graph[2].get(i).dst + " , " + graph[2].get(i).weight);
		}

		System.out.println();
		bfs(graph, v);
		System.out.println();
		boolean[] vis = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (vis[i] == false) {
				bfs1(graph, v, vis, i);
			}
		}
		
		System.out.println();
		System.out.println("\nDFS are:: ");
		boolean[] visited = new boolean[v];
		
		for(int i=0;i<v;i++) {
			if (visited[i] == false) {
				dfs(graph,i,visited);
			}
		}
		*/
	}

	// un-directed non-weighted graph
	public static void createGraph(ArrayList<Edge> graph[]) {
		// to avoid java.lang.NullPointerException
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		// value initialization
		/*
		graph[0].add(new Edge(0, 2, 2));

		graph[1].add(new Edge(1, 2, 10));
		graph[1].add(new Edge(1, 3, 0));

		graph[2].add(new Edge(2, 0, 2));
		graph[2].add(new Edge(2, 1, 10));
		graph[2].add(new Edge(2, 3, -1));

		graph[3].add(new Edge(3, 1, 0));
		graph[3].add(new Edge(3, 2, -1));
		*/
		
		
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 2));
		
		graph[1].add(new Edge(1, 3, 10));
		graph[1].add(new Edge(1, 0, 2));
		
		graph[2].add(new Edge(2, 0, 2));
		graph[2].add(new Edge(2, 4, 4));
		
		graph[3].add(new Edge(3, 1, 0));
		graph[3].add(new Edge(3, 4, 7));
		graph[3].add(new Edge(3, 5, 2));
		
		graph[4].add(new Edge(4, 5, 2));
		graph[4].add(new Edge(4, 2, 4));
		graph[4].add(new Edge(4, 3, 7));
		
		graph[5].add(new Edge(5, 3, 2));
		graph[5].add(new Edge(5, 4, 2));
		graph[5].add(new Edge(5, 6, 4));
		
		graph[6].add(new Edge(6, 5, 4));
		
		
		
	}

	// for connected components
	public static void bfs(ArrayList<Edge> graph[], int V) {
		if (graph.length == 0) {
			return;
		}

		Queue<Integer> q = new LinkedList<>();

		boolean[] visitArray = new boolean[V];

		q.add(0);

		while (!q.isEmpty()) {

			int curr = q.remove();

			if (!visitArray[curr]) {
				System.out.print(curr + " ");
				visitArray[curr] = true;

				for (int i = 0; i < graph[curr].size(); i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dst);
				}
			}

		}
	}

	// for disconnected components: where all the components are not connected
	public static void bfs1(ArrayList<Edge> graph[], int V, boolean[] visitArray, int start) {
		if (graph.length == 0) {
			return;
		}

		Queue<Integer> q = new LinkedList<>();

		q.add(start);

		while (!q.isEmpty()) {

			int curr = q.remove();

			if (!visitArray[curr]) {
				System.out.print(curr + " ");
				visitArray[curr] = true;

				for (int i = 0; i < graph[curr].size(); i++) {
					Edge e = graph[curr].get(i);
					q.add(e.dst);
				}
			}

		}
	}
	

	// for connected components
	public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis) {
		if(vis[curr]) {
			return;
		}
		System.out.print(curr+" ");
		vis[curr] = true;
		for(int i=0; i<graph[curr].size();i++) {
			Edge e = graph[curr].get(i);
			dfs(graph,e.dst,vis);
		}
		
	}
	
	List<List<Integer>> ans = new ArrayList<>(); 
	static void findAllPath(ArrayList<Edge> graph[], int src, int dst) {
		boolean[] vis = new boolean[graph.length];
		dfs1(graph,src,dst,vis,"");
	}
	
	
	// O ( v^v)
	public static void dfs1(ArrayList<Edge> graph[], int curr, int dst, boolean[] vis,String path) {
		if(curr == dst ) {
			path += Integer.toString(curr);
			System.out.print(path+" ");
			return;
		}
		
		for(int i=0; i<graph[curr].size();i++) {
				if(!vis[curr]) {
					vis[curr] = true;
					Edge e = graph[curr].get(i);
					dfs1(graph,e.dst,dst,vis,path+Integer.toString(curr));
					vis[curr] = false;
				}
	
		}
		
	}

}
