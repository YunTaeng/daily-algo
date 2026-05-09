import heapq

def solution(jobs):
    jobs.sort()
    
    count, prev_now, now, total_time = 0, -1, 0, 0
    heap = []
    
    while count < len(jobs):
        # 2. 현재 시간(now)까지 들어온 요청들을 전부 힙에 넣기
        for job in jobs:
            # 이전 작업 시작 시간(last_now)보다는 크고, 현재 시간(now)보다는 작거나 같은 요청
            if prev_now < job[0] <= now:
                # [소요시간, 요청시간] 순으로 넣어야 힙이 소요시간 짧은 걸 먼저 줌!
                heapq.heappush(heap, [job[1], job[0]])
        
        if len(heap) > 0:
            duration, request_time = heapq.heappop(heap)
            prev_now = now
            now += duration
            total_time += (now - request_time)
            count += 1 # 작업 완료 카운트
        else:
            # 4. 지금 당장 대기실에 아무도 없으면 시간만 1초 흐름
            now += 1
            
            
    return total_time // len(jobs)