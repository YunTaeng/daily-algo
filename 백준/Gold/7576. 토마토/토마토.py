import sys
from collections import deque
input = sys.stdin.readline

m,n = map(int,input().split())
arr=[list(map(int,input().split())) for _ in range(n)]

queue = deque()
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            queue.append((i, j))


dx = [0,0,-1,1]
dy = [1,-1,0,0]
def bfs():
    while queue:
        curx,cury= queue.popleft()
        for i in range(4):
            nx,ny = curx+dx[i],cury+dy[i]
            if 0<=nx<n and 0<=ny<m:
                if arr[nx][ny]==0:
                    arr[nx][ny]=arr[curx][cury]+1
                    queue.append((nx,ny))

bfs()

ans = 0
for row in arr:
    for tomato in row:
        if tomato == 0:
            print(-1)
            exit() 
        ans = max(ans, tomato)
print(ans - 1)