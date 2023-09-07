def solution(today, terms, privacies):
    answer = []
    for i in terms:
        x, y = i.split(' ')
        for j in range(len(privacies)):
            k, l = privacies[j].split(' ')
            if x == l:
                date = k.split('.')
                a = int(date[1]) + int(y)
                if a > 12:
                    if a % 12 == 0:
                        a -= 12
                        date[0] = str(int(date[0])+int(a)//12)
                        date[1] = '12'
                    else:
                        date[0] = str(int(date[0])+int(a)//12)
                        date[1] = '0' + str(int(a) % 12)
                else:
                    if a == 12:
                        date[1] = str(a)
                    else:
                        date[1] = '0' + str(int(a) % 12)
                if len(date[1]) == 3:
                    date[1] = date[1][1:3]
                s = '.'.join(date)
                if s <= today:
                    answer.append(j+1)
    answer.sort()
    return answer
