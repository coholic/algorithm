a=int(input())
count=0
for i in range(0,a):
    arr=list(input())
    for i in arr:
        if i=="(":
            count+=1
        elif i==")":
            count-=1
            if count<0:
                count=-1
                break
        else:
            count=-1
            break
    
    if count==0:
        print("YES")
    else:
        print("NO")
    count=0