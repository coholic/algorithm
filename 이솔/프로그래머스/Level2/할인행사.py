def solution(want, number, discount):
    answer = 0
    dis_want = []

    for i in range(len(want)):
        for j in range(number[i]):
            dis_want.append(want[i])
    dis_want.sort()

    for i in range(len(discount) - 9):
        arr = discount[i: i+10]
        arr.sort()
        if dis_want == arr:
            answer += 1

    return answer