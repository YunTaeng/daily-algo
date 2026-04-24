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
        
        parent = new int[N+1];
        
        for (int i=0;i<N+1;i++) {
        	parent[i]=i;
        }
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int oper = Integer.parseInt(st.nextToken());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	if (oper==0) union(a,b);
        	else if (oper==1) {
        		if(find(a)==find(b)) {
        			sb.append("YES\n");
        		}
        		else {
        			sb.append("NO\n");
        		}
        	}
        }
        
        System.out.println(sb.toString());
        
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
