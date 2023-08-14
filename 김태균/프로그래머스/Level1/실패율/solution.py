def solution(N, stages):
    answer = []
    fail = [[0] * 2 for _ in range(N)]
    remainStages = len(stages)
    for i in range(1, N+1):
        fail[i-1][0] = i
        if stages.count(i) != 0:
            fail[i-1][1] = stages.count(i)/remainStages
            remainStages = remainStages - stages.count(i)
    print(fail)
    fail.sort(key=lambda x: -x[1])
    for i in fail:
        answer.append(i[0])
    return answer
