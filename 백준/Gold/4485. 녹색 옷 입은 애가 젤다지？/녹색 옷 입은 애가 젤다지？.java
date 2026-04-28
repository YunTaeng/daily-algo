import java.util.*;
import java.io.*;

class Main {
	static final int INF = Integer.MAX_VALUE;
	static int [][] input;
	static int [][] dist; 
	static int N=-1;
	static StringBuilder sb = new StringBuilder();
	static class Node implements Comparable<Node> {
	    int x, y, cost;
	    public Node(int x, int y, int cost) {
	        this.x = x; this.y = y; this.cost = cost;
	    }
	    @Override
	    public int compareTo(Node o) {
	        return this.cost - o.cost; // 비용이 적은 순서대로!
	    }
	}
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int cnt=0;
        while(true) {
        	
        	N = Integer.parseInt(br.readLine());
        	if(N==0) break;
            input = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) {
            	st = new StringTokenizer(br.readLine());
            	for(int j =0;j<N;j++) {
            		input[i][j] = Integer.parseInt(st.nextToken());
            	}
            	
            }
            dijkstra();
            
            cnt++;
            sb.append("Problem ").append(cnt).append(": ").append(dist[N-1][N-1]).append("\n");
        }//while
        
        
        
        System.out.print(sb.toString());
    }//main
    
    public static void dijkstra() {
        for(int[] row : dist) Arrays.fill(row, INF);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = input[0][0]; 
        pq.offer(new Node(0, 0, dist[0][0]));
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            
            // 더 나은 경로가 이미 확정되었다면 패스
            if (cur.cost > dist[cur.x][cur.y]) continue;
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (dist[nx][ny] > dist[cur.x][cur.y] + input[nx][ny]) {
                        dist[nx][ny] = dist[cur.x][cur.y] + input[nx][ny];
                        pq.offer(new Node(nx, ny, dist[nx][ny]));
                    }
                }
            }
            
        }//while
        
        
    }
} // class