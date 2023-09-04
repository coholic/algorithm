def solution(people, limit):
    people.sort()
    start=0
    last=len(people)-1
    answer = 0
    while start<=last:
        if people[last]+people[start]<=limit:
            answer+=1
            start+=1
            last-=1
        else:
            last-=1
            answer+=1
    # answer+=1
    return answer