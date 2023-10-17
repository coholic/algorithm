from collections import deque


def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    length = len(queue1)+len(queue2)
    target = (sum(queue1) + sum(queue2))//2
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    cnt = 0
    for i in range(length*2):
        if sum1 > sum2:
            tmp = queue1.popleft()
            sum1 -= tmp
            sum2 += tmp
            queue2.append(tmp)
            cnt += 1
            continue
        if sum1 < sum2:
            tmp = queue2.popleft()
            sum1 += tmp
            sum2 -= tmp
            queue1.append(tmp)
            cnt += 1
            continue
        if sum(queue1) == sum(queue2):
            break
    if sum(queue1) == sum(queue2):
        return cnt
    else:
        return -1
