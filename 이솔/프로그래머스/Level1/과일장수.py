def solution(k, m, score):
    answer = 0
    score.sort()
    a=len(score)
    b=a//m
    
    if b==0:
        answer=0
    elif b==1:
        answer=score[-m]
    else:
        for i in range(0,b):
            k=-i*m-m
            answer+=score[k]
    answer*=m
    return answer