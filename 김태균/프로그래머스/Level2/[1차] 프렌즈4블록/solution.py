def solution(m, n, board):
    cnt = 0
    for i in range(m):
        board[i] = list(board[i])
    answer = 0
    data = []
    # 지울 블록 좌표 저장
    while True:
        for i in range(m-1):
            for j in range(n-1):
                tmp = board[i][j]
                if tmp == []:
                    continue
                if tmp == board[i][j+1] and tmp == board[i+1][j] and tmp == board[i+1][j+1]:
                    data.append((i, j))
                    data.append((i, j+1))
                    data.append((i+1, j))
                    data.append((i+1, j+1))

        data = list(set(data))

        # 좌표 삭제
        # 지운 블록 갯수 세기
        if data != []:
            cnt += len(data)
            for i in range(len(data)):
                x, y = data[i]
                board[x][y] = []
            data = []
        else:
            break

        # 블록 옮기기
        move = 1
        while move == 1:
            move = 0

            for i in range(m-1):
                for j in range(n):
                    if board[i][j] != [] and board[i+1][j] == []:
                        board[i+1][j] = board[i][j]
                        board[i][j] = []
                        move = 1

    for i in range(m):
        print(board[i])
    print(cnt)
    return cnt
