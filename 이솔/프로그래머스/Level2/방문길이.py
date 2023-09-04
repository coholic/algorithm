def solution(dirs):
    x,y=0,0
    answer = 0
    arr=[(0,0,"N")]
    for i in dirs:
        if i == "U":
            if y==5 :
                continue
            if (x,y,"U") not in arr and (x,y+1,"D") not in arr:
                answer+=1
                arr.append((x,y,"U"))
                arr.append((x,y+1,"D"))
            y+=1
        if i =="D":
            if  y==-5:
                continue
            if (x,y,"D") not in arr and (x,y-1,"U") not in arr:
                answer+=1
                arr.append((x,y,"D"))
                arr.append((x,y-1,"U"))
            y-=1
        if i=="R":
            if x==5 :
                continue
            
            if (x,y,"R") not in arr and (x+1,y,"L") not in arr:
                answer+=1
                arr.append((x,y,"R"))
                arr.append((x+1,y,"L"))
            x+=1
        if i=="L":
            if x==-5:
                continue
            
            if (x,y,"L") not in arr and (x-1,y,"R") not in arr:
                answer+=1
                arr.append((x,y,"L"))
                arr.append((x-1,y,"R"))
            x-=1
        
    return answer