
import java.util.*;
import java.io.*;

public class Main {
	static int N;
    static List<Integer>[] adj;
    static int[] parent;
    static boolean[] visited;
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for (int i = 1; i<N+1 ;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i<N-1 ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			adj[u].add(v);
			adj[v].add(u);
		}
		
		parent = new int[N + 1];
        visited = new boolean[N + 1];
		
        dfs(1);

        // 4. 2번 노드부터 부모 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }//main
	
	static void dfs(int now) {
        visited[now] = true;

        for (int next : adj[now]) {
            if (!visited[next]) {
                parent[next] = now; // 다음 노드의 부모는 바로 '나'
                dfs(next);
            }
        }
    }


}//class
