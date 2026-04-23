import java.util.*;
import java.io.*;

public class Main {
	static class Point {
		public int i;
		public int j;
		Point (int i,int j){
			this.i=i;
			this.j=j;
		}
		
	};
	static int N,M;
	static int [][] input;
	static boolean[] selected;
	static List<Point> emptySpaces = new ArrayList<>();
	static int maxSafeZone =0;
	public static Queue<Point> queue = new LinkedList<Point>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        input = new int [N][M];

        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		input[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(input[i][j] == 0) emptySpaces.add(new Point(i, j));
            }
        }
        
        selected = new boolean[emptySpaces.size()];
        makeWall(0,0);
        System.out.println(maxSafeZone);
        
    }//main
    
    static void makeWall(int start, int count) {
        if(count == 3) {
            // 벽 3개 설치 후 -> BFS로 바이러스 퍼뜨리기 -> 빈칸 개수 세기 -> Max 갱신
            bfs(); 
            return;
        }
        for(int i=start; i<emptySpaces.size(); i++) {
        	Point p = emptySpaces.get(i);
            input[p.i][p.j] = 1; // 벽 설치
            makeWall(i + 1, count + 1);
            input[p.i][p.j] = 0; // 벽 제거 (백트래킹)
        }
    }
    static void bfs() {
    	int[][] tmp = new int[N][M];
        for(int i = 0; i < N; i++) tmp[i] = input[i].clone();

        // 2. 큐 초기화 및 바이러스 위치 넣기
        Queue<Point> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tmp[i][j] == 2) q.add(new Point(i, j));
            }
        }

        // 3. BFS 수행
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(!q.isEmpty()) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.i + dx[i];
                int ny = p.j + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && tmp[nx][ny] == 0) {
                    tmp[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }
        }

        // 4. 안전 영역(0) 개수 세기
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tmp[i][j] == 0) cnt++;
            }
        }
        maxSafeZone = Math.max(maxSafeZone, cnt);
    }
    
}//Main