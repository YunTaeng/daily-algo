from collections import deque
def solution(maps):
    rows = len(maps)
    cols = len(maps[0])
    
    dx=[0,0,-1,1]
    dy=[1,-1,0,0]
    queue=deque([(0,0)])
    
    while queue:
        x,y=queue.popleft()
        if x==rows-1 and y==cols-1:
            return maps[x][y]
        for i in range(4):
            nx, ny = x+dx[i],y+dy[i]
            if 0<=nx<rows and 0<=ny<cols:
                if maps[nx][ny]==1:
                    maps[nx][ny]=maps[x][y]+1
                    queue.append((nx,ny))
    
    return -1