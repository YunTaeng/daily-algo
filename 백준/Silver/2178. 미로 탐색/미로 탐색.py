import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]
    queue = deque([(0, 0)])
    while queue:
        curx, cury = queue.popleft()
        for i in range(4):
            nx, ny = curx + dx[i], cury + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if arr[nx][ny] == 1:
                    arr[nx][ny]=arr[curx][cury]+1
                    queue.append((nx, ny))
    return arr[n-1][m-1]

n,m = map(int, input().split())

arr = [list(map(int,input().strip())) for _ in range(n)]

print(bfs())