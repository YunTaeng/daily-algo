import java.util.*;
import java.io.*;

class Main {
	
	static int [] parent;
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int answer=0;
        parent = new int[N+1];
        int [] input=new int[N];
        for (int i=0;i<N+1;i++) {
        	parent[i]=i;
        }
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	union(a,b);
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
        	input[i]=Integer.parseInt(st.nextToken());
        }
        
        for(int i=0;i<N-1;i++) {
        	if(find(input[i])!=find(input[i+1])) {
    			answer+=1;
        	}
        }
        System.out.println(answer);

        
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
