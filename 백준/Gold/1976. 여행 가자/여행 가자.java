import java.util.*;
import java.io.*;

class Main {
	
	static int [] parent;
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(br.readLine());
        
        parent = new int[N+1];
        int [] cityPlan = new int[M];
        
        for (int i=0;i<N+1;i++) {
        	parent[i]=i;
        }
        
        
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<N;j++) {
        		int isConnected = Integer.parseInt(st.nextToken());
                if (isConnected == 1) {
                    union(i, j);
                }
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<M;i++) {
        	cityPlan[i]=Integer.parseInt(st.nextToken());
        }
        
        int root = find(cityPlan[0] - 1);
        for (int i = 1; i < M; i++) {
            if (find(cityPlan[i] - 1) != root) {
                System.out.println("NO");
                return; // 하나라도 다르면 바로 끝!
            }
        }
        System.out.println("YES");
        
        br.close();
    } // main
    
    
    static public int find(int x) {
    	if (parent[x]==x) return x;
    	parent[x]=find(parent[x]);
    	return parent[x];
    }
    
    static public void union(int x,int y) {
    	int rootx = find(x);
    	int rooty = find(y);
    	if (rootx!=rooty) parent[rootx]=rooty;
    }
    
} // class
