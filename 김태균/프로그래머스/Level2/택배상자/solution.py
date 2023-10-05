from collections import deque


def solution(order):
    sub = []
    i = 0
    cnt = 0
    while i != len(order):
        sub.append(i+1)
        while sub and sub[-1] == order[cnt]:
            cnt += 1
            sub.pop()
        i += 1
    print(cnt)
    return cnt
