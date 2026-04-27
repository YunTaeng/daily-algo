import java.util.Arrays;

class Solution {
	static int [] parent;
    static public int find(int x) {
    	if (parent[x]==x) return x;
    	parent[x]=find(parent[x]);
    	return parent[x];
    }
    
    static public boolean union(int x,int y) {
    	int rootx = find(x);
    	int rooty = find(y);
    	if (rootx!=rooty) {
    		return false;
    	}
    	parent[rootx]=rooty;
    	return true;
    }
    
    public int solution(int n, int[][] costs) {
    	int answer = 0;
        parent = new int [n+1]; 
        
        for (int i=0;i<n+1;i++) {
        	parent[i]=i;
        }
        
        Arrays.sort(costs, (a,b)->{
        	return a[2]-b[2];
        });
        
        for (int i=0;i<costs.length;i++){
            int a=costs[i][0];
            int b=costs[i][1];
            int val=costs[i][2];
            
            if(union(a,b)) {
            	answer+=val;
            }
            
        }
        
        return answer;
    }
    
    
}