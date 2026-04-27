import java.io.*;
import java.util.*;

public class Main {
	static int N,M,V;
	static int [][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<int[]> que = new ArrayDeque<>();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr=new int[N][M];
		
		for (int i=0;i < N;i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
		        arr[i][j] = line.charAt(j) - '0';
		    }
		}
		
		que.offer(new int []{0,0});
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		while(!que.isEmpty()) {
			int [] tmp = que.poll();
			int x = tmp[0];
			int y = tmp[1];
			for(int i =0;i<4;i++) {
				int nx = x+dx[i];
				int ny=  y+dy[i];
				if(0<=nx&&nx<N && 0<=ny&&ny<M) {
					if (arr[nx][ny]==1) {
						arr[nx][ny]=arr[x][y]+1;
						que.offer(new int []{nx,ny});
					}
				}
				
				
			}
		}
		
		System.out.println(arr[N-1][M-1]);
		br.close();
	} // main
	
}