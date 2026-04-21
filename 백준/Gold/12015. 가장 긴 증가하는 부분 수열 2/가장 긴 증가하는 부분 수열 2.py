import sys
input = sys.stdin.readline
from bisect import bisect_left

n=int(input())
b=list(map(int,input().split()))

lst = []

for x in b:
    idx = bisect_left(lst,x)
    if idx == len(lst):
        lst.append(x)
    else:
        lst[idx]=x

print(len(lst))
