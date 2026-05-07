class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        int [][] dp =  new int[N][N];
        
        dp[0][0]=triangle[0][0];
        
        for(int i = 1 ; i< N ; i ++) {
        	for(int j = 0;j<=i;j++) {
        		if(j==0) dp[i][j]=dp[i-1][j]+triangle[i][j];
        		else if (j==i) dp[i][j]=dp[i-1][j-1]+triangle[i][j];
        		else dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
        	}
        }
        int maxsum = -1;
        
//        for(int i = 0 ; i< N ; i ++) {
//        	for(int j = 0;j<=i;j++) {
//        		System.out.printf("%d ",dp[i][j]);
//        	}
//        	System.out.println("");
//        }
        
        for(int i = 0 ; i< N ; i ++) {
        	if(maxsum<dp[N-1][i]) maxsum=dp[N-1][i];
        }
        return maxsum;
    }
}