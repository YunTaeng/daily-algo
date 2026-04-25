def solution(n, costs):
    parent=[i for i in range(n+1)]
    costs.sort(key=lambda x:x[2])
    
    def find(x):
        if parent[x]==x:
            return x
        parent[x]=find(parent[x])
        return parent[x]
        
    def union(a,b):
        roota=find(a)
        rootb=find(b)
        if roota==rootb:
            return False
        parent[roota]=rootb
        return True
    
    answer=0
    cnt=0
    for a,b,val in costs:
        if union(a,b):
            answer+=val
            cnt+=1
            if cnt==n-1:
                break
        
    return answer