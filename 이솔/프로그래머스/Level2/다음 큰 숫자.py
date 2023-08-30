def solution(n):
#     count=0
#     num=0
#     arr=[]
#     k=n
    
#     while n>0:
#         a=n%2
#         n=(n-a)//2
        
#         arr.append(a)
#         if a==1:
#             k+=1
    
#     for i in range(0,len(arr)):
#         num+=arr[i]*(10**(count))
#         count+=1
        
    for i in range(n+1,1000000):
        if bin(n).count('1')==bin(i).count('1'):
            answer=i
            break    
    
    return answer