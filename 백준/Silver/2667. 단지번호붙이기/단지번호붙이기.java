import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int [][] arr;
	static Queue<int[]> que = new ArrayDeque<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        N=Integer.parseInt(st.nextToken());
        arr=new int [N][N];
        
        for (int i=0;i<N;i++) {
        	String tmp = br.readLine();
        	for(int j=0;j<N;j++) {
        		arr[i][j]=(int)tmp.charAt(j)-'0';
        	}
        }
        

        for (int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(arr[i][j]==1) {
        			ans.add(BFS(i,j));
        		}
        	}
        }
        System.out.println(ans.size());
        ans.sort((a,b)->a-b);
        
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
        br.close();
    } // main
    
    public static int BFS(int i, int j) {
		que.offer(new int[] {i,j});
		arr[i][j]=0;
		int[] dx= {0,0,1,-1};
		int[] dy= {1,-1,0,0};
		int cnt=0;
		while(!que.isEmpty()) {
			int tmp[] = que.poll();
			cnt++;
			
			int x=tmp[0];
			int y=tmp[1];
			
			for (int k=0;k<4;k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				if (0<=nx && nx<N && 0<=ny && ny<N) {
					if(arr[nx][ny]==1) {
						arr[nx][ny]=0;
						que.offer(new int[] {nx,ny});
					}
				}
				
			}
			
		}//while
    	return cnt;
	}
    
    
} // class



/*
6 8
1 2
2 5
1 5
3 4
4 6
5 4
2 4
2 3
 
 * */