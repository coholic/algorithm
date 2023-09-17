def solution(skill, skill_trees):
    cnt = 0
    skillList = list(map(str, skill))
    for item in skill_trees:
        strtmp = ''
        tmp = list(map(str, item))
        for i in tmp:
            if i in skillList:
                strtmp += i
        if skill.find(strtmp) == 0:
            cnt += 1
    return cnt
