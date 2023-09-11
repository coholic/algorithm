def solution(prices):
    result = [0] * len(prices)
    for i in range(len(prices)):
        for j in range(i+1, len(prices)):
            result[i] += 1
            if prices[j] < prices[i]:
                break
    return result
