from collections import Counter

def solution(k, tangerine):
    arr=Counter(tangerine)
    # print(arr)
    arr1=list(arr.values())
    arr1.sort(reverse=True)
    count=0
    while k>0:
        k-=arr1[count]
        count+=1
        
    answer = count
    return answer