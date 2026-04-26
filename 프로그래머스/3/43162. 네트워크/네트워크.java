class Solution {
    static boolean [] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited=new boolean[n];
        
        for (int i=0; i<n;i++){
            if (!visited[i]){
                answer++;
                dfs(i,n,computers);
            }
        }
        
        
        return answer;
    }//main
    
    static void dfs(int now, int n, int[][] computers){
        visited[now]=true;
        for(int next=0;next<n;next++){
            if ( now != next && computers[now][next]==1 && !visited[next]) dfs(next,n,computers);
        }
    }
    
}//Mainclass