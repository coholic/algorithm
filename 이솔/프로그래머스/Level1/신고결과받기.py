def solution(id_list, report, k):
    report=list(set(report))
    arr_1=[[] for _ in range(len(id_list))]
    answer=[]
    report_target=[0]*(len(id_list))
    
    for i in report:
        a,b=map(str,i.split())
        arr_1[id_list.index(a)].append(b)
        report_target[id_list.index(b)]+=1
        
    for i in arr_1:
        count=0
        for j in i:
            if report_target[id_list.index(j)]>=k:
                count+=1
        answer.append(count)
            
    
    return answer