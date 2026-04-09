import sys
from collections import deque
from itertools import combinations, permutations

# sys.setrecursionlimit(10000)

input = sys.stdin.readline

def solve():
    n=int(input())
    times=list(map(int,input().split()))
    times.sort()

    ans=0
    sum=0
    for time in times:
        sum+=time
        ans+=sum

    print(ans)

if __name__ == "__main__":
    solve()