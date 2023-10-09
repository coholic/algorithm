from collections import deque


def solution(bridge_length, weight, truck_weights):
    bridge = deque([0] * bridge_length)
    truck_weights = deque(truck_weights)
    weight_tmp = 0
    cnt = 0
    while len(bridge):
        cnt += 1
        weight_tmp -= bridge.popleft()
        if truck_weights:
            if weight >= weight_tmp + truck_weights[0]:
                truck = truck_weights.popleft()
                bridge.append(truck)
                weight_tmp += truck
            else:
                bridge.append(0)
    return cnt
