package graphDataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tarjans_Algorithm {

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

		dfs(graph, 0, new boolean[v]);
		
		System.out.println();
		
		bfs(graph, 0, new boolean[v]);
		
		System.out.println();
		
		getBridge(graph,v);

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
//		graph[3].add(new Edge(3, 5));

		graph[4].add(new Edge(4, 3));
//		graph[4].add(new Edge(4, 5));

//		graph[5].add(new Edge(5, 3));
//		graph[5].add(new Edge(5, 4));

	}

	private static void dfs(ArrayList<Edge> graph[], int curr, boolean[] vis) {
		if (vis[curr]) {
			return;
		}
		vis[curr] = true;
		System.out.print(curr + " ");
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			dfs(graph, e.dst, vis);
		}

	}

	private static void bfs(ArrayList<Edge> graph[],int src, boolean[] vis) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(src);
		vis[src] = true;
		while (!queue.isEmpty()) {
			int value = queue.remove();
			System.out.print(value+" ");
				
				for (int i = 0; i < graph[value].size(); i++) {
					Edge e = graph[value].get(i);
					if(!vis[e.dst]) {
						vis[e.dst] = true;
						queue.add(e.dst);
					}
					
				}

			
		}
	}
	
	
	private static void getBridge(ArrayList<Edge> graph[] , int v) {
		int dt[] = new int[v];
		int lowDt[] = new int[v];
		
		int time = 0;
		
		boolean[] vis = new boolean[v];
		
		for(int i=0; i<v; i++) {
			if(!vis[i]) {
				dfsTarjans(graph, i, vis, dt, lowDt, time, -1);
			}
		}
	}

	private static void dfsTarjans(ArrayList<Edge>[] graph, int curr, boolean[] vis, int[] dt, int[] lowDt, int time,
			int parent) {
		// TODO Auto-generated method stub
		vis[curr] = true;
		
		dt[curr] = lowDt[curr] = ++time;
		
		for(int i=0; i<graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			
			if(e.dst == parent) {
				continue;
			} else if( !vis[e.dst]) {
				dfsTarjans(graph, e.dst, vis, dt, lowDt, time, curr);
				lowDt[curr] = Math.min(lowDt[curr],  lowDt[e.dst]);
//				System.out.println(Arrays.toString(lowDt));
				if(dt[curr] < lowDt[e.dst]) {
					System.out.println("Bridge is :: "+curr+" <---> "+e.dst);
				}
			} else {
				lowDt[curr] = Math.min(lowDt[curr],  dt[e.dst]);
			}
		}
	}

}
