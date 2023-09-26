def pack(n):
    sum=1
    for i in range(1,n+1):
        sum*=i
    return sum
def solution(n):
    answer = 1
    a=n//2

    # b=n%2    
#     if b==1:
#         for i in range(1,a+1):
#             answer+=(pack(n-(i*2)+i)//pack(i))//pack(n-(i*2))
    
#     else:
#         for i in range(1,a):
#             answer+=(pack(n-(i*2)+i)//pack(i))//pack(n-(i*2))
#         answer+=1
    for i in range(1,a+1):
      answer+=(pack(n-(i*2)+i)//pack(i))//pack(n-(i*2))
    
    
    answer=answer%1234567
    return answer