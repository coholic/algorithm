def solution(today, terms, privacies):
    terms_alpa=[]
    terms_num=[]
    for i in range(0,len(terms)):
        a,b=terms[i].split()
        terms_alpa.append(a)
        terms_num.append(b)
    
    date=[]
    y,m,d=today.split(".")
    for i in range(0,len(privacies)):
        a,b=privacies[i].split()
        date.append(a.split("."))
        for k in range(0,len(terms)):
            if b==terms_alpa[k]:
                date[i][1]=(int(date[i][1])+int(terms_num[k]))
                if date[i][1]>12:          
                    if date[i][1]%12==0:
                        date[i][0]=str(int(date[i][0])+(int(date[i][1])//12)-1)
                        date[i][1]="12"                 
                    else:
                        date[i][0]=str(int(date[i][0])+int(date[i][1]//12))
                        if date[i][1]%12<10:
                            date[i][1]=str("0"+str(int(date[i][1])%12))
                        else:
                            date[i][1]=str(int(date[i][1])%12)
                elif date[i][1]<10:
                     date[i][1]=str("0"+str(date[i][1]))
                else:
                    if  date[i][1]<10:
                        date[i][1]=str("0"+str(date[i][1]))
                    else:
                        date[i][1]=str(date[i][1])
    answer=[]
    for i in range(0,len(privacies)):
        print(date[i])
        print(today)
        if y>date[i][0]:
            answer.append(i+1)
        elif y==date[i][0] and m>date[i][1]:
            answer.append(i+1)
        elif y==date[i][0] and m==date[i][1] and d>=date[i][2]:
            answer.append(i+1)
    print(date)
#     count=0
#     for i in date:
        
#         s=".".join(i)
#         if s<=today:
#             answer.append(count+1)
#         count+=1
    

    
    return answer