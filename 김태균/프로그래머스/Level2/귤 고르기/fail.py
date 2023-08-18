def solution(k, tangerine):
    answer = 0
    count = []
    temp = set(tangerine)
    temp = list(temp)
    for i in temp:
        count.append(tangerine.count(i))
    count.sort(reverse=True)
    for i in count:
        k -= i
        answer += 1
        if k <= 0:
            break
    return answer
