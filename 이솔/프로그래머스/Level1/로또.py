def solution(lottos, win_nums):
    count=0
    n=0
    
    for i in lottos:
        if i in win_nums:
            count+=1
        if i ==0:
            n+=1
        
    
    min=count
    max=count+n
    
    if min==0:
        min=6
    else:
        min=7-min
    if max==0:
        max=6
    else:
        max=7-max
    
    
    answer = [max,min]
    return answer