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
        int [][] input=new int[N][N];
        int [] cityPlan = new int[M];
        
        for (int i=0;i<N+1;i++) {
        	parent[i]=i;
        }
        
        
        for (int i=0;i<N;i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0;j<N;j++) {
        		input[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<M;i++) {
        	cityPlan[i]=Integer.parseInt(st.nextToken());
        }
        
        for (int i=0;i<N-1;i++) {
        	for (int j=i+1;j<N;j++) {
        		if (input[i][j]==1) {
        			union(i,j);
        		}
        		
        	}
        }
        
        int mainParent=-1;
        boolean answer = true;
        for(int i = 0 ; i<M;i++) {
        	if(i==0) {
        		mainParent = find(cityPlan[i]-1);
        	}
        	else {
        		int tmpParent = find(cityPlan[i]-1);
        		if(mainParent!=tmpParent) {
        			answer=false;
        		}
        		
        	}
        }
        
        if (answer) System.out.println("YES");
        else System.out.println("NO");
        
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
