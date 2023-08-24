def solution(a, b, n):
    answer = 0
    while n>=a:
        k=(n//a)
        l=k*b
        n=(n%a)+l
        
        answer+=l
        
    return answer