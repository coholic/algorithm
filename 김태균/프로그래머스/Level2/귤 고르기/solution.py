from collections import Counter


def solution(k, tangerine):
    answer = 0
    count = Counter(tangerine)
    temp = list(count.values())
    temp.sort(reverse=True)
    for value in temp:
        k -= value
        answer += 1
        if k <= 0:
            break
    return answer
