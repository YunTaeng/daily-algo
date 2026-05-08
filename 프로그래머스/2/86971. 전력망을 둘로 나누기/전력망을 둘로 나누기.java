class Solution {
	static int [] parent;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0;i<wires.length ;i++) {
        	parent = new int[n+1];
        	for(int j=1;j<=n;j++) {
        		parent[j]=j;
        	}
        	for(int j=0;j<wires.length;j++) {
        		if(i==j) continue;
        		union(wires[j][0], wires[j][1]);
        	}
        	
        	
        	int teamA = 0;
            int rootOfOne = find(1);
            for (int j = 1; j <= n; j++) {
                if (find(j) == rootOfOne) teamA++;
            }
            int teamB = n - teamA;
            int diff = Math.abs(teamA - teamB);
        	answer = Math.min(answer, diff);
        	
        }
        
        return answer;
    }
    
	static private void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		if(roota!=rootb) parent[roota]=rootb;
	}
	
	static private int find(int x) {
		if (parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
} 