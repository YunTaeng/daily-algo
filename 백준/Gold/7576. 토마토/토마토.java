import java.util.*;
import java.io.*;

class Main {
	static int N,M;
	static int [][] arr;
	static Queue<int[]> que = new ArrayDeque<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        arr=new int [N][M];
        
        
        for(int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		arr[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if (arr[i][j]==1) {
        			que.add(new int[] {i,j});
        		}
        	}
        }
        

        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};
        
        while (!que.isEmpty()) {
        	int [] tmp = que.poll();
        	int x=tmp[0];
        	int y=tmp[1];
        	
        	for (int i=0;i<4;i++) {
        		int nx = x + dx[i];
        		int ny = y + dy[i];
        		
        		if (0<=nx&&nx<N&&0<=ny&&ny<M&&arr[nx][ny]==0) {
        			arr[nx][ny]=arr[x][y]+1;
        			que.add(new int[] {nx,ny});
        		}
        		
        	}
        }
        
        int maxday=0;
        
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if (arr[i][j]==0) {
        			System.out.println("-1");
        			return;
        		}
        		maxday=Math.max(maxday, arr[i][j]);
        	}
        }
        System.out.println(maxday-1);
        br.close();
    } // main
    
} // class