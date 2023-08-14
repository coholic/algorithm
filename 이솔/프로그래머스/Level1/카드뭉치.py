def solution(cards1, cards2, goal):
    count1=0
    count2=0
    answer = ''
    for i in goal:
        if count1<len(cards1):
            if i==cards1[count1]:
                count1+=1
        if count2<len(cards2):
            if i==cards2[count2]:
                count2+=1

    if count1+count2==len(goal):
        answer="Yes"
    else:
        answer="No"
    return answer