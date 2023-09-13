def solution(skill, skill_trees):
    answer = 0
    arr=list(map(str,skill))
    for i in skill_trees:
        words=list(map(str,i))
        n=1
        answer+=1
        for j in words:
            if j not in arr:
              continue
            elif j in arr[:n]:
                n+=1            
            else:
                answer-=1
                break

    return answer