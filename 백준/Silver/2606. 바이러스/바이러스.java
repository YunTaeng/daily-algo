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
        
        for (int i=0;i<N+1;i++) {
        	parent[i]=i;
        }
        
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
            union(a, b);
        }
        
        int root = find(1);
        int cnt=0;
        for(int i = 2 ; i<=N;i++) {
        	if (find(i)==root) {
        		cnt++;
        	}
        }
        
        System.out.println(cnt);
        
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
