import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] maps) {
        Deque<int []> que = new ArrayDeque<>();
        int N = maps.length;
        int M = maps[0].length;
        
        que.offer(new int[] {0,0});
        int [] dx = {0,0,1,-1};
        int [] dy = {1,-1,0,0};
        
        while(!que.isEmpty()) {
        	int tmp[] = que.poll();
        	if(tmp[0]==N-1 && tmp[1]==M-1) return maps[N-1][M-1];
        	for (int i = 0 ; i<4 ;i++) {
        		int nx = tmp[0]+dx[i]; int ny = tmp[1]+dy[i];
        		if(0<=nx && nx<N && 0<=ny && ny<M) {
        			if (maps[nx][ny]==1) {
        				maps[nx][ny]=maps[tmp[0]][tmp[1]]+1;
        				que.offer(new int[] {nx,ny});
        			}
        		}
        		
        		
        	}
        	
        }
        if(maps[N-1][M-1]==1) return -1;
        return maps[N-1][M-1];
    }
}