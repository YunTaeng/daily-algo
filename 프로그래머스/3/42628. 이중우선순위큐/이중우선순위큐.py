import heapq
def solution(operations):
    answer = []
    heap=[]
    for op in operations:
        oper,num = op.split()
        num=int(num)
        
        if oper=='I':
            heapq.heappush(heap,num)
        elif oper=='D' and heap:
            if num==1:
                heap.remove(max(heap))
                heapq.heapify(heap)
            elif num==-1:
                heapq.heappop(heap)
    if not heap:
        return [0, 0]
    return [max(heap), heap[0]]