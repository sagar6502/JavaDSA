package graphDataStructure;

import java.util.ArrayList;
import java.util.Stack;

public class DirectedGraph {

	static class Edge {
		int src;
		int dst;

		public Edge(int src, int dst) {
			this.src = src;
			this.dst = dst;
		}
	}

	public static void main(String[] args) {
		int v = 6;

		ArrayList<Edge> graph[] = new ArrayList[v];

		createGraph(graph);
		
		topSort(graph, v);
		
		/* to check if graph has cycle from any end
		boolean[] vis = new boolean[v];
		boolean[] rec = new boolean[v];
		boolean hasCycle =false;
		for(int i=0; i<v; i++) {
			if(!vis[i]) {
				hasCycle = isCycleDirected(graph, vis, 0, rec);
				if(hasCycle) {
					 System.out.println(hasCycle);
					break;
				}else {
					System.out.println("False");
				}
			}
		}
		*/
//		System.out.println(hasCycle);
	}

	public static void createGraph(ArrayList<Edge> graph[]) {
		// to avoid java.lang.NullPointerException
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		// value initialization
		// for checking if cycle is directed or not.
		
		/*
		graph[0].add(new Edge(0, 2));

		graph[1].add(new Edge(1, 0));

		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 0));
		*/
		
		graph[4].add(new Edge(4, 1));

		graph[4].add(new Edge(4, 0));

		graph[2].add(new Edge(2, 3));

		graph[3].add(new Edge(3, 1));
		
		graph[5].add(new Edge(5, 0));

		graph[5].add(new Edge(5, 2));
	}
	
	public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean[] vis, int curr, boolean rec[]) {
		vis[curr] = true;
		rec[curr] = true;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			if(rec[e.dst]) {
				return true;
			}else if(!vis[e.dst]) {
				if(isCycleDirected(graph,vis,e.dst,rec)) {
					return true;
				}
			}
		}
		
		rec[curr] = false;
		
		return false;
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
	
	public static void topSort(ArrayList<Edge> graph[], int V) {
		boolean[] vis = new boolean[V];
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < V; i++) {
			if(!vis[i]) {
				topSortUtil(graph, i, vis, stack);
			}
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}
	}
}
