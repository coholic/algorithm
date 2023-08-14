def list_split(a, n):
    return [a[i:i+n] for i in range(0, len(a), n)]


def solution(k, m, score):
    score.sort(reverse=True)
    scoreA = list_split(score, m)
    answer = 0
    for i in scoreA:
        if len(i) == m:
            answer += (min(i)*m)
    return answer
