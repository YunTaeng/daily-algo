def solution(signals):    
    answer = 0

    while answer<5000000 :
        answer+=1
        all_yellow = True
        for i in range(len(signals)):
            G=signals[i][0]
            Y=signals[i][1]
            R=signals[i][2]
            tmp=answer%(G+Y+R)
            
            if not (G < tmp <= G + Y):
                all_yellow = False
                break
        if all_yellow:
            return answer
    return -1