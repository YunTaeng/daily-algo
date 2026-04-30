def solution(routes):
    answer = 0
    
    routes.sort(key=lambda x:x[1])
    last_camera=-30001
    for start,end in routes:
        if start>last_camera:
            answer+=1
            last_camera=end
    
    return answer