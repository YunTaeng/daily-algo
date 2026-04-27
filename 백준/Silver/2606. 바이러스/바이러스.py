N = int(input())
M = int(input())

adj = [[] for _ in range(N)]
visited = [False]* N
for _ in range(M):
    a,b =map(int,input().split())
    adj[a-1].append(b-1)
    adj[b-1].append(a-1)

def BFS(u):
    visited[u]=True

    for v in adj[u]:
        if not visited[v]:
            BFS(v)

BFS(0)

cnt=0
for i in range(1,N):
    if visited[i]:
        cnt+=1

print(cnt)