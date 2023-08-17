def solution(a, b, n):
    answer = 0
    result = 0
    while n >= a:
        result = n - ((n//a)*a) + (n//a)*b
        answer += ((n//a)*b)
        n = result
    return answer
