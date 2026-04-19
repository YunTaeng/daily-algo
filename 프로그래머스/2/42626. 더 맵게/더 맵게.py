import heapq

def solution(scoville, K):
    answer = 0
    
    heapq.heapify(scoville)
    
    while len(scoville)>=2:
        first = heapq.heappop(scoville)
        if first>=K:
            return answer
        
        second= heapq.heappop(scoville)
        heapq.heappush(scoville,first+second*2)
        answer+=1
        
    if scoville[0] >= K:
        return answer
    else:
        return -1