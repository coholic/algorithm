from collections import deque


def solution(people, limit):
    people.sort(reverse=True)
    queue = deque(people)
    answer = 0
    while queue:
        tmp = queue.popleft()
        answer += 1
        std = limit - tmp
        for i in range(len(queue)):
            if std >= queue[i]:
                queue.remove(queue[i])
                break
    return answer
