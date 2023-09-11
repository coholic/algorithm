def solution(n, a, b):
    if a > b:
        a, b = b, a
    cnt = 0
    while True:
        if a//2 != b//2 and a+1 == b:
            cnt += 1
            break
        if a % 2 != 0:
            a //= 2
            a += 1
        else:
            a //= 2
        if b % 2 != 0:
            b //= 2
            b += 1
        else:
            b //= 2
        cnt += 1
    return cnt
