import sys
input = sys.stdin.readline

N = int(input())
col = [False] * N
diag1 = [False] * (2 * N)
diag2 = [False] * (2 * N)
cnt = 0

def placequeen(rows):
    global cnt
    if rows == N:
        cnt += 1
        return
    
    for i in range(N):
        if not col[i] and not diag1[rows + i] and not diag2[rows - i + N]:
            col[i] = diag1[rows + i] = diag2[rows - i + N] = True
            
            placequeen(rows + 1)

            col[i] = diag1[rows + i] = diag2[rows - i + N] = False

placequeen(0)
print(cnt)