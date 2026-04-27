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
        
        for (int i=1;i<N+1;i++) {
        	parent[i]=i;
        }
        
        
        for (int i=0;i<M;i++) {
        	st = new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	if(a>b) {
        		int tmp =a;
            	a = b;
            	b=tmp;
        	}
            union(a, b);
        }
        
        
        HashSet<Integer> hs = new HashSet<>();
        
        
        for(int i = 1;i<N+1;i++) {
        	hs.add(find(i));
        }
        
        
        
        System.out.println(hs.size());
        
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