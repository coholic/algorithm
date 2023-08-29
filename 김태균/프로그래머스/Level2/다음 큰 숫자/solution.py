def solution(n):
    for i in range(n+1, 1000000):
        if bin(n).count('1') == bin(i).count('1'):
            answer = i
            break
    return answer
