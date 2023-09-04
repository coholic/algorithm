def solution(wallpaper):
    max_x1=0
    max_y1=0
    min_x1=50
    min_y1=50
    
    for i in range(0,len(wallpaper)):
        for j in range(0,len(wallpaper[0])):
            if wallpaper[i][j]=="#":
                if min_x1>i:
                    min_x1=i
                if min_y1>j:
                    min_y1=j
                if max_x1<i:
                    max_x1=i
                if max_y1<j:
                    max_y1=j
    answer = [min_x1,min_y1,max_x1+1,max_y1+1]
    return answer