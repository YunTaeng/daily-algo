import java.io.*;
import java.util.*;

class Solution {
	static int[] ans;
	static int anscnt=0;
	static int W,H;
	static char[][] arr;
    public int[] solution(String[] maps) {
        
    	W=maps.length;
    	H=maps[0].length();
    	
    	arr = new char[W][H];
    	
    	for (int i = 0; i < W; i++) {
            arr[i] = maps[i].toCharArray();
        }
    	
    	List<Integer> ansList = new ArrayList<>();
        
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                // 숫자를 발견하면 BFS 시작
                if (arr[i][j] != 'X') {
                    ansList.add(BFS(i, j));
                }
            }
        }
        if (ansList.isEmpty()) return new int[]{-1};
        Collections.sort(ansList);
        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }
	private static int BFS(int x,int y) {
		int[] dx= {0,0,1,-1};
		int[] dy= {1,-1,0,0};
		int sum=0;
		Queue<int []> que = new ArrayDeque<>();
		sum+=arr[x][y]-'0';
		arr[x][y]='X';
		que.offer(new int[] {x,y});
		
		while(!que.isEmpty()) {
			int tmp[] = que.poll();
			for(int i=0;i<4;i++) {
				int nx=tmp[0]+dx[i]; int ny=tmp[1]+dy[i];
				if(0<=nx&&nx<W&&0<=ny&&ny<H && '1'<=arr[nx][ny]&&arr[nx][ny]<='9' ) {
					sum+=(arr[nx][ny]-'0');
					arr[nx][ny]='X';
					que.offer(new int[]{nx, ny});
				}
				
			}
			
		}
		return sum;
	}//BFS END
    
}