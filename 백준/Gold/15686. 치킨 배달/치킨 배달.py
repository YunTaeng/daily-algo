import sys
from itertools import combinations

input = sys.stdin.readline

house=[]
chicken=[]

n,m = map(int,input().split())

for r in range(n):
    row = list(map(int, input().split()))
    for c in range(n):
        if row[c] == 1:
            house.append([r, c])
        elif row[c] == 2:
            chicken.append([r, c])


totalmin=999999
# n:배열크기 m:남길치킨집수 
for selected_chicken in combinations(chicken, m):
    mindistsum=0
    
    for h in house:
        combin_min = 999999
        for c in selected_chicken:
            dist = abs(h[0]-c[0])+abs(h[1]-c[1])
            combin_min=min(combin_min,dist)
        mindistsum+=combin_min
    totalmin=min(totalmin,mindistsum)
print(totalmin) 


