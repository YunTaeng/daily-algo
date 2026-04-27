from queue import PriorityQueue
import sys
input = sys.stdin.readline

N,M,X =map(int,input().split())
X-=1
adj=[[] for _ in range(N)]
radj=[[] for _ in range(N)]

for _ in range(M):
    u,v,w = map(int,input().split())
    adj[u-1].append((v-1,w))
    radj[v-1].append((u-1,w))

dist= [1e9] * N
rdist= [1e9] * N
pq = PriorityQueue()

dist[X]=0
pq.put((0,X)) #길이 , 노드번호

while pq.qsize()!=0:
    d,u = pq.get()
    if d!=dist[u]:
        continue

    for v,w in adj[u]:
        if dist[v] > dist[u]+w:
            dist[v] = dist[u]+w
            pq.put((dist[v],v))




rdist[X]=0
pq.put((0,X)) #길이 , 노드번호

while pq.qsize()!=0:
    d,u = pq.get()
    if d!=rdist[u]:
        continue

    for v,w in radj[u]:
        if rdist[v] > rdist[u]+w:
            rdist[v] = rdist[u]+w
            pq.put((rdist[v],v))

max_dist = 0
for i in range(N):
    if max_dist < dist[i]+rdist[i]:
        max_dist = dist[i]+rdist[i]

print(max_dist)