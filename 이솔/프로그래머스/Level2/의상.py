def solution(clothes):
    clo={}
    for i in clothes:
        item=i[0]
        cate=i[1]
        
        if cate in clo:
            clo[cate].append(item)
        else:
            clo[cate] = [item]

    answer=1
    for key in clo.keys():
        answer = answer * (len(clo[key]) + 1)
    return answer - 1
