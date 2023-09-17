def solution(n, words):
    answer = []
    location = -1
    for i in range(1, len(words)):
        if words[i-1][-1] != words[i][0]:
            location = i
            break
        if words.index(words[i]) != i:
            location = i
            break
    if location != -1:
        answer.append((location % n)+1)
        answer.append((location//n)+1)
    else:
        answer = [0, 0]

    return answer
