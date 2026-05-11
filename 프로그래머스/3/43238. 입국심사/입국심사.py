def solution(n, times):
    left=0
    right=max(times)*n
    
    answer = 0
    
    while left<=right:
        mid=(left+right)//2
        
        can_test=0
        for t in times:
            can_test+=mid//t
        
        if n<=can_test:
            answer=mid
            right=mid-1
        else:
            left=mid+1
            
    return answer