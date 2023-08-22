def solution(N, stages):
    arr=[[0]*2 for _ in range(N)]
    long=len(stages)
    for i in range(1,N+1):
        count=stages.count(i)
        arr[i-1][0]=i
        if count!=0:
            arr[i-1][1]=(count/long)
            long-=count

    arr.sort(key=lambda x: -x[1])
    answer=[]
    for i in arr:
        answer.append(i[0])
        
    return answer
