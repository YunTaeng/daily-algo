import java.util.Arrays;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
    	int[][] dp = new int[n][m];
        
    	for( int[] tmp : puddles) {
    		dp[tmp[1]-1][tmp[0]-1] = -1;
    	}
    	dp[0][0]=1;
        
        for( int i =0; i< n ; i++) {
        	for( int j = 0 ; j<m;j++){
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) continue;
                
                
        		long sum = 0;
                if (i > 0) sum += dp[i - 1][j];
                if (j > 0) sum += dp[i][j - 1];

                dp[i][j] = (int)(sum % 1000000007);
        	}
        }
        
        // for( int i =0; i< n ; i++) {
        // 	for( int j = 0 ; j<m;j++){
        // 		System.out.printf("%d ",dp[i][j]);
        // 	}
        // 	System.out.println("");
        // }
        
        
        return dp[n-1][m-1]%1000000007;
    }
}