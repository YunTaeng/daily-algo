import sys
input = sys.stdin.readline


n=int(input())

b=list(map(int,input().split()))


dp = [1] * n

for i in range(n):
    for j in range(i):
        if b[j] < b[i]:
            dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))

