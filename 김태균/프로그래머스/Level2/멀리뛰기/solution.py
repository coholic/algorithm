def solution(n):
    item = [0]*(2001)
    item[1] = 1
    item[2] = 2
    if n > 2:
        for i in range(3, n+1):
            item[i] = item[i-1]+item[i-2]
    return item[n] % 1234567
