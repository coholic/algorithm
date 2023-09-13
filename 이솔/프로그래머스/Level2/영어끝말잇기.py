def solution(n, words):
    answer=[0,0]
    arr=[]
    arr.append(words[0])
    for i in range(1,len(words)):
        pre_word=list(map(str,words[i-1]))
        word=list(map(str,words[i]))
        if words[i] in arr or pre_word[-1] !=word[0] :
            print(words[i],pre_word[-1],word[0])
            a=(i+1)%n
            b=((i+1)//n)+1
            if a==0:
                a=n
                b-=1
            
            
            answer=[a,b]
            break
            
        arr.append(words[i])
        
    return answer