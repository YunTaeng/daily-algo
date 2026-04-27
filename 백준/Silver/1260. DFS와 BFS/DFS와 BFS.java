import java.io.*;
import java.util.*;

public class Main{
	static int N,M,V;
	static ArrayList<Integer>[] adj ;
	static StringBuilder sb = new StringBuilder();
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
		    adj[i] = new ArrayList<>();
		}
		
		for (int i=1;i <= M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		for (int i=1;i <= N;i++) {
			adj[i].sort((a,b)->{
				return a-b;
			});
		}
		
		visited = new boolean[N+1];
		DFS(V);
		sb.append("\n");
		
		visited = new boolean[N+1];
		BFS(V);
		
		System.out.println(sb.toString());
		
		br.close();
	} // main
	
	private static void DFS(int node) {
		visited[node]=true;
		sb.append(node).append(" ");
		for (int next : adj[node]) {
	        if (!visited[next]) {
	            DFS(next);
	        }
	    }
	}
	public static void BFS(int node) {
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(node);
		visited[node] = true;
		while(!que.isEmpty()) {
			node = que.poll();
			sb.append(node).append(" ");
			for (int next : adj[node]) {
		        if (!visited[next]) {
		        	visited[next] = true;
		            que.offer(next);
		        }
		    }
		}
	}
	
}


