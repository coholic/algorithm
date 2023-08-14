def solution(cards1, cards2, goal):
    answer = ''
    i = 0
    j = 0
    for k in range(len(goal)):
        if i < len(cards1):
            if cards1[i] == goal[k]:
                i += 1
                continue
        if j < len(cards2):
            if cards2[j] == goal[k]:
                j += 1
                continue
    if (i+j) == len(goal):
        answer = 'Yes'
    else:
        answer = 'No'
    return answer
