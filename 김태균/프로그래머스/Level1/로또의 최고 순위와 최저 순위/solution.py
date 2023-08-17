def solution(lottos, win_nums):
    rank = [6, 6, 5, 4, 3, 2, 1]
    cnt = 0
    for i in lottos:
        if i in win_nums:
            cnt += 1
    cntMax = lottos.count(0)+cnt
    answer = []
    answer.append(rank[cntMax])
    answer.append(rank[cnt])
    return answer
