from collections import deque


def solution(dirs):
    answer = 0
    cnt = 0
    visited = []
    queue = deque(list(map(str, dirs)))
    # 가로 0~10까지 세로 0~10까지 중심 5,5
    graph = [[0 for _ in range(11)] for _ in range(11)]
    graph[5][5] = 1
    x, y = 5, 5
    while queue:
        # 명령어에 따른 dx,dy
        i = queue.popleft()
        if i == 'U':
            dx, dy = -1, 0
        elif i == 'D':
            dx, dy = 1, 0
        elif i == 'R':
            dx, dy = 0, 1
        elif i == 'L':
            dx, dy = 0, -1
        # 범위를 넘어갔을 때
        if x+dx < 0 or x+dx > 10 or y+dy < 0 or y+dy > 10:
            continue
        # 다음 위치를 처음 방문할 때, 출발 <-> 도착 경로에 없을 경우
        if graph[x+dx][y+dy] == 0 or (x, y, x+dx, y+dy) not in visited:
            # 출발 도착 경로를 포함
            visited.append((x, y, x+dx, y+dy))
            visited.append((x+dx, y+dy, x, y))
            cnt += 1
            graph[x+dx][y+dy] = cnt
        x += dx
        y += dy
    for i in graph:
        print(i)
    return cnt
