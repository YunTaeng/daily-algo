import java.util.*;

class Solution {
    static int W, H;
    static char[][] map;

    public int solution(String[] maps) {
        W = maps.length;
        H = maps[0].length();
        map = new char[W][H];

        int[] sPos = new int[2], lPos = new int[2], ePos = new int[2];

        for (int i = 0; i < W; i++) {
            map[i] = maps[i].toCharArray();
            for (int j = 0; j < H; j++) {
                if (map[i][j] == 'S') sPos = new int[]{i, j};
                else if (map[i][j] == 'L') lPos = new int[]{i, j};
                else if (map[i][j] == 'E') ePos = new int[]{i, j};
            }
        }

        // 1. S -> L 최단 거리
        int toLever = bfs(sPos[0], sPos[1], 'L');
        if (toLever == -1) return -1;

        // 2. L -> E 최단 거리
        int toExit = bfs(lPos[0], lPos[1], 'E');
        if (toExit == -1) return -1;

        return toLever + toExit;
        
    }
    
    private int bfs(int startX, int startY, char target) {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    boolean[][] visited = new boolean[W][H];
    Queue<int[]> que = new ArrayDeque<>();
        
    que.offer(new int[]{startX, startY, 0});
    visited[startX][startY] = true;

    while (!que.isEmpty()) {
        int[] curr = que.poll();
        int x = curr[0], y = curr[1], time = curr[2];

        if (map[x][y] == target) return time;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];

            if (nx >= 0 && nx < W && ny >= 0 && ny < H && map[nx][ny] != 'X' && !visited[nx][ny]) {
                visited[nx][ny] = true;
                que.offer(new int[]{nx, ny, time + 1});
            }
        }
    }
    return -1;
}
}