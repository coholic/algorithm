import copy


def solution(want, number, discount):
    answer = 0
    cnt = 0
    for i in range(len(discount) - sum(number)+1):
        num_tmp = copy.deepcopy(number)
        for j in range(i, i+10):
            if discount[j] in want:
                idx = want.index(discount[j])
                num_tmp[idx] -= 1
        for k in num_tmp:
            if k != 0:
                cnt -= 1
                break
        cnt += 1
    return cnt
