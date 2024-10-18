package graphDataStructure;

import java.util.ArrayList;

public class Articulation_Point {

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

		getAP(graph, v);
	}

	public static void createGraph(ArrayList<Edge> graph[]) {
		// to avoid java.lang.NullPointerException
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Edge>();
		}

		// value initialization

		graph[0].add(new Edge(0, 2));
		graph[0].add(new Edge(0, 1));
		graph[0].add(new Edge(0, 3));

		graph[1].add(new Edge(1, 0));
		graph[1].add(new Edge(1, 2));

		graph[2].add(new Edge(2, 0));
		graph[2].add(new Edge(2, 1));

		graph[3].add(new Edge(3, 4));
		graph[3].add(new Edge(3, 0));

		graph[4].add(new Edge(4, 3));

	}


	private static void getAP(ArrayList<Edge> graph[], int v) {
		int dt[] = new int[v];
		
		int low[] = new int[v];
		
		boolean[] vis = new boolean[v];
		
		int time =0;
		
		boolean[] ap = new boolean[v];
		
		
		for(int i=0; i<v; i++) {
			if(!vis[i]) {
				dfs(graph,i,-1, dt,low,vis,time,ap );
			}
		}
		
		for(int i=0; i<v; i++) {
			if(ap[i]) {
				System.out.println("articulation point : "+i);
			}
		}
		
	}
	
	
	private static void dfs(ArrayList<Edge> graph[], int curr, int parent, int dt[], int[] low, boolean[] vis, int time, boolean[] ap) {

		vis[curr] = true;
		dt[curr] = low[curr] = ++time;
		int children = 0;
		
		for(int i=0; i< graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			
			int neigh = e.dst;
			
			if(parent == neigh) {
				continue;
			}
			
			else if(vis[neigh]) {
				low[curr] = Math.min(low[curr], dt[neigh]);
			}
			
			else {
				dfs(graph, neigh, curr, dt, low, vis, time, ap);
				low[curr] = Math.min(low[curr], low[neigh]);
				
				if(dt[curr] <= low[neigh] && parent != -1) {
					ap[curr] = true;
				}
				
				children++;
				
			}
			
			
			
			
		}
		
		if(parent == -1 &&  children > 1) {
			ap[curr] = true;
		}
	}
	
}
