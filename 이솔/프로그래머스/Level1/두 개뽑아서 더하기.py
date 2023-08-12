def solution(numbers):
    a = len(numbers)
    answer = []
    for i in range(0, a-1):
        for j in range(i+1, a):
            k = numbers[i]+numbers[j]
            if k not in answer:
                answer.append(k)
    answer.sort()
    print(answer)

    return answer
