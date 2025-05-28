package graphDataStructure;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju_Algorithm {

	static class Edge {
		int src;
		int dst;

		public Edge(int src, int dst) {
			this.src = src;
			this.dst = dst;
		}
	}

	public static void main(String[] args) {
		int v = 5;

		ArrayList<Edge> graph[] = new ArrayList[v];

		createGraph(graph);
		
		ArrayList<Edge> graph1[] = new ArrayList[v];
		for (int i = 0; i < graph1.length; i++) {
			graph1[i] = new ArrayList<Edge>();
		}
		
		transpose(graph,v, graph1);
		
		topSort(graph, v, graph1);
		
		
	}

	private static void transpose(ArrayList<Edge>[] graph, int size, ArrayList<Edge> graph1[]) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<size; i++) {
			for(int j=0; j < graph[i].size(); j++) {
				Edge e = graph[i].get(j);
				int u = e.src;
				int v = e.dst;
				graph1[v].add(new Edge(v,u));
			}
		}
	
	}

	public static void createGraph(ArrayList<Edge> graph[]) {
		// to avoid java.lang.NullPointerException
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		// value initialization
		// for checking if cycle is directed or not.
		
		
		graph[0].add(new Edge(0, 2));
		
		graph[0].add(new Edge(0, 3));

		graph[1].add(new Edge(1, 0));

		graph[2].add(new Edge(2, 1));

		graph[3].add(new Edge(3, 4));
		
	}	
	
	public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> stack) {
		vis[curr] = true;
		
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			
			if(!vis[e.dst]) {
				topSortUtil(graph, e.dst, vis, stack);
			}
		}
		
		stack.push(curr);
	}
	
	public static void topSort(ArrayList<Edge> graph[], int V, ArrayList<Edge> graph1[]) {
		boolean[] vis = new boolean[V];
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < V; i++) {
			if(!vis[i]) {
				topSortUtil(graph, i, vis, stack);
			}
		}
		
		
		boolean[] v = new boolean[V];
		for (int i = stack.size()-1; i >= 0 ; i--) {
			
			if(!v[stack.get(i)]) {
				ArrayList<Integer> ans = new ArrayList<>();
				kosaraju(graph1, stack.get(i), v,ans);
				System.out.println(ans);
			}
			
//			System.out.println("Stack ::"+stack.get(i));
		}
		
	}
	
	public static void kosaraju(ArrayList<Edge> graph[], int curr, boolean[] vis, ArrayList<Integer> ans) {
		vis[curr] = true;
		ans.add(curr);
		
		for(int i=0; i< graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			
			if(!vis[e.dst]) {
				kosaraju(graph,e.dst, vis, ans);
			}
		}
	}
}
