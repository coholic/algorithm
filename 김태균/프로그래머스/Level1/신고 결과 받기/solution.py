def solution(id_list, report, k):
    report = list(set(report))
    result = [0]*len(id_list)
    mail = [0]*len(id_list)
    reporter = [[] for _ in range(len(id_list))]
    for item in report:
        a, b = map(str, item.split())
        reporter[id_list.index(a)].append(b)
        result[id_list.index(b)] += 1
    for i in range(len(reporter)):
        for j in reporter[i]:
            if result[id_list.index(j)] >= k:
                mail[i] += 1
    return mail
