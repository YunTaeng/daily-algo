import sys

def solve():
    n_str = sys.stdin.readline().strip()
    n = int(n_str)
    
    ans = [0] * 10
    
    start = 1
    digit = 1
    
    while start <= n:
        # 현재 자릿수보다 큰 단위에서 n을 처리
        left = n // (digit * 10)
        current = (n // digit) % 10
        right = n % digit
        
        for i in range(10):
            # i가 나올 수 있는 횟수 계산
            if i == 0:
                # 0은 맨 앞자리에 올 수 없으므로 특수 처리
                ans[i] += (left - 1) * digit
                if current > 0:
                    ans[i] += digit
                else:
                    ans[i] += right + 1
            else:
                ans[i] += left * digit
                if i < current:
                    ans[i] += digit
                elif i == current:
                    ans[i] += right + 1
                    
        start *= 10
        digit *= 10
        
    print(*ans)

solve()